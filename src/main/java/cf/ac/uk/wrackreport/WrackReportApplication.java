package cf.ac.uk.wrackreport;

import cf.ac.uk.wrackreport.data.jpa.adaptors.WrackReportRepositoryAdaptor;
import cf.ac.uk.wrackreport.data.jpa.entities.CategoryEntity;
import cf.ac.uk.wrackreport.domain.Category;
import cf.ac.uk.wrackreport.service.dto.CategoryDTO;
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
