package cf.ac.uk.wrackreport.data.interfaces;

import cf.ac.uk.wrackreport.domain.Report;
import cf.ac.uk.wrackreport.domain.User;
import org.springframework.stereotype.Repository;

//@Repository
public interface WrackReportRepository {

    void saveReport(Report aReport);

    void saveUser(User aUser);

}

