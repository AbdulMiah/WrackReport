package cf.ac.uk.wrackreport.data.jpa.repositories;

import cf.ac.uk.wrackreport.data.jpa.entities.DepthCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface DepthCategoryRepository extends JpaRepository<DepthCategoryEntity, Long> {

    ArrayList<DepthCategoryEntity> findAll();

    DepthCategoryEntity save(DepthCategoryEntity aDepthCategory);
}
