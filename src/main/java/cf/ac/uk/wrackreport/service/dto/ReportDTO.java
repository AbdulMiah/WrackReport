package cf.ac.uk.wrackreport.service.dto;

import cf.ac.uk.wrackreport.domain.Media;
import cf.ac.uk.wrackreport.domain.Report;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor
public class ReportDTO {
    Long reportId;
    Long userId;
    short categoryId;
    String description;
    String latLong;
    String datetime;
    String postcode;
    List<Media> media;

    public ReportDTO(Report aReport) {
        this(
                aReport.getReportId(),
                aReport.getUserId(),
                aReport.getCategoryId(),
                aReport.getDescription(),
                aReport.getLatLong(),
                aReport.getDatetime(),
                aReport.getPostcode(),
                aReport.getMedia()
        );
    }

    public Report toReport() {
        return new Report(reportId, userId, categoryId, description, latLong, datetime, postcode, media);
    }
}
