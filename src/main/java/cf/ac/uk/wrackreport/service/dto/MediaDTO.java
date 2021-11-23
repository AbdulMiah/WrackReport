package cf.ac.uk.wrackreport.service.dto;

import cf.ac.uk.wrackreport.domain.Media;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.sql.Blob;

@Value
@AllArgsConstructor
public class MediaDTO {

    Long mediaId;
    Long reportId;
    Long metadataId;
    String title;
    int type;
    byte[] blob;
    String hash;

    public MediaDTO(Media aMedia) {
        this (
                aMedia.getMediaId(),
                aMedia.getReportId(),
                aMedia.getMetadataId(),
                aMedia.getTitle(),
                aMedia.getType(),
                aMedia.getBlob(),
                aMedia.getHash()
        );
    }

    public Media toMedia() {
        return new Media(mediaId, reportId, metadataId, title, type, blob, hash);
    }

}
