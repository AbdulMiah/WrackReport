package cf.ac.uk.wrackreport.service;

import cf.ac.uk.wrackreport.domain.ReportOverview;
import cf.ac.uk.wrackreport.service.dto.ReportOverviewDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReportOverviewService {
    List<ReportOverviewDTO> findAllReportOverview();

//    @Procedure("ReportQuery")
//    List<ReportOverviewDTO> reportQuery(String postcode, String localAuthority, String categoryName, String dateFrom, String dateTo);


    @Query(value = "SELECT * FROM `report_overview` WHERE (:postcode IS NULL OR postcode = :postcode) " +
            "AND (:localAuthority IS NULL OR local_authority = :localAuthority) " +
            "AND (:categoryName IS NULL OR category_name = :categoryName) " +
            "AND (:dateFrom IS NULL OR DATE(datetime) >= :dateFrom) " +
            "AND (:dateTo IS NULL OR DATE(datetime) <= :dateTo)",
            nativeQuery = true)
    List<ReportOverviewDTO> reportQuery(
            @Param("postcode") String postcode, @Param("localAuthority") String localAuthority, @Param("categoryName") String categoryName,
            @Param("dateFrom") String dateFrom, @Param("dateTo") String dateTo);

}
