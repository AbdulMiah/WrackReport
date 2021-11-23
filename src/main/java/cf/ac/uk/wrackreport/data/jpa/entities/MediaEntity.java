package cf.ac.uk.wrackreport.data.jpa.entities;

import cf.ac.uk.wrackreport.domain.Media;
import cf.ac.uk.wrackreport.domain.Report;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "media")
public class MediaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mediaId;

    @Column(name = "report_id")
    private Long reportId;

    @Column(name = "metadata_id")
    private Long metadataId;

    @Column(name = "title")
    private String title;

    @Column(name = "type")
    private int type;

    @Column(name = "blob")
    @Lob
    private Blob blob;

    @Column(name = "hash")
    private String hash;

    public MediaEntity(Media aMedia) {
        this.mediaId = aMedia.getMediaId();
        this.reportId = aMedia.getReportId();
        this.metadataId = aMedia.getMetadataId();
        this.title = aMedia.getTitle();
        this.type = aMedia.getType();
        this.blob = aMedia.getBlob();
        this.hash = aMedia.getHash();
    }

    public Media toDomain() {
        Media domainMedia = new Media(
          this.mediaId,
          this.reportId,
          this.metadataId,
          this.title,
          this.type,
          this.blob,
          this.hash
        );
        return domainMedia;
    }

}
