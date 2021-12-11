package cf.ac.uk.wrackreport.service.impl;

import cf.ac.uk.wrackreport.data.interfaces.WrackReportRepository;
import cf.ac.uk.wrackreport.domain.Report;
import cf.ac.uk.wrackreport.service.ReportService;
import cf.ac.uk.wrackreport.service.dto.ReportDTO;
import cf.ac.uk.wrackreport.service.dto.ReportOverviewDTO;
import cf.ac.uk.wrackreport.service.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ReportServiceImpl implements ReportService {

    private WrackReportRepository wrackReportRepository;

    public ReportServiceImpl(WrackReportRepository aRepo) {
        wrackReportRepository = aRepo;
    }

    public void saveReport(ReportDTO aReportDTO) {
        log.debug("Saving report: " + aReportDTO);
        wrackReportRepository.saveReport(aReportDTO.toReport());
    }

    public void confirmReport(ReportDTO aReportDTO) {
        wrackReportRepository.approveReport(aReportDTO.toReport());
    }

    public void removeReport(ReportDTO aReportDTO){
        wrackReportRepository.removeReport(aReportDTO.toReport());
    }

    public List<ReportDTO> findAllReports() {
        log.debug("Getting all reports from ReportServiceImpl");

        return wrackReportRepository
                .findAllReports()
                .stream()
                .map(r -> new ReportDTO(r))
                .collect(Collectors.toList());
    }

    public List<ReportDTO> findAllUnvalidatedReports() {
        List<Report> reports = wrackReportRepository.findAllByStatus(0);
        List<ReportDTO> reportDTOs = reports.stream().map(r -> new ReportDTO(r)).collect(Collectors.toList());
        return reportDTOs;
    }

    @Override
    public Optional<ReportDTO> findByReportId(Long reportId) {
        log.debug("Searching for reports with reportId: " + reportId);

        Optional<Report> report = wrackReportRepository.findByReportId(reportId);
        if (report.isPresent()) {
            log.debug("Found report. Converting to DTO");
            ReportDTO reportDTO = new ReportDTO(report.get());
            return Optional.of(reportDTO);
        } else {
            log.debug("Did not find report with reportId: " + reportId);
            return Optional.empty();
        }
    }

    @Override
    public void saveUser(UserDTO aUserDTO) {
        wrackReportRepository.saveUser(aUserDTO.toUser());
    }

}
