package cf.ac.uk.wrackreport.web.controllers.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class AccountAdminController {

    @GetMapping("/admin/create-account")
    public String createAccountForm(Model model) {
        return "create-account-form";
    }

}
