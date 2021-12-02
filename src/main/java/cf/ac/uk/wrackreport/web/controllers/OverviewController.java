package cf.ac.uk.wrackreport.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OverviewController {

    @GetMapping({"/", "reports-overview"})
    public String displayOverview() {
        return "reports-overview.html";

    }
}
