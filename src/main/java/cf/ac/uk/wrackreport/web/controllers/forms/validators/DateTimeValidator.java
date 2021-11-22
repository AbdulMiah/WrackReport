package cf.ac.uk.wrackreport.web.controllers.forms.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeValidator implements ConstraintValidator<ValidDateTime, String> {

    @Override
    public boolean isValid(String dateTime, ConstraintValidatorContext context) {
        if (dateTime.isEmpty()) {
            return false;
        }
        LocalDateTime dateTimeNow = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String[] datetimeSplit = dateTime.split("T");
        String dateTimeConcat = datetimeSplit[0].concat(" " + datetimeSplit[1]);
        LocalDateTime formattedDateTime = LocalDateTime.parse(dateTimeConcat, formatter);

        if (formattedDateTime.isAfter(dateTimeNow)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("The date and time cannot be in the future").addConstraintViolation();
            return false;
        } else {
            return true;
        }
    }
}
