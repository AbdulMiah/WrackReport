package cf.ac.uk.wrackreport.web.controllers;

import cf.ac.uk.wrackreport.domain.Category;
import cf.ac.uk.wrackreport.service.CategoryService;
import cf.ac.uk.wrackreport.service.ReportService;
import cf.ac.uk.wrackreport.service.dto.CategoryDTO;
import cf.ac.uk.wrackreport.service.dto.ReportDTO;
import cf.ac.uk.wrackreport.service.dto.UserDTO;
import cf.ac.uk.wrackreport.web.controllers.forms.ReportForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Controller
public class ReportController {

    private ReportService reportService;
    private CategoryService categoryService;

    public ReportController(ReportService reportService, CategoryService categoryService){
        this.reportService = reportService;
        this.categoryService = categoryService;
    }

    @GetMapping("/report-form")
    public String displayReportForm(Model model) {
        ReportForm reportForm = new ReportForm();
        LocalDateTime dateTimeNow = LocalDateTime.now();

        model.addAttribute("reportForm", reportForm);
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("dateTimeNow", dateTimeNow);

        return "report-form";
    }

    @PostMapping("/report-form")
    public String submitReport (
            @Valid ReportForm reportForm,
            BindingResult bindingResult,
            Model model) {


//        Create data transfer object from form inputs
        UserDTO userDTO = new UserDTO(reportForm.getUserId(),
                1,
                reportForm.getFirstName(),
                reportForm.getSurname(),
                reportForm.getEmail(),
                reportForm.getPhoneNumber()
        );
//        check for errors
        if (bindingResult.hasErrors()) {
            System.out.println("THERE ARE ERRORS" + bindingResult.getAllErrors());
            return "/report-form";
        }
//        save user to db
        reportService.saveUser(userDTO);

>>>>>>> src/main/java/cf/ac/uk/wrackreport/web/controllers/ReportController.java

        String datetime = reportForm.getDate().concat(" "+reportForm.getTime()+":00");
        System.out.println(datetime);

                ReportDTO reportDTO = new ReportDTO(
                        reportForm.getReportId(),
//                        1L,
//                        reportForm.getUserId(),
                        2L,
//                        reportForm.getCategoryId(),
                        3L,
                        reportForm.getDescription(),
//                        reportForm.getLatLong(),
                        "123,123",
                        datetime,
                        reportForm.getPostcode());

            if (bindingResult.hasErrors()) {
                return "/report-form";
            }

            //Get valid category IDs (validation)
            /*ArrayList<CategoryDTO> catDTOs = categoryService.findAll();
            ArrayList<Short> catIDs = new ArrayList<Short>();
            for(int i = 0; i < catDTOs.size(); i++){
                catIDs.add(catDTOs.get(i).getId());
            }*/


            if(!categoryService.checkValidID((short) reportForm.getCategoryId())){
                System.out.println("invalid category");
                return "/report-form";
            }

            reportService.saveReport(reportDTO);
            return "redirect:/";
    }

        reportService.saveReport(reportDTO);
        return "redirect:/";
    }
}