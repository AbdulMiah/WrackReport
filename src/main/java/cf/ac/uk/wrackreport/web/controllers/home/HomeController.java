package cf.ac.uk.wrackreport.web.controllers.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "report-form"})
    public String home(Model model) {
        return "report-form.html";
    }
}
