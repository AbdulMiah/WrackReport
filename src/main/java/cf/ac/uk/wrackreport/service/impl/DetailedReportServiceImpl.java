package cf.ac.uk.wrackreport.service.impl;

import cf.ac.uk.wrackreport.data.interfaces.WrackReportRepository;
import cf.ac.uk.wrackreport.domain.DetailedReport;
import cf.ac.uk.wrackreport.domain.Report;
import cf.ac.uk.wrackreport.service.DetailedReportService;
import cf.ac.uk.wrackreport.service.dto.DetailedReportDTO;
import cf.ac.uk.wrackreport.service.dto.ReportDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DetailedReportServiceImpl implements DetailedReportService {

    private WrackReportRepository wrackReportRepository;

    public DetailedReportServiceImpl(WrackReportRepository aRepo) {
        wrackReportRepository = aRepo;
    }

    public List<DetailedReportDTO> findAllDetailedReport() {
        log.debug("Getting all Detailed Report from DetailedReportServiceImpl");
        return wrackReportRepository
                .findAllDetailedReport()
                .stream()
                .map(dr -> new DetailedReportDTO(dr))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DetailedReportDTO> findAllByReportId(Long reportId) {
        log.debug("Searching for detailed reports with reportId: " + reportId);

        Optional<DetailedReport> detailedReport = wrackReportRepository.findAllByReportId(reportId);
        if (detailedReport.isPresent()) {
            log.debug("Found detailed report. Converting to DTO");
            DetailedReportDTO detailedReportDTO = new DetailedReportDTO(detailedReport.get());
            return Optional.of(detailedReportDTO);
        } else {
            log.debug("Did not find detailed report with reportId: " + reportId);
            return Optional.empty();
        }
    }
}
