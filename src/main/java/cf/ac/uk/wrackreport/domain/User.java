package cf.ac.uk.wrackreport.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long userId;
    private int userTypeId;
    private String firstName;
    private String surname;
    private String email;
    private String phoneNumber;

}
