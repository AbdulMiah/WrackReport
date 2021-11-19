package cf.ac.uk.wrackreport.web.controllers.home;


import cf.ac.uk.wrackreport.web.controllers.forms.ReportForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {



    @GetMapping({"/", "report-form"})
    public String home(Model model) {
        ReportForm reportForm = new ReportForm();

        model.addAttribute("reportForm", reportForm);
        return "report-form.html";
    }



}
