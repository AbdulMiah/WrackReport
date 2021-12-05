package cf.ac.uk.wrackreport.service;

import cf.ac.uk.wrackreport.service.dto.ReportOverviewDTO;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface ReportOverviewService {
    List<ReportOverviewDTO> findAllReportOverview();

    @Procedure("ReportQuery")
    List<ReportOverviewDTO> reportQuery(String postcode, String localAuthority, String categoryName, String dateFrom, String dateTo);

}
