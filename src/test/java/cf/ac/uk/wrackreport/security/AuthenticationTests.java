package cf.ac.uk.wrackreport.security;

import cf.ac.uk.wrackreport.api.report.ReportAPIController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = {ReportAPIController.class})
@AutoConfigureMockMvc
public class AuthenticationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    @WithMockUser(username = "testuser@gmail.com", password = "password", roles = "USER")
    void shouldAccessReportInfoPage() throws Exception {
        mockMvc.perform(get())
    }

}
