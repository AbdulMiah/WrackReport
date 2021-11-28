package cf.ac.uk.wrackreport.web.controllers.forms.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = FileSizeValidator.class)
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
public @interface ValidFileSize {


    String message() default "File size is too large";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
