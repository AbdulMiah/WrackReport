package cf.ac.uk.wrackreport.web.controllers.forms;

import cf.ac.uk.wrackreport.web.controllers.forms.validators.ValidPhoneNumber;
import cf.ac.uk.wrackreport.web.controllers.forms.validators.ValidDateTime;
import cf.ac.uk.wrackreport.web.controllers.forms.validators.ValidWelshPostcode;

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

    private short categoryId;

    @Size(min = 5,max = 2500,message = "Ensure Your Description Is Between 5-2500 Characters")
    private String description;

    private short depthCategoryId;

    @Max(value = 10, message = "Cannot enter depth more than 10 meters")
    private Float depthMeters;

    @ValidDateTime
    private String dateTime;

    @ValidWelshPostcode
    private String postcode;

    private String latLong;

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

//    custom validator for phone number
    @ValidPhoneNumber
    @Pattern(regexp = "[0-9\\s]*", message = "Phone number must consist of only numbers")
    private String phoneNumber;



}
