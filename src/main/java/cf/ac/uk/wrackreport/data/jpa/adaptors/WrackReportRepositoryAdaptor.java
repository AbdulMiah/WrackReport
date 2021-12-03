package cf.ac.uk.wrackreport.data.jpa.adaptors;

import cf.ac.uk.wrackreport.data.interfaces.WrackReportRepository;
import cf.ac.uk.wrackreport.data.jpa.entities.*;
import cf.ac.uk.wrackreport.data.jpa.repositories.*;
import cf.ac.uk.wrackreport.domain.*;
import cf.ac.uk.wrackreport.service.dto.CategoryDTO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

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

    public WrackReportRepositoryAdaptor(ReportRepository repo, CategoryRepository cat, DepthCategoryRepository depthCat, UserRepository uRepo, MediaRepository mRepo, StaffUserRepository sRepo) {
        reportRepository = repo;
        categoryRepository = cat;
        depthCategoryRepository = depthCat;
        userRepository = uRepo;
        mediaRepository = mRepo;
        staffUserRepository = sRepo;
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
        for (ReportEntity r: reportEntities
             ) {
        }
        return reportRepository.findAll()
                .stream()
                .map(r -> r.toDomain())
                .collect(Collectors.toList());
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

}
