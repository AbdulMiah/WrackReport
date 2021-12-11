package cf.ac.uk.wrackreport.jpa;

import cf.ac.uk.wrackreport.data.jpa.entities.MediaEntity;
import cf.ac.uk.wrackreport.data.jpa.entities.ReportEntity;
import cf.ac.uk.wrackreport.data.jpa.entities.UserEntity;
import cf.ac.uk.wrackreport.data.jpa.repositories.ReportRepository;
import cf.ac.uk.wrackreport.data.jpa.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;



import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@DirtiesContext
public class UserDataJPATests {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ReportRepository reportRepository;


    @Test
    public void shouldGetTwelveUsers() throws Exception{
        List<UserEntity> userList = userRepository.findAll();
        assertEquals(12, userList.size());
    }

    @Test
    public void shouldGetThirteenUsersAfterInput() throws Exception{
        UserEntity newUser = new UserEntity(null, "ROLE_USER", "test", "user", "test@gmail.com", "08847567364", "testpass", true);
        userRepository.save(newUser);
        List<UserEntity> userList = userRepository.findAll();
        assertEquals(13, userList.size());
    }

    @Test
    public void userIsLinkedToReport() throws Exception {
        // Given new report with user
        UserEntity testUser = new UserEntity(null, "ROLE_USER", "test", "user", "test@gmail.com", "08847567364", "testpass", true);
        List<MediaEntity> media = new ArrayList<MediaEntity>();
        MediaEntity testMedia = new MediaEntity(null,null,null,"testMedia",1,"testpath");
        media.add(testMedia);
        ReportEntity testReport = new ReportEntity(null, testUser, (short)2, "test desc", (short)2, 0.2f, "51.896156,-3.933956", "2021-11-19 22:20:00", "CF24 4LR", "Cardiff", 0, media);

        // When report saved to database
        ReportEntity insertedReport = reportRepository.save(testReport);

        // User is linked to report
        UserEntity insertedUser = insertedReport.getUser();
        assertEquals("test", insertedUser.getFirstName());
    }

    @ParameterizedTest
    @CsvSource({"john,2","sarah, 1", "jimmy, 0"})
    public void shouldGetNUsersFromSearch(String search, Integer count) throws Exception{

        List<UserEntity> charityList = userRepository.findAllByFirstName(search);
        assertEquals(count, charityList.size());
    }

}
