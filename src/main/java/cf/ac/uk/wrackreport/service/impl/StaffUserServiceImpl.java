package cf.ac.uk.wrackreport.service.impl;

import cf.ac.uk.wrackreport.data.interfaces.WrackReportRepository;
import cf.ac.uk.wrackreport.data.jpa.entities.UserEntity;
import cf.ac.uk.wrackreport.domain.StaffUser;
import cf.ac.uk.wrackreport.service.StaffUserService;
import cf.ac.uk.wrackreport.service.dto.StaffUserDTO;
import cf.ac.uk.wrackreport.service.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Slf4j
public class StaffUserServiceImpl implements StaffUserService {

    private WrackReportRepository wrackReportRepository;

    public StaffUserServiceImpl(WrackReportRepository aRepo) {
        wrackReportRepository = aRepo;
    }

    public Optional<StaffUserDTO> findByEmail(String email) {

        Optional<StaffUser> staffUser = wrackReportRepository.findByEmail(email);

        if (staffUser.isPresent()) {
            StaffUserDTO staffUserDTO = new StaffUserDTO(staffUser.get());
            return Optional.of(staffUserDTO);
        } else {
            return Optional.empty();
        }

    }

}
