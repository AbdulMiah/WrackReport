package cf.ac.uk.wrackreport.service.dto;

import cf.ac.uk.wrackreport.domain.StaffUser;
import cf.ac.uk.wrackreport.domain.User;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class StaffUserDTO {

    Long userId;
    String roles;
    String firstName;
    String surname;
    String email;
    String password;
    Boolean active;

    public StaffUserDTO(StaffUser aStaffUser) {
        this(
                aStaffUser.getUserId(),
                aStaffUser.getRoles(),
                aStaffUser.getFirstName(),
                aStaffUser.getSurname(),
                aStaffUser.getEmail(),
                aStaffUser.getPassword(),
                aStaffUser.getActive()
        );
    }

    public StaffUser toStaffUser() {
        return new StaffUser(userId, roles, firstName, surname, email, password, active);
    }


}
