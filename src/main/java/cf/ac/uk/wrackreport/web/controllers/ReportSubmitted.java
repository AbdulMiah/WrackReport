package cf.ac.uk.wrackreport.web.controllers;

import cf.ac.uk.wrackreport.web.controllers.forms.ReportForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Controller
public class ReportSubmitted {

    // Route to report submission page
    @GetMapping("/ReportSubmitted")
    public String successfulReportSubmission(Model model) {
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm");
        String formattedDate = dateNow.format(formatDate);
        String formattedTime = timeNow.format(formatTime);

        model.addAttribute("formattedDate", formattedDate);
        model.addAttribute("formattedTime", formattedTime);

        return "report-submitted";
    }
}
