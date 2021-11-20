package cf.ac.uk.wrackreport.data.jpa.entities;

import cf.ac.uk.wrackreport.domain.Report;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reports")
public class ReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "description")
    private String description;

    @Column(name = "lat_long")
    private String latLong;

    @Column(name = "datetime")
    private String datetime;

    @Column(name = "postcode")
    private String postcode;

    public ReportEntity(Report aReport) {
        this.reportId = aReport.getReportId();
        this.userId = aReport.getUserId();
        this.categoryId = aReport.getCategoryId();
        this.description = aReport.getDescription();
        this.latLong = aReport.getLatLong();
        this.datetime = aReport.getDatetime();
        this.postcode = aReport.getPostcode();
    }

    public Report toDomain() {
        Report domainReport = new Report (
                this.reportId,
                this.userId,
                this.categoryId,
                this.description,
                this.latLong,
                this.datetime,
                this.postcode
        );
        return domainReport;
    }

}
