package cf.ac.uk.wrackreport.data.jpa.repositories;

import cf.ac.uk.wrackreport.data.jpa.entities.ReportOverviewEntity;
import cf.ac.uk.wrackreport.service.dto.ReportOverviewDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.ArrayList;
import java.util.List;

public interface ReportOverviewRepository extends JpaRepository<ReportOverviewEntity,Long>{
    ArrayList<ReportOverviewEntity> findAll();

    @Procedure("ReportQuery")
    ArrayList<ReportOverviewEntity> reportQuery(String postcode, String localAuthority, String categoryName, String dateFrom, String dateTo);

}
