package cf.ac.uk.wrackreport.service.dto;

import cf.ac.uk.wrackreport.domain.Report;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class ReportDTO {
    Long reportId;
    Long userId;
    short categoryId;
    String description;
    short depthCategoryId;
    Integer depthMeters;
    String latLong;
    String datetime;
    String postcode;

    public ReportDTO(Report aReport) {
        this(
                aReport.getReportId(),
                aReport.getUserId(),
                aReport.getCategoryId(),
                aReport.getDescription(),
                aReport.getDepthCategoryId(),
                aReport.getDepthMeters(),
                aReport.getLatLong(),
                aReport.getDatetime(),
                aReport.getPostcode()
        );
    }

    public Report toReport() {
        return new Report(reportId, userId, categoryId, description, depthCategoryId, depthMeters, latLong, datetime, postcode);
    }
}
