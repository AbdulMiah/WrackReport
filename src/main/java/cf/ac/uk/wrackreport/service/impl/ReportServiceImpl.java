package cf.ac.uk.wrackreport.service.impl;

import cf.ac.uk.wrackreport.data.interfaces.WrackReportRepository;
import cf.ac.uk.wrackreport.service.ReportService;
import cf.ac.uk.wrackreport.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {

    private WrackReportRepository wrackReportRepository;

    public ReportServiceImpl(@Qualifier("userRepository") WrackReportRepository aRepo){
        wrackReportRepository = aRepo;
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        wrackReportRepository.saveUser(userDTO.toUser());
    }

}
