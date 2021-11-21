package cf.ac.uk.wrackreport.api.postcode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

//Adapted from https://spring.io/guides/gs/consuming-rest/
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Postcode {

    private String status;
    private Result result;

    @Override
    public String toString() {
        return "Postcode{" +
                "status='" + status + '\'' +
                ", result=" + result +
                '}';
    }
}
