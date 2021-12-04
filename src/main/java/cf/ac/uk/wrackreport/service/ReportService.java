package cf.ac.uk.wrackreport.service;

import cf.ac.uk.wrackreport.service.dto.ReportDTO;
import cf.ac.uk.wrackreport.service.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface ReportService {

    void saveReport(ReportDTO aReportDTO);

    void saveUser(UserDTO aUserDTO);

    List<ReportDTO> findAllReports();

    Optional<ReportDTO> findByReportId(Long reportId);

}
