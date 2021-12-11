package cf.ac.uk.wrackreport.fullcontainer;

import cf.ac.uk.wrackreport.data.jpa.repositories.UserRepository;
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
public class Users {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MockMvc mvc;

    @Test
    public void shouldGet12UsersAsJSON() throws Exception{
        mvc.perform(get("/api/users").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(12)));

    }

    @ParameterizedTest
    @CsvSource({"john,2","sarah, 1", "jimmy, 0"})
    public void shouldGetSearchedUserJSON(String search, String countAsString) throws Exception{
        Integer count = Integer.valueOf(countAsString);
        mvc.perform(get("/api/users?search=" + search).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(count)));

    }


}
