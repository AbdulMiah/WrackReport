package cf.ac.uk.wrackreport.service.dto;

import cf.ac.uk.wrackreport.data.jpa.entities.UserEntity;
import cf.ac.uk.wrackreport.domain.Media;
import cf.ac.uk.wrackreport.domain.Report;
import cf.ac.uk.wrackreport.domain.User;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor
public class ReportDTO {
    Long reportId;
    UserDTO user;
    short categoryId;
    String description;
    short depthCategoryId;
    Float depthMeters;
    String latLong;
    String datetime;
    String postcode;
    String localAuthority;
    int status;
    List<Media> media;

    public ReportDTO(Report aReport) {
        this(
                aReport.getReportId(),
//                aReport.getUser(),
                new UserDTO(aReport.getUser().getUserId(),aReport.getUser().getRoles(),aReport.getUser().getFirstName(),
                        aReport.getUser().getSurname(),aReport.getUser().getEmail(),aReport.getUser().getPhoneNumber(),
                        aReport.getUser().getPassword(),aReport.getUser().getActive()),
                aReport.getCategoryId(),
                aReport.getDescription(),
                aReport.getDepthCategoryId(),
                aReport.getDepthMeters(),
                aReport.getLatLong(),
                aReport.getDatetime(),
                aReport.getPostcode(),
                aReport.getLocalAuthority(),
                aReport.getStatus(),
                aReport.getMedia()
        );
    }

    public Report toReport() {
        return new Report(reportId,
                new User(this.getUser().getUserId(), this.getUser().getRoles(), this.getUser().getFirstName(),
                        this.getUser().getSurname(), this.getUser().getEmail(), this.getUser().getPhoneNumber(),
                        this.getUser().getPassword(), this.getUser().getActive()),
                categoryId, description, depthCategoryId, depthMeters, latLong, datetime, postcode, localAuthority, media, status);
    }
}
