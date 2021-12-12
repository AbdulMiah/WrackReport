package cf.ac.uk.wrackreport.api.controllers;

import cf.ac.uk.wrackreport.api.exceptions.ReportNotFoundAPIException;
import cf.ac.uk.wrackreport.data.interfaces.WrackReportRepository;
import cf.ac.uk.wrackreport.domain.Report;
import cf.ac.uk.wrackreport.domain.ReportOverview;
import cf.ac.uk.wrackreport.service.ReportService;
import cf.ac.uk.wrackreport.service.dto.ReportDTO;
import cf.ac.uk.wrackreport.service.dto.ReportOverviewDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api")
public class ReportAPIController {

    private ReportService reportService;
    private WrackReportRepository wrackReportRepository;

    public ReportAPIController(ReportService aReportService, WrackReportRepository awrackReportRepository) {
        reportService = aReportService;
        wrackReportRepository = awrackReportRepository;
    }

    @GetMapping("reports")
    public ResponseEntity<List<ReportDTO>> findAll() {
        List<ReportDTO> reportDTOList;
        reportDTOList = reportService.findAllReports();

        return ResponseEntity.ok(reportDTOList);
    }

    @GetMapping("/report/exportQuery")
    public ResponseEntity<?> exportQuery(@RequestParam(required = false) String postcode, @RequestParam(required = false) String localAuthority, @RequestParam(required = false) String categoryName, @RequestParam(required = false) String dateFrom, @RequestParam(required = false) String dateTo, @RequestParam(required = false) Integer status, @RequestParam(required=false) String showRemoved){

        if(status == null){
            status = 0;
        }
        if(showRemoved.equals("true")){
            status = -1;
        }
        if(postcode.equals("")){
            postcode = null;
        }
        if(localAuthority.equals("")){
            localAuthority = null;
        }
        if(categoryName.equals("")){
            categoryName = null;
        }

        if(dateFrom.equals("")){
            dateFrom = null;
        }
        if(dateTo.equals("")){
            dateTo = null;
        }

        System.out.println(postcode);

        List<ReportOverviewDTO> reportList = wrackReportRepository
                .reportQuery(postcode, localAuthority, categoryName, dateFrom, dateTo, status)
                .stream()
                .map(r -> new ReportOverviewDTO(r))
                .collect(Collectors.toList());

        System.out.println(reportList.size());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        ArrayList<ReportDTO> reportDTOList = new ArrayList<ReportDTO>();
        //Convert ReportOverviewDTOs to ReportDTOs
        for(int i=0;i<reportList.size();i++){
            Report report = wrackReportRepository.findByReportId(reportList.get(i).getReportId()).get();
            //Convert to DTO
            ReportDTO reportDTO = new ReportDTO(report);

            reportDTOList.add(reportDTO);
        }

        return ResponseEntity.ok().body(reportDTOList);
    }

    @GetMapping("/report/{furl}")
    public ResponseEntity<?> findByFurl(@PathVariable(value = "furl", required = true) Long reportId, @RequestParam(required = false) String format) {
        Optional<ReportDTO> reportDTO;
        reportDTO = reportService.findByReportId(reportId);
        if (reportDTO.isPresent()) {
            if(format != null && format.toLowerCase(Locale.ROOT).equals("csv")){
                String output = ReportDTO.class.getDeclaredFields()[0].getName();
                for(int i=1; i < ReportDTO.class.getDeclaredFields().length; i++){
                    output += ", " + ReportDTO.class.getDeclaredFields()[i].getName();
                }
                return ResponseEntity.ok().body(output);
            }else{
                return ResponseEntity.ok(reportDTO.get());
            }
        } else {
            throw new ReportNotFoundAPIException("That report does not exist.");
        }
    }
}
