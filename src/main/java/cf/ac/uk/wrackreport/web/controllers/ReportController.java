package cf.ac.uk.wrackreport.web.controllers;

import cf.ac.uk.wrackreport.service.ReportService;
import cf.ac.uk.wrackreport.service.dto.ReportDTO;
import cf.ac.uk.wrackreport.web.controllers.forms.ReportForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Controller
public class ReportController {

    private ReportService reportService;

    public ReportController(ReportService reportService){
        this.reportService = reportService;
    }

    @GetMapping("/report-form")
    public String displayReportForm(Model model) {
        ReportForm reportForm = new ReportForm();

        model.addAttribute("reportForm", reportForm);

        return "report-form";
    }

    @PostMapping("/report-form")
    public String submitReport (
            @Valid ReportForm reportForm,
            BindingResult bindingResult,
            Model model) {

        String dtString = reportForm.getDateTime();
        String[] datetimeSplit = dtString.split("T");
        String datetime = datetimeSplit[0].concat(" " + datetimeSplit[1] + ":00");
//        System.out.println("datetime: " + datetime);

        ReportDTO reportDTO = new ReportDTO(
                //                        reportForm.getReportId(),
                1L,
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

        reportService.saveReport(reportDTO);
        return "redirect:/";
    }
}


