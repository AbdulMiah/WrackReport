package cf.ac.uk.wrackreport.service;

import cf.ac.uk.wrackreport.domain.ReportOverview;
import cf.ac.uk.wrackreport.service.dto.ReportOverviewDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReportOverviewService {
    List<ReportOverviewDTO> findAllReportOverview();

    List<ReportOverviewDTO> reportQuery(String postcode, String localAuthority, String categoryName, String dateFrom, String dateTo, Integer status);

}
