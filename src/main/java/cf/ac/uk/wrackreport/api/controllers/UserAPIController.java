package cf.ac.uk.wrackreport.api.controllers;

import cf.ac.uk.wrackreport.service.UserService;
import cf.ac.uk.wrackreport.service.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class UserAPIController {

   private UserService userService;

   public UserAPIController(UserService aUserService) {
      userService = aUserService;
   }

   @GetMapping("users")
   public ResponseEntity<List<UserDTO>> findAll(@RequestParam(value = "search", required = false) Optional<String> searchTerm) {

      List<UserDTO> userDTOList;
      if (searchTerm.isPresent()) {
         userDTOList = userService.findAllByFirstName(searchTerm.get());
      } else {
         userDTOList = userService.findAllUsers();
      }

      return ResponseEntity.ok(userDTOList);
   }

}
