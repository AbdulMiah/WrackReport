package cf.ac.uk.wrackreport.web.controllers.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportForm {

    @NotEmpty
    private String timeReported;

    @NotEmpty
    private String dateReported;
}
