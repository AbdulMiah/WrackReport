package cf.ac.uk.wrackreport.data.jpa.entities;

import cf.ac.uk.wrackreport.domain.ReportOverview;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "report_overview")

public class ReportOverviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;
    @Column(name = "datetime")
    private String datetime;
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "depth_meters")
    private Float depthMeters;
    @Column(name = "postcode")
    private String postcode;
    @Column(name = "local_authority")
    private String localAuthority;

    public ReportOverviewEntity(ReportOverview aReportOverview){
        this.reportId = aReportOverview.getReportId();
        this.datetime = aReportOverview.getDatetime();
        this.categoryName = aReportOverview.getCategoryName();
        this.depthMeters = aReportOverview.getDepthMeters();
        this.postcode = aReportOverview.getPostcode();
        this.localAuthority = aReportOverview.getLocalAuthority();
    }

    public ReportOverview toDomain(){
        ReportOverview domainReportOverview = new ReportOverview(
                this.reportId,
                this.datetime,
                this.categoryName,
                this.depthMeters,
                this.postcode,
                this.localAuthority
        );

    }
}

