package cf.ac.uk.wrackreport.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Media {

    private Long mediaId;
    private Long reportId;
    private Long metadataId;
    private String title;
    private int type;
    private String mediaPath;
    private String hash;

}
