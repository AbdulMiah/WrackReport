package cf.ac.uk.wrackreport.data.jpa.repositories;

import cf.ac.uk.wrackreport.data.jpa.entities.ReportOverviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface ReportOverviewRepository extends JpaRepository<ReportOverviewEntity,Long>{
    ArrayList<ReportOverviewEntity> findAll();

    @Query(value = "SELECT * FROM `report_overview` WHERE (:postcode IS NULL OR postcode LIKE Concat(:postcode,'%')) " +
            "AND (:localAuthority IS NULL OR local_authority LIKE Concat('%',:localAuthority,'%')) " +
            "AND (:categoryName IS NULL OR category_name = :categoryName) " +
            "AND (:dateFrom IS NULL OR DATE(datetime) >= :dateFrom) " +
            "AND (:dateTo IS NULL OR DATE(datetime) <= :dateTo)" +
            "AND (status >= :status)",
            nativeQuery = true)
    List<ReportOverviewEntity> reportQuery(
            @Param("postcode") String postcode, @Param("localAuthority") String localAuthority, @Param("categoryName") String categoryName,
            @Param("dateFrom") String dateFrom, @Param("dateTo") String dateTo, @Param("status") Integer status);

}
