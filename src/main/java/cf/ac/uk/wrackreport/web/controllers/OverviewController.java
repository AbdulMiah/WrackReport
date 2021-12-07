package cf.ac.uk.wrackreport.web.controllers;


import cf.ac.uk.wrackreport.service.CategoryService;
import cf.ac.uk.wrackreport.service.ReportOverviewService;

import cf.ac.uk.wrackreport.web.controllers.forms.ReportQueryForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;

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
            model.addAttribute("allReports", reportOverviewService.findAllReportOverview());
            model.addAttribute("categories", categoryService.findAll());
            return "/reports-overview";
        } else {
            System.out.println("checked: " + reportQueryForm.getShowRemoved());
            // Create list of report form items
            ArrayList<String> formItems = new ArrayList<String>(Arrays.asList(reportQueryForm.getPostcode(), reportQueryForm.getLocalAuthority(),
                    reportQueryForm.getCategoryName(), reportQueryForm.getDateFrom(), reportQueryForm.getDateTo()));
            // If report form item was not empty, add it to database query
            ArrayList<String> queryItems = new ArrayList<String>(Arrays.asList(null,null,null,null,null));
            for (int i = 0; i < formItems.size(); i++) {
                if (formItems.get(i) != "") {
                    queryItems.set(i, formItems.get(i));
                }
            }
            Integer status = 0;
            if (reportQueryForm.getShowRemoved() == true) {
                status = -1;
            }

            //Add filtered results to model
            model.addAttribute("allReports", reportOverviewService.reportQuery(queryItems.get(0), queryItems.get(1), queryItems.get(2), queryItems.get(3), queryItems.get(4), status));
            model.addAttribute("reportQueryForm", reportQueryForm);
            model.addAttribute("categories", categoryService.findAll());
            return "/reports-overview";
        }

    }
}
