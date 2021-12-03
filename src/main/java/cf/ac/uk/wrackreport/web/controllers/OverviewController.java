package cf.ac.uk.wrackreport.web.controllers;


import cf.ac.uk.wrackreport.service.ReportOverviewService;
import cf.ac.uk.wrackreport.service.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OverviewController {

private ReportOverviewService reportOverviewService;

public OverviewController(ReportOverviewService aReportOverviewService){
    this.reportOverviewService = aReportOverviewService;
}

    @GetMapping({"/reports-overview"})
    public String displayOverview(Model model) {
        model.addAttribute("allReports", reportOverviewService.findAllReportOverview());
        return "reports-overview.html";

    }
}
