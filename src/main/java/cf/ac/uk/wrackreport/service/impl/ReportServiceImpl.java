package cf.ac.uk.wrackreport.service.impl;

import cf.ac.uk.wrackreport.data.interfaces.WrackReportRepository;
import cf.ac.uk.wrackreport.service.ReportService;
import cf.ac.uk.wrackreport.service.dto.ReportDTO;
import cf.ac.uk.wrackreport.service.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<ReportDTO> findAllReports() {
        log.debug("Getting all reports from ReportServiceImpl");

        return wrackReportRepository
                .findAllReports()
                .stream()
                .map(r -> new ReportDTO(r))
                .collect(Collectors.toList());
    }

    @Override
    public void saveUser(UserDTO aUserDTO) {
        wrackReportRepository.saveUser(aUserDTO.toUser());
    }

}
