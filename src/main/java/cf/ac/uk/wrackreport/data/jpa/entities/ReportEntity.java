package cf.ac.uk.wrackreport.data.jpa.entities;

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

    public cf.ac.uk.wrackreport.domain.Report toDomain() {
        cf.ac.uk.wrackreport.domain.Report domainReport = new cf.ac.uk.wrackreport.domain.Report (
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
