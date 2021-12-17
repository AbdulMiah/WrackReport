package cf.ac.uk.wrackreport.data.interfaces;

import cf.ac.uk.wrackreport.domain.*;
import cf.ac.uk.wrackreport.service.dto.ReportOverviewDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface WrackReportRepository {

    void saveReport(Report aReport);
    
    ArrayList<Category> findAllCategories();

    ArrayList<DepthCategory> findAllDepthCategories();

    List<Report> findAllReports();

    List<Report> findAllByStatus(int status);

    Optional<Report> findByReportId(Long reportId);

    boolean checkValidCategoryID(short id);

    void saveUser(User aUser);

    void saveMedia(Media aMedia);

    void addCategory(Category category);

    void saveDepthCategory(DepthCategory aDepthCategory);

    List<ReportOverview> findAllReportOverview();

    void approveReport(Report aReport);

    void removeReport(Report aReport);

    List<DetailedReport> findAllDetailedReport();

    Optional<StaffUser> findByEmail(String userName);

    List<ReportOverview> reportQuery(String postcode, String localAuthority, String categoryName, String dateFrom, String dateTo, Integer status);
    
    Optional<DetailedReport> findAllByReportId(Long reportId);

    List<Media> findAllMediaByReportId(Long reportId);

    List<User> findAllUsers();

    List<User> findAllByFirstName(String firstName);

    List<Media> findAllMedia();

}
