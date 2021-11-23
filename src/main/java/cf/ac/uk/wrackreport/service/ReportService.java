package cf.ac.uk.wrackreport.service;

import cf.ac.uk.wrackreport.service.dto.MediaDTO;
import cf.ac.uk.wrackreport.service.dto.ReportDTO;
import cf.ac.uk.wrackreport.service.dto.UserDTO;

public interface ReportService {

    void saveReport(ReportDTO aReportDTO);
    void saveUser(UserDTO aUserDTO);
    void saveMedia(MediaDTO aMediaDTO);

}
