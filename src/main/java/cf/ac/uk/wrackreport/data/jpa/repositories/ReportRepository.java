package cf.ac.uk.wrackreport.data.jpa.repositories;

import cf.ac.uk.wrackreport.data.jpa.entities.ReportEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

public interface ReportRepository extends JpaRepository<ReportEntity, Long> {

    ReportEntity save(ReportEntity aReport);

    @EntityGraph(attributePaths = {"media"})
    ArrayList<ReportEntity> findAll();

    Optional<ReportEntity> findByReportId(Long reportId);

    ArrayList<ReportEntity> findAllByStatus(int status);

    @Modifying
    @Transactional
    @Query("UPDATE ReportEntity SET status=?1 WHERE reportId=?2")
    void setStatus(int status, long id);
}
