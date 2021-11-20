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

        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();
        System.out.println("DateNow: "+dateNow);
        System.out.println("TimeNow: "+timeNow);
        String error = "Cannot enter a future date or time";

        if (reportForm.getDate().isAfter(dateNow)) {
            System.out.println(error);
            System.out.println("ReportForm Date: "+reportForm.getDate()+" is in future");
            return "/error";
        } else if ((reportForm.getDate().isAfter(dateNow) || reportForm.getDate().isEqual(dateNow)) && reportForm.getTime().isAfter(timeNow)) {
            System.out.println(error);
            System.out.println("ReportForm Time: " + reportForm.getTime()+" is in future");
            return "/error";
        } else {

            DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm");
            String formattedDate = reportForm.getDate().format(formatDate);
            String formattedTime = reportForm.getTime().format(formatTime);
            System.out.println("formattedDate: "+formattedDate);
            System.out.println("formattedTime: "+formattedTime);

            String datetime = formattedDate.concat(" " + formattedTime + ":00");
            System.out.println("datetime: "+datetime);

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

}
