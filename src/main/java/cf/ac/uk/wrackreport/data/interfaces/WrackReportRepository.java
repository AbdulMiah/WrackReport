package cf.ac.uk.wrackreport.data.interfaces;

import cf.ac.uk.wrackreport.domain.Category;
import cf.ac.uk.wrackreport.domain.Media;
import cf.ac.uk.wrackreport.domain.Report;
import cf.ac.uk.wrackreport.domain.User;

import java.util.ArrayList;

public interface WrackReportRepository {

    void saveReport(Report aReport);
    
    ArrayList<Category> findAllCategories();

    boolean checkValidCategoryID(short id);
    void saveUser(User aUser);

    void saveMedia(Media aMedia);

}
