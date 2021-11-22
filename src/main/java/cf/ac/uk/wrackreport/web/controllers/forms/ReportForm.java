package cf.ac.uk.wrackreport.web.controllers.forms;

import cf.ac.uk.wrackreport.web.controllers.forms.validators.ValidPhoneNumber;
import cf.ac.uk.wrackreport.web.controllers.forms.validators.ValidDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.validation.constraints.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportForm {

    private Long reportId;

    private Long userId;

    private Long categoryId;

    private String description;

    private String latLong;

    @NotNull
    @ValidDateTime
    private String dateTime;

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

//    custom validator for phone number
    @ValidPhoneNumber
    @Pattern(regexp = "[0-9\\s]*", message = "Phone number must consist of only numbers")
    private String phoneNumber;



}
