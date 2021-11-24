package cf.ac.uk.wrackreport.service.dto;

import cf.ac.uk.wrackreport.domain.Media;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.sql.Blob;

@Value
@AllArgsConstructor
public class MediaDTO {

    Long mediaId;
    Long metadataId;
    String title;
    int type;
    String mediaPath;
    String hash;

    public MediaDTO(Media aMedia) {
        this (
                aMedia.getMediaId(),
                aMedia.getMetadataId(),
                aMedia.getTitle(),
                aMedia.getType(),
                aMedia.getMediaPath(),
                aMedia.getHash()
        );
    }

    public Media toMedia() {
        return new Media(mediaId, metadataId, title, type, mediaPath, hash);
    }

}
