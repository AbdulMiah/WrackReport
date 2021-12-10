package cf.ac.uk.wrackreport.web.controllers.forms.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class QueryPostcodeValidator implements ConstraintValidator<ValidQueryPostcode, String> {

    @Override
    public boolean isValid(String postcode, ConstraintValidatorContext context) {
        if (postcode.length() == 0) {
            return true;
        }
        if (postcode.length() > 8) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Postcode is too long").addConstraintViolation();
            return false;
        }
        if (postcode.matches("([a-zA-Z/0-9\\s]+)")) {
            return true;
        } else {
            return false;
        }
    }

}
