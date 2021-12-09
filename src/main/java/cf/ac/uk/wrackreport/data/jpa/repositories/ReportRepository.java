package cf.ac.uk.wrackreport.data.jpa.repositories;

import cf.ac.uk.wrackreport.data.jpa.entities.ReportEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface ReportRepository extends JpaRepository<ReportEntity, Long> {

    ReportEntity save(ReportEntity aReport);

    @EntityGraph(attributePaths = {"media"})
    ArrayList<ReportEntity> findAll();

    Optional<ReportEntity> findByReportId(Long reportId);

    ArrayList<ReportEntity> findAllByStatus(int status);
}
