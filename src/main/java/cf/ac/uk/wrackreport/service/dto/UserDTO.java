package cf.ac.uk.wrackreport.service.dto;

import cf.ac.uk.wrackreport.domain.User;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class UserDTO {
    Long userId;
    int userTypeId;
    String firstName;
    String surname;
    String email;
    String phoneNumber;

    public UserDTO(User aUser) {
        this(
               aUser.getUserId(),
               aUser.getUserTypeId(),
               aUser.getFirstName(),
               aUser.getSurname(),
               aUser.getEmail(),
               aUser.getPhoneNumber()
        );
    }

    public User toUser() {
        return new User(userId, userTypeId, firstName, surname, email, phoneNumber);
    }

}
