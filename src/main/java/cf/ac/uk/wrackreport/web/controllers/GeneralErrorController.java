package cf.ac.uk.wrackreport.web.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class GeneralErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                log.debug("ERROR 404: " + HttpStatus.NOT_FOUND.toString());
            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
                log.debug("ERROR 403: " + HttpStatus.FORBIDDEN.toString());
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                log.debug("ERROR 500: " + HttpStatus.INTERNAL_SERVER_ERROR.toString());
            }
        }
        return "error";
    }
}
