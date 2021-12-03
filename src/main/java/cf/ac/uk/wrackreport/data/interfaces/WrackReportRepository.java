package cf.ac.uk.wrackreport.data.interfaces;

import cf.ac.uk.wrackreport.data.jpa.entities.CategoryEntity;
import cf.ac.uk.wrackreport.domain.*;

import java.util.ArrayList;
import java.util.List;

public interface WrackReportRepository {

    void saveReport(Report aReport);
    
    ArrayList<Category> findAllCategories();

    ArrayList<DepthCategory> findAllDepthCategories();

    List<Report> findAllReports();

    boolean checkValidCategoryID(short id);
    void saveUser(User aUser);

    void saveMedia(Media aMedia);

    List<ReportOverview> findAllReportOverview();



}
