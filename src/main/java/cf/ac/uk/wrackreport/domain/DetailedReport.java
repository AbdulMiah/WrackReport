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

    public DetailedReport(Long reportId, String datetime, String localAuthority, String postcode, String categoryName, Float depthMeters, String description, String firstName, String surname, String email, String phoneNumber) {
        this.reportId = reportId;
        this.datetime = datetime;
        this.localAuthority = localAuthority;
        this.postcode = postcode;
        this.categoryName = categoryName;
        this.depthMeters = depthMeters;
        this.description = description;
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
