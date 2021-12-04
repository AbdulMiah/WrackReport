package cf.ac.uk.wrackreport.service.dto;

import cf.ac.uk.wrackreport.domain.ReportOverview;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor

public class ReportOverviewDTO {
    Long reportId;
    String datetime;
    String categoryName;
    Float depthMeters;
    String postcode;
    String localAuthority;


    public ReportOverviewDTO(ReportOverview reportOverview){
        this(
                reportOverview.getReportId(),
                reportOverview.getDatetime(),
                reportOverview.getCategoryName(),
                reportOverview.getDepthMeters(),
                reportOverview.getPostcode(),
                reportOverview.getLocalAuthority()
        );

    }
    public ReportOverview toReportOverview(){
        return new ReportOverview(reportId,datetime,categoryName,depthMeters,postcode,localAuthority);
    }

}
