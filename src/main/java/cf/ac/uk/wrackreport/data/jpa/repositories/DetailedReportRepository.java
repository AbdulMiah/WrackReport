package cf.ac.uk.wrackreport.data.jpa.repositories;

import cf.ac.uk.wrackreport.data.jpa.entities.DetailedReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface DetailedReportRepository extends JpaRepository<DetailedReportEntity, Long> {
    ArrayList<DetailedReportEntity> findAll();
}
