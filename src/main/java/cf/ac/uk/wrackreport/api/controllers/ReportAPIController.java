package cf.ac.uk.wrackreport.api.controllers;

import cf.ac.uk.wrackreport.data.jpa.entities.ReportEntity;
import cf.ac.uk.wrackreport.data.jpa.repositories.ReportRepository;
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

    private ReportRepository reportRepository;

    public ReportAPIController(ReportRepository aReportService) {
        reportRepository = aReportService;
    }

    @GetMapping("reports")
    public ResponseEntity<List<ReportEntity>> findAll() {
        List<ReportEntity> reportEntityList;
        reportEntityList = reportRepository.findAll();

        return ResponseEntity.ok(reportEntityList);
    }
}
