package cf.ac.uk.wrackreport.web.controllers.forms.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DateValidator implements ConstraintValidator<ValidDate, LocalDate> {

    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext context) {
        LocalDate dateNow = LocalDate.now();
        if (date.isAfter(dateNow)) {
            return false;
        } else {
            return true;
        }
    }
}
