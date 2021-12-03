package cf.ac.uk.wrackreport.data.jpa.repositories;

import cf.ac.uk.wrackreport.data.jpa.entities.ReportOverviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ReportOverviewRepository extends JpaRepository<ReportOverviewEntity,Long>{
    ArrayList<ReportOverviewEntity> findAll();
}
