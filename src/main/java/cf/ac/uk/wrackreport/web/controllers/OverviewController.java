package cf.ac.uk.wrackreport.web.controllers;

import cf.ac.uk.wrackreport.service.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OverviewController {
private ReportService reportService;
public OverviewController(ReportService reportService){
    this.reportService = reportService;
}

    @GetMapping({"/reports-overview"})
    public String displayOverview(Model model) {
        model.addAttribute("allReports", reportService.findAllReports());
        return "reports-overview.html";

    }
}
