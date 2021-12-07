package cf.ac.uk.wrackreport.web.controllers.forms.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class QueryLocalAuthorityValidator implements ConstraintValidator<ValidQueryLocalAuthority, String> {

    @Override
    public boolean isValid(String localAuthority, ConstraintValidatorContext context) {
        if (localAuthority.length() == 0) {
            return true;
        }
        if (localAuthority.length() > 30) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Local Authority is too long").addConstraintViolation();
            return false;
        }
        if (localAuthority.matches("([a-zA-Z\\s]+)")) {
            return true;
        } else {
            return false;
        }
    }
}
