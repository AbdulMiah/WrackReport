package cf.ac.uk.wrackreport.web.controllers.home;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/"})
    public String home(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getAuthorities());

        SimpleGrantedAuthority adminAuth = new SimpleGrantedAuthority("ROLE_ADMIN");
        SimpleGrantedAuthority staffAuth = new SimpleGrantedAuthority("ROLE_STAFF");

        Boolean auth = authentication.getAuthorities().contains(adminAuth) || authentication.getAuthorities().contains(staffAuth);

        model.addAttribute("authenticated", auth);
        return "index.html";
    }


}
