package cf.ac.uk.wrackreport.api.controllers;

import cf.ac.uk.wrackreport.api.exceptions.ReportNotFoundAPIException;
import cf.ac.uk.wrackreport.service.ReportService;
import cf.ac.uk.wrackreport.service.dto.ReportDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/report/{furl}")
    public ResponseEntity<?> findByFurl(@PathVariable(value = "furl", required = true) Long reportId) {
        Optional<ReportDTO> reportDTO;
        reportDTO = reportService.findByReportId(reportId);

        if (reportDTO.isPresent()) {
            return ResponseEntity.ok(reportDTO.get());
        } else {
            throw new ReportNotFoundAPIException("That report does not exist.");
        }
    }
}
