package cf.ac.uk.wrackreport.jpa;

import cf.ac.uk.wrackreport.data.jpa.entities.MediaEntity;
import cf.ac.uk.wrackreport.data.jpa.entities.ReportEntity;
import cf.ac.uk.wrackreport.data.jpa.repositories.MediaRepository;
import cf.ac.uk.wrackreport.data.jpa.repositories.ReportRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.DirtiesContext;

import java.nio.charset.StandardCharsets;
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
    public void shouldGetOneMedia() throws Exception {
        List<MediaEntity> media = new ArrayList<MediaEntity>();
        MediaEntity testMedia = new MediaEntity(null,null,"testMedia",1,"testpath");
        media.add(testMedia);
        ReportEntity reportEntity = new ReportEntity(null,1L,(short)2,"test desc", "51.896156,-3.933956", "2021-11-19 22:20:00", "CF24 4LR", media);
        reportRepository.save(reportEntity);
        List<MediaEntity> res = mediaRepository.findAll();
        assertEquals(1, res.size());
    }

}
