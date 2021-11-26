package cf.ac.uk.wrackreport.data.jpa.entities;

import cf.ac.uk.wrackreport.domain.Media;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "media")
public class MediaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mediaId;

    @Column(name = "metadata_id")
    private Long metadataId;

    @Column(name = "title")
    private String title;

    @Column(name = "type")
    private int type;

    @Column(name = "media_path")
    private String mediaPath;

//    Create media entity from domain object
    public MediaEntity(Media aMedia) {
        this.mediaId = aMedia.getMediaId();
        this.metadataId = aMedia.getMetadataId();
        this.title = aMedia.getTitle();
        this.type = aMedia.getType();
        this.mediaPath = aMedia.getMediaPath();
    }

    public Media toDomain() {
        Media domainMedia = new Media(
          this.mediaId,
          this.metadataId,
          this.title,
          this.type,
          this.mediaPath
        );
        return domainMedia;
    }

}
