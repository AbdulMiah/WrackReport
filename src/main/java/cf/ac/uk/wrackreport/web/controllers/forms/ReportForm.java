package cf.ac.uk.wrackreport.web.controllers.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportForm {

    private Long reportId;

    private Long userId;

    private short categoryId;

    private String description;

    private String latLong;

    @NotEmpty
    private String date;

    @NotEmpty
    private String time;

    private String postcode;

}
