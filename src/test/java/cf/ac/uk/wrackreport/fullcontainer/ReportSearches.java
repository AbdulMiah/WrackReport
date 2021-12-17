package cf.ac.uk.wrackreport.fullcontainer;

import cf.ac.uk.wrackreport.service.ReportService;
import cf.ac.uk.wrackreport.service.dto.ReportDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
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
    @CsvSource({"6, 200","12, 200", "20, 404", "15, 404"})
    public void shouldGetRightStatusFromAPIAsJSON(Long furl, String status) throws Exception{

        int statusCode = Integer.valueOf(status);

        mvc.perform(get("/api/report/"+furl).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(statusCode));
    }
}
