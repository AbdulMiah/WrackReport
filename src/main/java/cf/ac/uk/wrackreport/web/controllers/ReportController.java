package cf.ac.uk.wrackreport.web.controllers;

import cf.ac.uk.wrackreport.data.jpa.adaptors.WrackReportRepositoryAdaptor;
import cf.ac.uk.wrackreport.domain.Report;
import cf.ac.uk.wrackreport.web.controllers.forms.ReportForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ReportController {

    @Autowired
    private WrackReportRepositoryAdaptor repoAdaptor;

    @GetMapping("/report-form")
    public String displayReportForm(Model model) {
        ReportForm reportForm = new ReportForm();

        model.addAttribute("reportForm", reportForm);

        return "report-form";
    }

    @PostMapping("/report-form")
    public String reportRequest (
            @Valid ReportForm reportForm,
            BindingResult bindingResult,
            Model model) {

                Report report = new Report(
                        reportForm.getReportId(),
                        reportForm.getUserId(),
                        reportForm.getCategoryId(),
                        reportForm.getDescription(),
                        reportForm.getLatLong(),
                        reportForm.getDatetime(),
                        reportForm.getPostcode());

            repoAdaptor.saveReport(report);
            return "redirect:/";
    }

}
