package cf.ac.uk.wrackreport.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    private Long reportId;
    private Long userId;
    private Long categoryId;
    private String description;
    private String latLong;
    private String datetime;
    private String postcode;
}
