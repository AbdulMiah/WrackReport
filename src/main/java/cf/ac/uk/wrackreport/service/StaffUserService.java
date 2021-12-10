package cf.ac.uk.wrackreport.service;

import cf.ac.uk.wrackreport.data.jpa.entities.UserEntity;
import cf.ac.uk.wrackreport.service.dto.StaffUserDTO;
import cf.ac.uk.wrackreport.service.dto.UserDTO;

import java.util.Optional;

public interface StaffUserService {

    Optional<StaffUserDTO> findByEmail(String email);

}
