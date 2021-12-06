package cf.ac.uk.wrackreport.web.controllers.forms;

import cf.ac.uk.wrackreport.web.controllers.forms.validators.ValidQueryLocalAuthority;
import cf.ac.uk.wrackreport.web.controllers.forms.validators.ValidQueryPostcode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportQueryForm {

    @ValidQueryPostcode
    private String postcode;

    @ValidQueryLocalAuthority
    private String localAuthority;

    private String categoryName;

    private String dateFrom;

    private String dateTo;

    private Boolean showRemoved;

}
