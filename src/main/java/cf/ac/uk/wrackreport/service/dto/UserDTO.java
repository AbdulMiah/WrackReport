package cf.ac.uk.wrackreport.service.dto;

import cf.ac.uk.wrackreport.domain.User;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class UserDTO {
    Long userId;
    String roles;
    String firstName;
    String surname;
    String email;
    String phoneNumber;
    String password;
    Boolean active;

    public UserDTO(User aUser) {
        this(
               aUser.getUserId(),
               aUser.getRoles(),
               aUser.getFirstName(),
               aUser.getSurname(),
               aUser.getEmail(),
               aUser.getPhoneNumber(),
               aUser.getPassword(),
               aUser.getActive()
        );
    }

    public User toUser() {
        return new User(userId, roles, firstName, surname, email, phoneNumber, password, active);
    }

}
