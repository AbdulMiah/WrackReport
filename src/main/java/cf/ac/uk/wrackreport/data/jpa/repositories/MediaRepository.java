package cf.ac.uk.wrackreport.data.jpa.repositories;

import cf.ac.uk.wrackreport.data.jpa.entities.MediaEntity;
import cf.ac.uk.wrackreport.domain.Media;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface MediaRepository extends JpaRepository<MediaEntity, Long> {

    MediaEntity save(MediaEntity aMedia);

    ArrayList<MediaEntity> findAll();

    ArrayList<MediaEntity> findAllMediaByReportId(Long reportId);

}
