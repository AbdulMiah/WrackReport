package cf.ac.uk.wrackreport.service.dto;

import cf.ac.uk.wrackreport.domain.Media;
import lombok.AllArgsConstructor;
import lombok.Value;


@Value
@AllArgsConstructor
public class MediaDTO {

    Long mediaId;
    Long reportId;
    Long metadataId;
    String title;
    int type;
    String mediaPath;

    public MediaDTO(Media aMedia) {
        this (
                aMedia.getMediaId(),
                aMedia.getReportId(),
                aMedia.getMetadataId(),
                aMedia.getTitle(),
                aMedia.getType(),
                aMedia.getMediaPath()
        );
    }

    public Media toMedia() {
        return new Media(mediaId, reportId, metadataId, title, type, mediaPath);
    }

}
