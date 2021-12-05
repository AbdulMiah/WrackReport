package cf.ac.uk.wrackreport.web.controllers;


import cf.ac.uk.wrackreport.service.CategoryService;
import cf.ac.uk.wrackreport.service.ReportOverviewService;
import cf.ac.uk.wrackreport.web.controllers.forms.ReportForm;
import cf.ac.uk.wrackreport.web.controllers.forms.ReportQueryForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class OverviewController {

    private ReportOverviewService reportOverviewService;
    private CategoryService categoryService;


    public OverviewController(ReportOverviewService aReportOverviewService, CategoryService aCategoryService) {
        this.reportOverviewService = aReportOverviewService;
        this.categoryService = aCategoryService;
    }

    @GetMapping({"/reports-overview"})
    public String displayOverview(Model model) {

        ReportQueryForm reportQueryForm = new ReportQueryForm();

        model.addAttribute("allReports", reportOverviewService.findAllReportOverview());
        model.addAttribute("reportQueryForm", reportQueryForm);
        model.addAttribute("categories", categoryService.findAll());
        return "reports-overview.html";

    }

    @PostMapping("/reports-overview")
    public String submitReport(
            @Valid ReportQueryForm reportQueryForm,
            BindingResult bindingResult,
            Model model) {

        // Check form doesn't have errors before form data is retrieved
        if (bindingResult.hasErrors()) {
            System.out.println("THERE ARE ERRORS" + bindingResult.getAllErrors());
            return "/reports-overview";
        }
        System.out.println("results: " + reportQueryForm);
        return "redirect:/reports-overview";
    }
}
