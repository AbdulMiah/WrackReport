package cf.ac.uk.wrackreport.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailedReport {
    private Long reportId;
    private String datetime;
    private String localAuthority;
    private String postcode;
    private String categoryName;
    private Float depthMeters;
    private String description;
    private String firstName;
    private String surname;
    private String email;
    private String phoneNumber;
}
