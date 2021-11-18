package cf.ac.uk.wrackreport.data.jpa.repositories;

import cf.ac.uk.wrackreport.data.jpa.entities.ReportEntity;
import cf.ac.uk.wrackreport.data.jpa.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<ReportEntity, Long> {

    ReportEntity save(ReportEntity aReport);
    UserEntity save(UserEntity aUser);
}

