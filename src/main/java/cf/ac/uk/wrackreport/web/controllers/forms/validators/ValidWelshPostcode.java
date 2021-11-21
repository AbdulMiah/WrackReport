package cf.ac.uk.wrackreport.web.controllers.forms.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = WelshPostcodeValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidWelshPostcode {

    String message() default "Only accepting incidents in Wales. Please enter a Welsh Postcode";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
