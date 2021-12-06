package cf.ac.uk.wrackreport.web.controllers.forms.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class QueryPostcodeValidator implements ConstraintValidator<ValidQueryPostcode, String> {

    @Override
    public boolean isValid(String postcode, ConstraintValidatorContext constraintValidatorContext) {
        if (postcode.length() == 0) {
            return true;
        }
        if (postcode.matches("([a-zA-Z0-9\\s]+)")) {
            System.out.println("matches");
            return true;
        } else {
            System.out.println("doesn't match");
            return false;
        }
    }

}