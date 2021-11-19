package cf.ac.uk.wrackreport.web.controllers.forms;

import cf.ac.uk.wrackreport.web.controllers.forms.validators.ValidPhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportForm {

    private Long reportId;

    private Long userId;

    private Long categoryId;

    private String description;

    private String latLong;


    private String datetime;

    private String postcode;

    //regexp to allow hyphens, spaces, apostrophes, upper and lower case letters
    @Size(min=2, max=30, message = "First name must be between 2-30 characters")
    @Pattern(regexp = "([-a-zA-Z',\\s]+)", message = "Please enter a valid first name")
    private String firstName;

    //regexp to allow hyphens, spaces, apostrophes, upper and lower case letters
    @Size(min=2, max=30, message = "Surname must be between 2-30 characters")
    @Pattern(regexp = "([-a-zA-Z',\\s]+)", message = "Please enter a valid surname")
    private String surname;

    @Size(min=8, max=70, message = "Email address is too short")
    @Email(message = "please provide a valid email address")
    private String email;

    @ValidPhoneNumber
//    @Pattern(regexp = "[0-9]*", message = "please enter a valid phone number")
    private String phoneNumber;



}
