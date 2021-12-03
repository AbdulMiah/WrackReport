package cf.ac.uk.wrackreport.data.jpa.entities;

import cf.ac.uk.wrackreport.domain.StaffUser;
import cf.ac.uk.wrackreport.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "staff_users")
public class StaffUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_user_id")
    private Long userId;

    @Column(name = "roles")
    private String roles;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private Boolean active;

    public StaffUserEntity(StaffUser aStaffUser) {
        this.userId = aStaffUser.getUserId();
        this.roles = aStaffUser.getRoles();
        this.firstName = aStaffUser.getFirstName();
        this.surname = aStaffUser.getSurname();
        this.email = aStaffUser.getEmail();
        this.password = aStaffUser.getPassword();
        this.active = aStaffUser.getActive();
    }

    public StaffUser toDomain() {
        StaffUser domainStaffUser = new StaffUser(
                this.userId,
                this.roles,
                this.firstName,
                this.surname,
                this.email,
                this.password,
                this.active
        );
        return domainStaffUser;
    }

}
