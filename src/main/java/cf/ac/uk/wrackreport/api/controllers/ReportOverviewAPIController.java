package cf.ac.uk.wrackreport.api.controllers;

import cf.ac.uk.wrackreport.service.ReportOverviewService;
import cf.ac.uk.wrackreport.service.ReportService;
import cf.ac.uk.wrackreport.service.dto.ReportDTO;
import cf.ac.uk.wrackreport.service.dto.ReportOverviewDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class ReportOverviewAPIController {

    private ReportOverviewService reportOverviewService;

    public ReportOverviewAPIController(ReportOverviewService aReportOverviewService) {
        reportOverviewService = aReportOverviewService;
    }

    @GetMapping("report-overviews")
    public ResponseEntity<List<ReportOverviewDTO>> findAll() {
        List<ReportOverviewDTO> reportOverviewDTOS;
        reportOverviewDTOS = reportOverviewService.findAllReportOverview();

        return ResponseEntity.ok(reportOverviewDTOS);
    }
}
