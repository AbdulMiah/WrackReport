package cf.ac.uk.wrackreport.service.impl;

import cf.ac.uk.wrackreport.data.interfaces.WrackReportRepository;
import cf.ac.uk.wrackreport.domain.Report;
import cf.ac.uk.wrackreport.domain.User;
import cf.ac.uk.wrackreport.service.UserService;
import cf.ac.uk.wrackreport.service.dto.ReportDTO;
import cf.ac.uk.wrackreport.service.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    @Override
    public List<UserDTO> findAllByFirstName(String firstName) {

        List<User> users = wrackReportRepository.findAllByFirstName(firstName);
        List<UserDTO> userDTOS = users.stream().map(u -> new UserDTO(u)).collect(Collectors.toList());
        return userDTOS;
    }

}
