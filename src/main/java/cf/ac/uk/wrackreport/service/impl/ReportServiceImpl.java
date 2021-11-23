package cf.ac.uk.wrackreport.service.impl;

import cf.ac.uk.wrackreport.data.interfaces.WrackReportRepository;
import cf.ac.uk.wrackreport.service.ReportService;
import cf.ac.uk.wrackreport.service.dto.MediaDTO;
import cf.ac.uk.wrackreport.service.dto.ReportDTO;
import cf.ac.uk.wrackreport.service.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

    @Override
    public void saveUser(UserDTO aUserDTO) {
        wrackReportRepository.saveUser(aUserDTO.toUser());
    }

    @Override
    public void saveMedia(MediaDTO aMediaDTO) {
        wrackReportRepository.saveMedia(aMediaDTO.toMedia());
    }

}
