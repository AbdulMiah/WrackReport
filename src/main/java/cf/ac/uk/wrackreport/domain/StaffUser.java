package cf.ac.uk.wrackreport.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffUser {

    private Long userId;
    private String roles;
    private String firstName;
    private String surname;
    private String email;
    private String password;
    private Boolean active;

}
