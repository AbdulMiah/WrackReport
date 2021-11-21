package cf.ac.uk.wrackreport.web.controllers.forms;

import cf.ac.uk.wrackreport.web.controllers.forms.validators.ValidDateTime;
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

    @NotNull
    @ValidDateTime
    private String dateTime;

    @Pattern(regexp = "^$|^[A-Z]{1,2}[0-9][A-Z0-9]? ?[0-9][A-Z]{2}", message = "Must Follow the UK Postcode pattern, e.g. AB12 3CD or AB1 2CD (make sure the spacing is correct and you capitalise the letters)")
    private String postcode;

}
