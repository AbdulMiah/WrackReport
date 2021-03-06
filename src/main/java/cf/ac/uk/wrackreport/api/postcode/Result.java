package cf.ac.uk.wrackreport.api.postcode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Result {

    private String postcode;
    private String country;
    private String longitude;
    private String latitude;
    private String admin_district;

    @Override
    public String toString() {
        return "Result{" +
                "postcode='" + postcode + '\'' +
                ", country='" + country + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", admin_district='" + admin_district + '\'' +
                '}';
    }
}
