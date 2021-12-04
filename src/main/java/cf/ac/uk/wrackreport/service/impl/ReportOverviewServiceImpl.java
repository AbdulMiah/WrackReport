package cf.ac.uk.wrackreport.service.impl;

import cf.ac.uk.wrackreport.data.interfaces.WrackReportRepository;
import cf.ac.uk.wrackreport.service.ReportOverviewService;
import cf.ac.uk.wrackreport.service.dto.ReportOverviewDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j

public class ReportOverviewServiceImpl implements ReportOverviewService {
    private WrackReportRepository wrackReportRepository;

    public ReportOverviewServiceImpl(WrackReportRepository aRepo) {
        wrackReportRepository = aRepo;
    }

    public List<ReportOverviewDTO> findAllReportOverview() {
        log.debug("Getting all report overview from ReportOverviewServiceImpl");
        return wrackReportRepository
                .findAllReportOverview()
                .stream()
                .map(r -> new ReportOverviewDTO(r))
                .collect(Collectors.toList());
    }
}
