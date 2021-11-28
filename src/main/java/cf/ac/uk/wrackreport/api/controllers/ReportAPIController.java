package cf.ac.uk.wrackreport.api.controllers;

import cf.ac.uk.wrackreport.service.ReportService;
import cf.ac.uk.wrackreport.service.dto.ReportDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class ReportAPIController {

    private ReportService reportService;

    public ReportAPIController(ReportService aReportService) {
        reportService = aReportService;
    }

    @GetMapping("reports")
    public ResponseEntity<List<ReportDTO>> findAll() {
        List<ReportDTO> reportDTOList;
        reportDTOList = reportService.findAllReports();

        return ResponseEntity.ok(reportDTOList);
    }
}
