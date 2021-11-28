package cf.ac.uk.wrackreport.data.jpa.repositories;

import cf.ac.uk.wrackreport.data.jpa.entities.MediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<MediaEntity, Long> {

    MediaEntity save(MediaEntity aMedia);

}
