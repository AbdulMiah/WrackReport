package cf.ac.uk.wrackreport.web.controllers.forms.validators;

import cf.ac.uk.wrackreport.api.postcode.Postcode;
import org.springframework.web.client.RestTemplate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WelshPostcodeValidator implements ConstraintValidator<ValidWelshPostcode, String> {

    @Override
    public boolean isValid(String postcode, ConstraintValidatorContext context) {
        String postcodeToSearch = postcode.toLowerCase().replaceAll("\\s+", "");
        RestTemplate restTemplate = new RestTemplate();
        Postcode result = restTemplate.getForObject("https://api.postcodes.io/postcodes/" + postcodeToSearch, Postcode.class);
        String country = result.getResult().getCountry();
        if (!country.equals("Wales")) {
            return false;
        } else {
            return true;
        }
    }
}
