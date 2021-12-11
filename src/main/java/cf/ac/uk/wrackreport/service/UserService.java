package cf.ac.uk.wrackreport.service;

import cf.ac.uk.wrackreport.service.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findAllUsers();

}
