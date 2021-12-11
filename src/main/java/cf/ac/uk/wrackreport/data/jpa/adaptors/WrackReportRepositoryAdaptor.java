package cf.ac.uk.wrackreport.data.jpa.adaptors;

import cf.ac.uk.wrackreport.data.interfaces.WrackReportRepository;
import cf.ac.uk.wrackreport.data.jpa.entities.*;
import cf.ac.uk.wrackreport.data.jpa.repositories.*;
import cf.ac.uk.wrackreport.domain.*;
import cf.ac.uk.wrackreport.service.dto.CategoryDTO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class WrackReportRepositoryAdaptor implements WrackReportRepository {

    private ReportRepository reportRepository;
    private CategoryRepository categoryRepository;
    private DepthCategoryRepository depthCategoryRepository;
    private UserRepository userRepository;
    private MediaRepository mediaRepository;
    private StaffUserRepository staffUserRepository;
    private ReportOverviewRepository reportOverviewRepository;
    private DetailedReportRepository detailedReportRepository;

    public WrackReportRepositoryAdaptor(ReportRepository repo, CategoryRepository cat, DepthCategoryRepository depthCat, UserRepository uRepo, MediaRepository mRepo, StaffUserRepository sRepo, ReportOverviewRepository roRepo, DetailedReportRepository drRepo) {
        reportRepository = repo;
        categoryRepository = cat;
        depthCategoryRepository = depthCat;
        userRepository = uRepo;
        mediaRepository = mRepo;
        staffUserRepository = sRepo;
        reportOverviewRepository = roRepo;
        detailedReportRepository = drRepo;

    }

    public void saveReport(Report aReport) {
        ReportEntity reportEntity = new ReportEntity(aReport);
        reportRepository.save(reportEntity);
    }

    public ArrayList<Category> findAllCategories(){
        ArrayList<CategoryEntity> categoryEntities = categoryRepository.findAll();

        ArrayList<Category> categories = new ArrayList<Category>();

        for(int i=0; i<categoryEntities.size(); i++){
            Category tmp = new Category(categoryEntities.get(i));
            categories.add(tmp);
        }


        return categories;
    }

    public void approveReport(Report aReport){
        ReportEntity reportEntity = new ReportEntity(aReport);
        reportRepository.setStatus(1, reportEntity.getReportId());
    }

    public void removeReport(Report aReport){
        ReportEntity reportEntity = new ReportEntity(aReport);
        reportRepository.setStatus(-1, reportEntity.getReportId());
    }

    public ArrayList<DepthCategory> findAllDepthCategories(){
        ArrayList<DepthCategoryEntity> depthCategoryEntities = depthCategoryRepository.findAll();
        ArrayList<DepthCategory> depthCategories = new ArrayList<DepthCategory>();

        for(int i=0; i<depthCategoryEntities.size(); i++){
            DepthCategory tmp = new DepthCategory(depthCategoryEntities.get(i));
            depthCategories.add(tmp);
        }
        return depthCategories;
    }

    public List<Report> findAllReports() {
        ArrayList<ReportEntity> reportEntities = reportRepository.findAll();
        return reportRepository.findAll()
                .stream()
                .map(r -> r.toDomain())
                .collect(Collectors.toList());
    }

    public List<Report> findAllByStatus(int status){
        ArrayList<ReportEntity> reportEntities = reportRepository.findAllByStatus(status);
        return reportRepository.findAllByStatus(status)
                .stream()
                .map(r -> r.toDomain())
                .collect(Collectors.toList());
    }


    public Optional<Report> findByReportId(Long reportId) {
        Optional<ReportEntity> reportEntity = reportRepository.findByReportId(reportId);

        if (reportEntity.isPresent()) {
            return Optional.of(reportEntity.get().toDomain());
        } else {
            return Optional.empty();
        }
    }

    public boolean checkValidCategoryID(short id){
        return categoryRepository.getById(id).isPresent();
    }

    public void saveUser(User aUser) {
        UserEntity userEntity = new UserEntity(aUser);
        userRepository.save(userEntity);
    }

    public void saveMedia(Media aMedia) {
        MediaEntity mediaEntity = new MediaEntity(aMedia);
        mediaRepository.save(mediaEntity);
    }

    public Optional<StaffUser> findByEmail(String email) {
        Optional<StaffUserEntity> staffUserEntity = staffUserRepository.findByEmail(email);
        if (staffUserEntity.isPresent()) {
            return Optional.of(staffUserEntity.get().toDomain());
        } else {
            return Optional.empty();
        }
    }

    public List<ReportOverview> findAllReportOverview() {
        return reportOverviewRepository.findAll()
                .stream()
                .map(r -> r.toDomain())
                .collect(Collectors.toList());
    }

    public List<ReportOverview> reportQuery(String postcode, String localAuthority, String categoryName, String dateFrom, String dateTo, Integer status) {
        return reportOverviewRepository.reportQuery(postcode, localAuthority, categoryName, dateFrom, dateTo, status)
                .stream()
                .map(r -> r.toDomain())
                .collect(Collectors.toList());
    }


    public List<DetailedReport> findAllDetailedReport() {
        return detailedReportRepository.findAll()
                .stream()
                .map(r -> r.toDomain())
                .collect(Collectors.toList());
    }

    public Optional<DetailedReport> findAllByReportId(Long reportId) {
        Optional<DetailedReportEntity> detailedReportEntity = detailedReportRepository.findAllByReportId(reportId);

        if (detailedReportEntity.isPresent()) {
            return Optional.of(detailedReportEntity.get().toDomain());
        } else {
            return Optional.empty();
        }
    }

    public List<Media> findAllMediaByReportId(Long reportId){
        return mediaRepository.findAllMediaByReportId(reportId)
                .stream()
                .map(m -> m.toDomain())
                .collect(Collectors.toList());
    }

    public List<User> findAllUsers() {
        ArrayList<UserEntity> userEntities = userRepository.findAll();
        return userRepository.findAll()
                .stream()
                .map(u -> u.toDomain())
                .collect(Collectors.toList());
    }

    public List<User> findAllByFirstName(String firstName){
        ArrayList<UserEntity> userEntities = userRepository.findAllByFirstName(firstName);
        return userRepository.findAllByFirstName(firstName)
                .stream()
                .map(u -> u.toDomain())
                .collect(Collectors.toList());
    }

}
