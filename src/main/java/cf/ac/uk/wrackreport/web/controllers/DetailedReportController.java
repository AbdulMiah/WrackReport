package cf.ac.uk.wrackreport.web.controllers;

import cf.ac.uk.wrackreport.service.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
