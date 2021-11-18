package cf.ac.uk.wrackreport.service.dto;

import cf.ac.uk.wrackreport.domain.Report;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class ReportDTO {
    String timeReported;
    String dateReported;

    public ReportDTO(Report aReport) {
        this(
                aReport.getTimeReported(),
                aReport.getDateReported()
        );
    }
}
