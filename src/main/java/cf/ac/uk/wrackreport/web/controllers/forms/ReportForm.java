package cf.ac.uk.wrackreport.web.controllers.forms;

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

    @NotEmpty
    private String datetime;

    private String postcode;

    @Size(min=2, max=30, message = "name must be between 2-30 characters")
    @Pattern(regexp = "^[A_Z][a-z]+", message = "Please enter a valid first name")
    private String firstName;

    @Size(min=2, max=30, message = "name must be between 2-30 characters")
    @Pattern(regexp = "^[A-Z]([ '-][a-zA-Z]+)*", message = "Please enter a valid surname")
    private String surname;

    @Size(min=8, max=70, message = "Please enter a valid email address")
    @Email(message = "please provide a valid email address")
    private String email;

    @Size(min=6, max=15, message = "please enter a valid phone number")
    @Pattern(regexp = "[0-9]*", message = "please enter a valid phone number")
    private String phone_number;



}
