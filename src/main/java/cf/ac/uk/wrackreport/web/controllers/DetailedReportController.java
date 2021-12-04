package cf.ac.uk.wrackreport.web.controllers;

import cf.ac.uk.wrackreport.service.ReportService;
import cf.ac.uk.wrackreport.service.dto.ReportDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class DetailedReportController {

    private ReportService reportService;

    public DetailedReportController(ReportService aReportService) {
        this.reportService = aReportService;
    }

    @GetMapping("/detailed-report")
    public String viewDetailedReport(Model model) {
        model.addAttribute("reports", reportService.findAllReports());
        return "detailed-report";
    }

    @GetMapping("/detailed-report/{furl}")
    public String showDetailedReportByID(@PathVariable(value = "furl", required = true) Long reportId, Model model) {
        Optional<ReportDTO> reportDTO;
        reportDTO = reportService.findByReportId(reportId);

        if (reportDTO.isPresent()) {
            model.addAttribute("report", reportDTO.get());
            return "detailed-report";
        } else {
            return "redirect:/";
        }
    }
}
