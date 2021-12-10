package cf.ac.uk.wrackreport.service;

import cf.ac.uk.wrackreport.service.dto.DetailedReportDTO;

import java.util.List;
import java.util.Optional;

public interface DetailedReportService {

    List<DetailedReportDTO> findAllDetailedReport();

    Optional<DetailedReportDTO> findAllByReportId(Long reportId);
}
