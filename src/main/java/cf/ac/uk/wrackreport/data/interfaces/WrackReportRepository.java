package cf.ac.uk.wrackreport.data.interfaces;

import cf.ac.uk.wrackreport.domain.Category;
import cf.ac.uk.wrackreport.domain.Report;

import java.util.List;

public interface WrackReportRepository {

    void saveReport(Report aReport);

    List<Category> findAllCategories();
}
