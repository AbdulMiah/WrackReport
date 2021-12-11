package cf.ac.uk.wrackreport.service.impl;

import cf.ac.uk.wrackreport.data.interfaces.WrackReportRepository;
import cf.ac.uk.wrackreport.service.UserService;
import cf.ac.uk.wrackreport.service.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private WrackReportRepository wrackReportRepository;

    public UserServiceImpl(WrackReportRepository aRepo) {
        wrackReportRepository = aRepo;
    }

    public List<UserDTO> findAllUsers() {
        log.debug("Getting all reports from ReportServiceImpl");

        return wrackReportRepository
                .findAllUsers()
                .stream()
                .map(u -> new UserDTO(u))
                .collect(Collectors.toList());
    }

}
