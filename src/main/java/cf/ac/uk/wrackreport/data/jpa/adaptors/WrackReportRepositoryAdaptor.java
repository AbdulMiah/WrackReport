package cf.ac.uk.wrackreport.data.jpa.adaptors;

import cf.ac.uk.wrackreport.data.interfaces.WrackReportRepository;
import cf.ac.uk.wrackreport.data.jpa.entities.CategoryEntity;
import cf.ac.uk.wrackreport.data.jpa.entities.MediaEntity;
import cf.ac.uk.wrackreport.data.jpa.entities.DepthCategoryEntity;
import cf.ac.uk.wrackreport.data.jpa.repositories.DepthCategoryRepository;
import cf.ac.uk.wrackreport.data.jpa.entities.ReportEntity;
import cf.ac.uk.wrackreport.data.jpa.repositories.CategoryRepository;
import cf.ac.uk.wrackreport.data.jpa.repositories.MediaRepository;
import cf.ac.uk.wrackreport.data.jpa.repositories.ReportRepository;
import cf.ac.uk.wrackreport.data.jpa.repositories.UserRepository;
import cf.ac.uk.wrackreport.domain.Category;
import cf.ac.uk.wrackreport.domain.DepthCategory;
import cf.ac.uk.wrackreport.domain.Media;
import cf.ac.uk.wrackreport.domain.Report;
import cf.ac.uk.wrackreport.domain.User;
import cf.ac.uk.wrackreport.service.dto.CategoryDTO;
import cf.ac.uk.wrackreport.data.jpa.entities.UserEntity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class WrackReportRepositoryAdaptor implements WrackReportRepository {

    private ReportRepository reportRepository;
    private CategoryRepository categoryRepository;
    private DepthCategoryRepository depthCategoryRepository;
    private UserRepository userRepository;
    private MediaRepository mediaRepository;

    public WrackReportRepositoryAdaptor(ReportRepository repo, CategoryRepository cat, DepthCategoryRepository depthCat, UserRepository uRepo, MediaRepository mRepo) {
        reportRepository = repo;
        categoryRepository = cat;
        depthCategoryRepository = depthCat;
        userRepository = uRepo;
        mediaRepository = mRepo;
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

}
