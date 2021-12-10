package cf.ac.uk.wrackreport.service;

import cf.ac.uk.wrackreport.domain.ReportOverview;
import cf.ac.uk.wrackreport.service.dto.ReportOverviewDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReportOverviewService {
    List<ReportOverviewDTO> findAllReportOverview();

    List<ReportOverviewDTO> reportQuery(String postcode, String localAuthority, String categoryName, LocalDate dateFrom, LocalDate dateTo, Integer status);

}
