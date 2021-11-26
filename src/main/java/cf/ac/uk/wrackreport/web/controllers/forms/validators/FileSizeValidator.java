package cf.ac.uk.wrackreport.web.controllers.forms.validators;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;

public class FileSizeValidator implements ConstraintValidator<ValidFileSize, ArrayList<MultipartFile>> {

    @Override
    public boolean isValid(ArrayList<MultipartFile> files, ConstraintValidatorContext context) {
        //validate number of files
        System.out.println("size: " + files.size());
        if (files.size() > 5) {
            //Update message if too many files
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("A maximum of 5 files are permitted").addConstraintViolation();
            return false;
        }
        //Loop through files arraylist
        for (MultipartFile f: files) {
            //reject if file over 150mb
            if (f.getSize() / 1024 > 150000) {
                return false;
            }
        }
        return true;
    }

}
