package cf.ac.uk.wrackreport.web.controllers.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ReportInfoController {

    @GetMapping("/report-info")
    public String displayReportInfo(Model model) {
        return "report-info";
    }

}
