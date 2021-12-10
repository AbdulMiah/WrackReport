package cf.ac.uk.wrackreport.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
