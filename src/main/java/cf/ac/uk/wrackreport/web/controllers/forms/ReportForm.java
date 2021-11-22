package cf.ac.uk.wrackreport.web.controllers.forms;

import cf.ac.uk.wrackreport.web.controllers.forms.validators.ValidDateTime;
import cf.ac.uk.wrackreport.web.controllers.forms.validators.ValidWelshPostcode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportForm {

    private Long reportId;

    private Long userId;

    private Long categoryId;

    private String description;

    private String latLong;

    @ValidDateTime
    private String dateTime;

    @ValidWelshPostcode
    private String postcode;

}
