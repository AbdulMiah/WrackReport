package cf.ac.uk.wrackreport.service.impl;

import cf.ac.uk.wrackreport.data.interfaces.WrackReportRepository;
import cf.ac.uk.wrackreport.service.DetailedReportService;
import cf.ac.uk.wrackreport.service.dto.DetailedReportDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
