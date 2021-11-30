package cf.ac.uk.wrackreport.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    private Long reportId;
    private Long userId;
    private short categoryId;
    private String description;
    private short depthCategoryId;
    private Float depthMeters;
    private String latLong;
    private String datetime;
    private String postcode;
    private List<Media> media;

    public Report(Long reportId, Long userId, short categoryId, String description, short depthCategoryId, float depthMeters, String latLong, String datetime, String postcode) {
        this.reportId = reportId;
        this.userId = userId;
        this.categoryId = categoryId;
        this.description = description;
        this.depthCategoryId = depthCategoryId;
        this.depthMeters = depthMeters;
        this.latLong = latLong;
        this.datetime = datetime;
        this.postcode = postcode;
        this.media = new ArrayList<Media>();
    }

    public void addMedia(Media aMedia) {
        media.add(aMedia);
    }


}
