package cf.ac.uk.wrackreport.api.report;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ReportAPIController {

    @GetMapping("report-info")
    public ResponseEntity<String> viewReportInfo() {
        String response  = "reached report info page";
        return ResponseEntity.ok(response);
    }

}
