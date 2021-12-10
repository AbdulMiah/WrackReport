package cf.ac.uk.wrackreport.data.jpa.entities;

import cf.ac.uk.wrackreport.domain.Media;
import cf.ac.uk.wrackreport.domain.Report;
import cf.ac.uk.wrackreport.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reports")
public class ReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity user;

    @Column(name = "category_id")
    private short categoryId;

    @Column(name = "description")
    private String description;

    @Column(name = "depth_category_id")
    private short depthCategoryId;

    @Column(name = "depth_meters")
    private Float depthMeters;

    @Column(name = "lat_long")
    private String latLong;

    @Column(name = "datetime")
    private String datetime;

    @Column(name = "postcode")
    private String postcode;

    @Column(name = "local_authority")
    private String localAuthority;

    @Column(name = "status")
    private int status;

    //    Create one to many link between reports and media
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "report_id")
    private List<MediaEntity> media = new ArrayList<MediaEntity>();

//    Create report entity from domain object
    public ReportEntity(Report aReport) {
        this.reportId = aReport.getReportId();
        this.user = new UserEntity(aReport.getUser().getUserId(),aReport.getUser().getRoles(),aReport.getUser().getFirstName(),
                aReport.getUser().getSurname(),aReport.getUser().getEmail(),aReport.getUser().getPhoneNumber(),
                aReport.getUser().getPassword(),aReport.getUser().getActive());
        this.categoryId = aReport.getCategoryId();
        this.description = aReport.getDescription();
        this.depthCategoryId = aReport.getDepthCategoryId();
        this.depthMeters = aReport.getDepthMeters();
        this.latLong = aReport.getLatLong();
        this.datetime = aReport.getDatetime();
        this.postcode = aReport.getPostcode();
        this.localAuthority = aReport.getLocalAuthority();
        this.status = aReport.getStatus();

        aReport.getMedia()
                .stream()
                .forEach(m -> this.addMedia(new MediaEntity(
                        m.getMediaId(),
                        m.getReportId(),
                        m.getMetadataId(),
                        m.getTitle(),
                        m.getType(),
                        m.getMediaPath()
                )));
    }

    public Report toDomain() {
        Report domainReport = new Report (
                this.reportId,
                this.user.toDomain(),
                this.categoryId,
                this.description,
                this.depthCategoryId,
                this.depthMeters,
                this.latLong,
                this.datetime,
                this.postcode,
                this.localAuthority,
                this.status
        );
        if (this.hasMedia()) {
            this.getMedia()
                    .stream()
                    .forEach(m -> domainReport.addMedia(
                            new Media(
                                    m.getMediaId(),
                                    m.getReportId(),
                                    m.getMetadataId(),
                                    m.getTitle(),
                                    m.getType(),
                                    m.getMediaPath()
                            )));
        }
        return domainReport;
    }

    public void addMedia(MediaEntity aMediaEntity) {
        media.add(aMediaEntity);
    }

    public Boolean hasMedia() {
        if (media.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

}

