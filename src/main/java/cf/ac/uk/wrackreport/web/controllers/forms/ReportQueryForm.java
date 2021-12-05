package cf.ac.uk.wrackreport.web.controllers.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportQueryForm {

    private String postcode;

    private String localAuthority;

    private short categoryId;

    private String dateFrom;

    private String dateTo;

    private Boolean showRemoved;

}
