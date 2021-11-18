package cf.ac.uk.wrackreport.service.dto;

import cf.ac.uk.wrackreport.domain.Report;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class ReportDTO {
    Long reportId;
    Long userId;
    Long categoryId;
    String description;
    String latLong;
    String datetime;
    String postcode;

    public ReportDTO(Report aReport) {
        this(
                aReport.getReportId(),
                aReport.getUserId(),
                aReport.getCategoryId(),
                aReport.getDescription(),
                aReport.getLatLong(),
                aReport.getDatetime(),
                aReport.getPostcode()
        );
    }
}
