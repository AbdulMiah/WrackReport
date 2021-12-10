package cf.ac.uk.wrackreport.data.jpa.entities;

import cf.ac.uk.wrackreport.domain.DetailedReport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "detailed_report")
public class DetailedReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @Column(name = "datetime")
    private String datetime;

    @Column(name = "local_authority")
    private String localAuthority;

    @Column(name = "postcode")
    private String postcode;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "depth_meters")
    private Float depthMeters;

    @Column(name = "description")
    private String description;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "status")
    private int status;

    public DetailedReportEntity(DetailedReport detailedReport) {
        this.reportId = detailedReport.getReportId();
        this.datetime = detailedReport.getDatetime();
        this.localAuthority = detailedReport.getLocalAuthority();
        this.postcode = detailedReport.getPostcode();
        this.categoryName = detailedReport.getCategoryName();
        this.depthMeters = detailedReport.getDepthMeters();
        this.description = detailedReport.getDescription();
        this.firstName = detailedReport.getFirstName();
        this.surname = detailedReport.getSurname();
        this.email = detailedReport.getEmail();
        this.phoneNumber = detailedReport.getPhoneNumber();
        this.status = detailedReport.getStatus();
    }

    public DetailedReport toDomain() {
        DetailedReport domainDetailedReport = new DetailedReport (
                this.reportId,
                this.datetime,
                this.localAuthority,
                this.postcode,
                this.categoryName,
                this.depthMeters,
                this.description,
                this.firstName,
                this.surname,
                this.email,
                this.phoneNumber,
                this.status
        );
        return domainDetailedReport;
    }
}
