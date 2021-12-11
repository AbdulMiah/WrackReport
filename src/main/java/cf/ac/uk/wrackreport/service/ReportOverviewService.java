package cf.ac.uk.wrackreport.service;

import cf.ac.uk.wrackreport.service.dto.ReportOverviewDTO;

import java.util.List;

public interface ReportOverviewService {
    List<ReportOverviewDTO> findAllReportOverview();

    List<ReportOverviewDTO> reportQuery(String postcode, String localAuthority, String categoryName, String dateFrom, String dateTo, Integer status);

}
