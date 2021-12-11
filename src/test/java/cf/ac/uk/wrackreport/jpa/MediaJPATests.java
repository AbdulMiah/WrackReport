package cf.ac.uk.wrackreport.jpa;

import cf.ac.uk.wrackreport.data.jpa.entities.MediaEntity;
import cf.ac.uk.wrackreport.data.jpa.entities.ReportEntity;
import cf.ac.uk.wrackreport.data.jpa.entities.UserEntity;
import cf.ac.uk.wrackreport.data.jpa.repositories.MediaRepository;
import cf.ac.uk.wrackreport.data.jpa.repositories.ReportRepository;
import org.junit.jupiter.api.Test;
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
public class MediaJPATests {

    @Autowired
    ReportRepository reportRepository;

    @Autowired
    MediaRepository mediaRepository;

    @Test
    public void shouldGetEightMedia() throws Exception {
        List<MediaEntity> media = new ArrayList<MediaEntity>();
        UserEntity user = new UserEntity(null, "ROLE_USER", "firstname", "lastname", "test@gmail.com", "07888747748", null, true);
        MediaEntity testMedia = new MediaEntity(null,null,null,"testMedia",1,"testpath");
        media.add(testMedia);
        ReportEntity reportEntity = new ReportEntity(null, user, (short)2, "test desc", (short)2, 0.2f, "51.896156,-3.933956", "2021-11-19 22:20:00", "CF24 4LR", "Cardiff", 0, media);
        reportRepository.save(reportEntity);
        List<MediaEntity> res = mediaRepository.findAll();
        System.out.println(res);
        assertEquals(8, res.size());
    }

}
