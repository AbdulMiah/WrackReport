package cf.ac.uk.wrackreport.web.controllers.forms.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        if (phoneNumber.length() == 0) {
            return true;
        }
        return phoneNumber.length() > 5 && phoneNumber.length() < 16;
    }

}
