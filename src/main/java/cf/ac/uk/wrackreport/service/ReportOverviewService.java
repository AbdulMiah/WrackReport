package cf.ac.uk.wrackreport.service;

import cf.ac.uk.wrackreport.service.dto.ReportOverviewDTO;

import java.util.List;

public interface ReportOverviewService {
    List<ReportOverviewDTO> findAllReportOverview();
}
