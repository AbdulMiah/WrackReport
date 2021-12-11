package cf.ac.uk.wrackreport.api.controllers;

import cf.ac.uk.wrackreport.service.UserService;
import cf.ac.uk.wrackreport.service.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class UserAPIController {

   private UserService userService;

   public UserAPIController(UserService aUserService) {
      userService = aUserService;
   }

   @GetMapping("users")
   public ResponseEntity<List<UserDTO>> findAll() {
      List<UserDTO> userDTOList;
      userDTOList = userService.findAllUsers();
      return ResponseEntity.ok(userDTOList);
   }

}
