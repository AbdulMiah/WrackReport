package cf.ac.uk.wrackreport.data.interfaces;

import cf.ac.uk.wrackreport.domain.Report;
import cf.ac.uk.wrackreport.domain.User;

public interface WrackReportRepository {

    void saveReport(Report aReport);

    void saveUser(User aUser);

}
