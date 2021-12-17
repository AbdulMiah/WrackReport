package cf.ac.uk.wrackreport.jpa;

import cf.ac.uk.wrackreport.data.jpa.entities.DetailedReportEntity;
import cf.ac.uk.wrackreport.data.jpa.entities.MediaEntity;
import cf.ac.uk.wrackreport.data.jpa.entities.ReportEntity;
import cf.ac.uk.wrackreport.data.jpa.entities.UserEntity;
import cf.ac.uk.wrackreport.data.jpa.repositories.DetailedReportRepository;
import cf.ac.uk.wrackreport.data.jpa.repositories.ReportRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@DirtiesContext
public class DetailedReportJPATests {

    @Autowired
    DetailedReportRepository detailedReportRepository;

    @Autowired
    ReportRepository reportRepository;

    @Test
    public void shouldGet12DetailedReports() throws Exception {
        ArrayList<DetailedReportEntity> detailedReportList = detailedReportRepository.findAll();
        Integer sizeOfList = detailedReportList.size();
        System.out.println("Size of the detailed reports list: "+ sizeOfList);

        assertEquals(12, sizeOfList);
    }

    @Test
    public void shouldGet13DetailedReportsAfterInsert() throws Exception {
        // Add a new report
        List<MediaEntity> media = new ArrayList<MediaEntity>();
        UserEntity user = new UserEntity(null, "ROLE_USER", "firstname", "lastname", "test@gmail.com", "07888747748", null, true);
        MediaEntity testMedia = new MediaEntity(null,null,null,"testMedia",1,"testpath");
        media.add(testMedia);
        ReportEntity reportEntity = new ReportEntity(null, user, (short)2, "test desc", (short)2, 0.2f, "51.896156,-3.933956", "2021-11-19 22:20:00", "CF24 4LR", "Cardiff", 0, media);
        reportRepository.save(reportEntity);

        // Retrieve all detailed reports from the database
        ArrayList<DetailedReportEntity> detailedReportList = detailedReportRepository.findAll();
        Integer sizeOfList = detailedReportList.size();
        System.out.println("Size of the detailed reports list after inserting: "+ sizeOfList);

        // Checks if detailed report VIEW table has been updated
        assertEquals(13, sizeOfList);
    }

    @ParameterizedTest
    @CsvSource({"11, staceyc@gmail.co.uk", "5, clare_jones@gmail.com", "9, gbanks123@gmail.com", "7, thetibbs@gmail.co.uk", "15, miaham@cardiff.ac.uk"})
    public void checkDetailedReportExistsByEmailUsingSearch(Long reportId, String email) throws Exception {
        try {
            Optional<DetailedReportEntity> detailedReportOptional = detailedReportRepository.findAllByReportId(reportId);
            String detailedReportEmail = detailedReportOptional.get().getEmail();

            if (detailedReportOptional.isPresent()) {
                System.out.println("Email address you entered was '"+email+"' for Id: "+reportId+". The correct email is '"+ detailedReportEmail+"'");
                assertTrue(detailedReportEmail.equals(email));
            } else {
                System.out.println("Could not find email address: "+email+" for Id "+reportId);
            }
        } catch (Exception e) {
            System.out.println("The email address '"+email+"' for Id: "+reportId+" doesn't exist");
            System.out.println("More detail about the error: "+e);
        }
    }
}
