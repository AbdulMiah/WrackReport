package cf.ac.uk.wrackreport.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReportOverview {
    private Long reportId;
    private String datetime;
    private String categoryName;
    private Float depthMeters;
    private String postcode;
    private String localAuthority;
}
