package cf.ac.uk.wrackreport.data.interfaces;

import cf.ac.uk.wrackreport.domain.*;
import cf.ac.uk.wrackreport.service.dto.ReportOverviewDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface WrackReportRepository {

    void saveReport(Report aReport);
    
    ArrayList<Category> findAllCategories();

    ArrayList<DepthCategory> findAllDepthCategories();

    List<Report> findAllReports();

    Optional<Report> findByReportId(Long reportId);

    boolean checkValidCategoryID(short id);
    void saveUser(User aUser);

    void saveMedia(Media aMedia);

    List<ReportOverview> findAllReportOverview();

    Optional<StaffUser> findByEmail(String userName);

//    @Procedure("ReportQuery")
//    List<ReportOverview> reportQuery(String postcode, String localAuthority, String categoryName, String dateFrom, String dateTo);

    @Query(value = "SELECT * FROM `report_overview` WHERE (:postcode IS NULL OR postcode = :postcode) " +
            "AND (:localAuthority IS NULL OR local_authority = :localAuthority) " +
            "AND (:categoryName IS NULL OR category_name = :categoryName) " +
            "AND (:dateFrom IS NULL OR DATE(datetime) >= :dateFrom) " +
            "AND (:dateTo IS NULL OR DATE(datetime) <= :dateTo)",
            nativeQuery = true)
    List<ReportOverview> reportQuery(
            @Param("postcode") String postcode, @Param("localAuthority") String localAuthority, @Param("categoryName") String categoryName,
            @Param("dateFrom") String dateFrom, @Param("dateTo") String dateTo);

}
