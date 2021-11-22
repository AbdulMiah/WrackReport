package cf.ac.uk.wrackreport.data.interfaces;

import cf.ac.uk.wrackreport.data.jpa.entities.CategoryEntity;
import cf.ac.uk.wrackreport.domain.Category;
import cf.ac.uk.wrackreport.domain.Report;

import java.util.ArrayList;
import java.util.List;

public interface WrackReportRepository {

    void saveReport(Report aReport);

    ArrayList<Category> findAllCategories();
}
