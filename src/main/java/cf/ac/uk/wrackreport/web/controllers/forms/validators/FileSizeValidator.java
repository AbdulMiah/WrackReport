package cf.ac.uk.wrackreport.web.controllers.forms.validators;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class FileSizeValidator implements ConstraintValidator<ValidFileSize, ArrayList<MultipartFile>> {

    @Override
    public boolean isValid(ArrayList<MultipartFile> files, ConstraintValidatorContext context) {
        //validate number of files
        if (files.size() > 5) {
            //Update message if too many files
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("A maximum of 5 files are permitted").addConstraintViolation();
            return false;
        }
        //Create list of acceptable content types
        List<String> validTypes = Arrays.asList(new String[]{"jpg", "png", "jpeg"});
        //Loop through files arraylist
        for (MultipartFile f: files) {
            //reject if file over 150mb
            if (f.getSize() / 1024 > 150000) {
                return false;
            }
            //reject if files are incorrect type
            String fileType = FilenameUtils.getExtension(f.getOriginalFilename()).toLowerCase(Locale.ROOT);
            if (!validTypes.contains(fileType)){
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Files must be JPG or PNG").addConstraintViolation();
                return false;
            }
        }
        return true;
    }

}
