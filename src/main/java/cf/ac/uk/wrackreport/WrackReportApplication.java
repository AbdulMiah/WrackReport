package cf.ac.uk.wrackreport;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@EnableEncryptableProperties
@SpringBootApplication
public class WrackReportApplication {

    public static void main(String[] args) {
        SpringApplication.run(WrackReportApplication.class, args);
    }

}
