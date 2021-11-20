package cf.ac.uk.wrackreport.data.interfaces;

import cf.ac.uk.wrackreport.domain.Report;

public interface WrackReportRepository {

    void saveReport(Report aReport);
}
