package cf.ac.uk.wrackreport.service;

import cf.ac.uk.wrackreport.service.dto.DetailedReportDTO;

import java.util.List;

public interface DetailedReportService {

    List<DetailedReportDTO> findAllDetailedReport();
}
