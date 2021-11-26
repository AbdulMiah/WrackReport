package cf.ac.uk.wrackreport.data.jpa.repositories;

import cf.ac.uk.wrackreport.data.jpa.entities.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReportRepository extends JpaRepository<ReportEntity, Long> {

    ReportEntity save(ReportEntity aReport);

}
