package cf.ac.uk.wrackreport.web.controllers;

import cf.ac.uk.wrackreport.domain.Media;
import cf.ac.uk.wrackreport.service.CategoryService;
import cf.ac.uk.wrackreport.api.postcode.Postcode;
import cf.ac.uk.wrackreport.service.ReportService;
import cf.ac.uk.wrackreport.service.dto.MediaDTO;
import cf.ac.uk.wrackreport.service.dto.ReportDTO;
import cf.ac.uk.wrackreport.service.dto.UserDTO;
import cf.ac.uk.wrackreport.web.controllers.forms.ReportForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.Valid;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@Slf4j
public class ReportController {

    private ReportService reportService;
    private CategoryService categoryService;

    public ReportController(ReportService reportService, CategoryService categoryService){
        this.reportService = reportService;
        this.categoryService = categoryService;
    }

    // Route to report form
    @GetMapping("/report-form")
    public String displayReportForm(Model model) {
        ReportForm reportForm = new ReportForm();
        LocalDateTime dateTimeNow = LocalDateTime.now();

        model.addAttribute("reportForm", reportForm);
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("dateTimeNow", dateTimeNow);

        return "report-form";
    }

    // Post mapping route after form submission
    @PostMapping("/report-form")
    public String submitReport (
            @Valid ReportForm reportForm,
            BindingResult bindingResult,
            Model model) throws IOException {

        //List of media to be attached to ReportDTO
        List<Media> mediaArrayList = new ArrayList<Media>();

        // ----- MEDIA ----- //

        try {
            ArrayList<MultipartFile> formFiles = reportForm.getFiles();

            if (!formFiles.get(0).isEmpty()) {
                for (MultipartFile f: formFiles) {
                    String fileName = f.getOriginalFilename();
                    String filePath = "./uploaded-media/" +fileName;
                    File file = new File("./uploaded-media/" +fileName);

                    try (OutputStream os = new FileOutputStream(file)) {
                        os.write(f.getBytes());
                    }
                    mediaArrayList.add(new Media(null,null,fileName,1,filePath));
                }
            }
        } catch (IOException e) {
            throw new IOException("could not access file: " + e);
        }

        // ----- END OF MEDIA -----//

        // Check form doesn't have errors before form data is retrieved
        if (bindingResult.hasErrors()) {
            log.debug("THERE ARE ERRORS" + bindingResult.getAllErrors());
            model.addAttribute("categories", categoryService.findAll());
            return "/report-form";
        }

        // Create data transfer object from form inputs
        UserDTO userDTO = new UserDTO(reportForm.getUserId(),
                1,
                reportForm.getFirstName(),
                reportForm.getSurname(),
                reportForm.getEmail(),
                reportForm.getPhoneNumber()
        );

        // save user to db
        reportService.saveUser(userDTO);

        String dtString = reportForm.getDateTime();
        String[] datetimeSplit = dtString.split("T");
        String datetime = datetimeSplit[0].concat(" " + datetimeSplit[1] + ":00");
        log.info("datetime: " + datetime);

        // if the postcode field from the form is not empty, then ...
        if (!reportForm.getPostcode().isEmpty()) {
            // Making the postcode into lower case and removing whitespaces
            String postcodeToSearch = reportForm.getPostcode().toLowerCase().replaceAll("\\s+", "");
            // Adapted from https://www.geeksforgeeks.org/how-to-call-or-consume-external-api-in-spring-boot/
            RestTemplate restTemplate = new RestTemplate();
            Postcode result = restTemplate.getForObject("https://api.postcodes.io/postcodes/" + postcodeToSearch, Postcode.class);
            log.info("Postcode API result: " + result);

            // Retrieving lat and long from api request and storing as one String variable
            String latitude = result.getResult().getLatitude();
            String longitude = result.getResult().getLongitude();
            String latLong = latitude.concat(", " + longitude);
            log.info("Lat, Long: " + latLong);

            ReportDTO reportDTO = new ReportDTO(
                                            reportForm.getReportId(),
                    //                        reportForm.getUserId(),
                    2L,
                    reportForm.getCategoryId(),
                    reportForm.getDescription(),
                    //                        reportForm.getLatLong(),
                    latLong,
                    datetime,
                    reportForm.getPostcode(),
                    mediaArrayList);

            if (bindingResult.hasErrors()) {
                model.addAttribute("categories", categoryService.findAll());
                return "/report-form";
            }

            reportService.saveReport(reportDTO);

        //  if the postcode field in the form is empty, then...
        } else {
            ReportDTO reportDTO = new ReportDTO(
                                            reportForm.getReportId(),
                    //                        reportForm.getUserId(),
                    2L,
                                            reportForm.getCategoryId(),
                    reportForm.getDescription(),
                    //                        reportForm.getLatLong(),
                    "123, 123",
                    datetime,
                    reportForm.getPostcode(),
                    mediaArrayList);


            if (bindingResult.hasErrors()) {
                model.addAttribute("categories", categoryService.findAll());
                return "/report-form";
            }
            System.out.println("media:" + mediaArrayList);
            reportService.saveReport(reportDTO);
        }

        return "redirect:/";
    }
}