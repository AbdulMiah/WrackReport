package cf.ac.uk.wrackreport.service.dto;

import cf.ac.uk.wrackreport.domain.DetailedReport;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class DetailedReportDTO {
    Long reportId;
    String datetime;
    String localAuthority;
    String postcode;
    String categoryName;
    Float depthMeters;
    String description;
    String firstName;
    String surname;
    String email;
    String phoneNumber;
    int status;

    public DetailedReportDTO(DetailedReport aDetailedReport) {
        this(
                aDetailedReport.getReportId(),
                aDetailedReport.getDatetime(),
                aDetailedReport.getLocalAuthority(),
                aDetailedReport.getPostcode(),
                aDetailedReport.getCategoryName(),
                aDetailedReport.getDepthMeters(),
                aDetailedReport.getDescription(),
                aDetailedReport.getFirstName(),
                aDetailedReport.getSurname(),
                aDetailedReport.getEmail(),
                aDetailedReport.getPhoneNumber(),
                aDetailedReport.getStatus()
        );
    }

    public DetailedReport toDetailedReport() {
        return new DetailedReport(reportId, datetime, localAuthority, postcode, categoryName, depthMeters, description, firstName, surname, email, phoneNumber, status);
    }
}
