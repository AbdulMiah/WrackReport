package cf.ac.uk.wrackreport.fullcontainer;

import cf.ac.uk.wrackreport.data.interfaces.WrackReportRepository;
import cf.ac.uk.wrackreport.data.jpa.entities.ReportEntity;
import cf.ac.uk.wrackreport.data.jpa.entities.UserEntity;
import cf.ac.uk.wrackreport.service.CategoryService;
import cf.ac.uk.wrackreport.service.ReportService;
import cf.ac.uk.wrackreport.service.dto.ReportDTO;
import cf.ac.uk.wrackreport.service.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@DirtiesContext
public class ReportSearches {

    @Autowired
    MockMvc mvc;

    @Test
    public void shouldGet12ReportsAsJSON() throws Exception {
        mvc.perform(get("/api/reports").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(12)));
    }

    @ParameterizedTest
    @CsvSource({"SA, 3", "SY2, 2", "LD2 3NL, 1", "S, 6"})
    public void shouldGetNReportsFromSearchAsJSON(String search, String countAsString) throws Exception{
        Integer count = Integer.valueOf(countAsString);
        mvc.perform(get("/api/report/exportQuery?postcode="+search+"&localAuthority=&categoryName=&dateFrom=&dateTo=&showRemoved=false").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(count)));
    }

    @ParameterizedTest
    @CsvSource({"6, 200","12, 200", "20, 404", "123, 404"})
    public void shouldGetRightStatusFromAPIAsJSON(Long furl, String status) throws Exception{

        int statusCode = Integer.valueOf(status);

        mvc.perform(get("/api/report/"+furl).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(statusCode));
    }
}
