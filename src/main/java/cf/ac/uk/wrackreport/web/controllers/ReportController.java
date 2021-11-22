package cf.ac.uk.wrackreport.web.controllers;

import cf.ac.uk.wrackreport.api.postcode.Postcode;
import cf.ac.uk.wrackreport.service.ReportService;
import cf.ac.uk.wrackreport.service.dto.ReportDTO;
import cf.ac.uk.wrackreport.web.controllers.forms.ReportForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Controller
@Slf4j
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

        // Check form doesn't have errors before form data is retrieved
        if (bindingResult.hasErrors()) {
            return "/report-form";
        }

        String dtString = reportForm.getDateTime();
        String[] datetimeSplit = dtString.split("T");
        String datetime = datetimeSplit[0].concat(" " + datetimeSplit[1] + ":00");
        log.info("datetime: " + datetime);

        // if the postcode field from the form is not empty, then ...
        if (!reportForm.getPostcode().isEmpty()) {
            // Making the postcode into lower case and removing whitespaces
            String postcodeToSearch = reportForm.getPostcode().toLowerCase().replaceAll("\\s+","");
            // Adapted from https://www.geeksforgeeks.org/how-to-call-or-consume-external-api-in-spring-boot/
            RestTemplate restTemplate = new RestTemplate();
            Postcode result = restTemplate.getForObject("https://api.postcodes.io/postcodes/"+postcodeToSearch, Postcode.class);
            log.info("Postcode API result: "+result);

            // Retrieving lat and long from api request and storing as one String variable
            String latitude = result.getResult().getLatitude();
            String longitude  = result.getResult().getLongitude();
            String latLong = latitude.concat(", "+longitude);
            log.info("Lat, Long: "+latLong);

            ReportDTO reportDTO = new ReportDTO(
                    //                        reportForm.getReportId(),
                    1L,
                    //                        reportForm.getUserId(),
                    2L,
                    //                        reportForm.getCategoryId(),
                    3L,
                    reportForm.getDescription(),
                    //                        reportForm.getLatLong(),
                    latLong,
                    datetime,
                    reportForm.getPostcode());

            if (bindingResult.hasErrors()) {
                return "/report-form";
            }

            reportService.saveReport(reportDTO);
            return "redirect:/";

        //  if the postcode field in the form is empty, then...
        } else {
            ReportDTO reportDTO = new ReportDTO(
                    //                        reportForm.getReportId(),
                    1L,
                    //                        reportForm.getUserId(),
                    2L,
                    //                        reportForm.getCategoryId(),
                    3L,
                    reportForm.getDescription(),
                    //                        reportForm.getLatLong(),
                    "123, 123",
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


