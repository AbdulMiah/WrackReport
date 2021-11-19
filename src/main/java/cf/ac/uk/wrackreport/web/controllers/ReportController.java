package cf.ac.uk.wrackreport.web.controllers;

import cf.ac.uk.wrackreport.service.ReportService;
import cf.ac.uk.wrackreport.service.dto.UserDTO;
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
    private ReportService reportService;



    @PostMapping({"/", "report-form"})
    public String reportFormPost(@Valid ReportForm reportForm, BindingResult bindingResult, Model model) {
        UserDTO userDTO = new UserDTO(reportForm.getUserId(),
                1,
                reportForm.getFirstName(),
                reportForm.getSurname(),
                reportForm.getEmail(),
                reportForm.getPhoneNumber()
        );
        if (bindingResult.hasErrors()) {
            System.out.println("THERE ARE ERRORS" + bindingResult.getAllErrors());
            return "/report-form";
        }
        reportService.saveUser(userDTO);
        return "redirect:/report-form";
    }

}
