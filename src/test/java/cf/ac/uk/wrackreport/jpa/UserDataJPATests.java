package cf.ac.uk.wrackreport.jpa;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@Sql(scripts={"/schema-wrack-report.sql","/data-wrack-report.sql"})
@DirtiesContext
public class UserDataJPATests {
}
