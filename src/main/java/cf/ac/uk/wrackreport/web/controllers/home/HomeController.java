package cf.ac.uk.wrackreport.web.controllers.home;

import cf.ac.uk.wrackreport.service.dto.ReportDTO;
import cf.ac.uk.wrackreport.web.controllers.forms.ReportForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @GetMapping({"/", "report-form"})
    public String home(Model model) {
        ReportForm reportForm = new ReportForm();

        model.addAttribute("reportForm", reportForm);
        return "report-form.html";
    }

    @PostMapping({"/", "report-form"})
    public String reportFormPost(@Valid ReportForm reportForm, BindingResult bindingResult, Model model) {
        ReportDTO reportDTO = new ReportDTO(reportForm.getFirstName(),
                                           reportForm.getSurname(),
                                           reportForm.getEmail(),
                                           reportForm.getPhone_number());
    }

}
