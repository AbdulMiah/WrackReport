package cf.ac.uk.wrackreport.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Report does not exist.")
public class ReportNotFoundAPIException extends RuntimeException {
    public ReportNotFoundAPIException(String s) {
        super(s);
    }
}
