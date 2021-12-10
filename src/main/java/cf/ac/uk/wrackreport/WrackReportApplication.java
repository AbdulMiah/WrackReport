package cf.ac.uk.wrackreport;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableEncryptableProperties
@SpringBootApplication
public class WrackReportApplication {

    public static void main(String[] args) {
        SpringApplication.run(WrackReportApplication.class, args);
    }

}
