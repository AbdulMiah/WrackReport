package cf.ac.uk.wrackreport.data.jpa.entities;

import cf.ac.uk.wrackreport.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "roles")
    private String roles;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private Boolean active;

    public UserEntity(User aUser) {
        this.userId = aUser.getUserId();
        this.roles = aUser.getRoles();
        this.firstName = aUser.getFirstName();
        this.surname = aUser.getSurname();
        this.email = aUser.getEmail();
        this.phoneNumber = aUser.getPhoneNumber();
    }

    public UserEntity(Long userId, String roles, String firstName, String surname, String email, String phoneNumber) {
        this.userId = userId;
        this.roles = roles;
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User toDomain() {
        User domainUser = new User (
                this.userId,
                this.roles,
                this.firstName,
                this.surname,
                this.email,
                this.phoneNumber
        );
        return domainUser;
    }

}
