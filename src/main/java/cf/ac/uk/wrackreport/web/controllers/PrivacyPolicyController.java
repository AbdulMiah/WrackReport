package cf.ac.uk.wrackreport.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrivacyPolicyController {

    @GetMapping("/privacy-policy")
    public String privacyPolicy(Model model) {
        return "privacy-policy.html";
    }

}
