package cf.ac.uk.wrackreport.data.jpa.adaptors;

import cf.ac.uk.wrackreport.data.interfaces.WrackReportRepository;
import cf.ac.uk.wrackreport.data.jpa.entities.CategoryEntity;
import cf.ac.uk.wrackreport.data.jpa.entities.ReportEntity;
import cf.ac.uk.wrackreport.data.jpa.repositories.CategoryRepository;
import cf.ac.uk.wrackreport.data.jpa.repositories.ReportRepository;
import cf.ac.uk.wrackreport.data.jpa.repositories.UserRepository;
import cf.ac.uk.wrackreport.domain.Category;
import cf.ac.uk.wrackreport.domain.Report;
import cf.ac.uk.wrackreport.domain.User;
import cf.ac.uk.wrackreport.service.dto.CategoryDTO;
import cf.ac.uk.wrackreport.data.jpa.entities.UserEntity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class WrackReportRepositoryAdaptor implements WrackReportRepository {

    private ReportRepository reportRepository;
    private CategoryRepository categoryRepository;
    private UserRepository userRepository;

    public WrackReportRepositoryAdaptor(ReportRepository repo, CategoryRepository cat) {
        reportRepository = repo;
        categoryRepository = cat;
        userRepository = uRepo;
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

    public boolean checkValidCategoryID(short id){
        return categoryRepository.getById(id).isPresent();
    }

    public void saveUser(User aUser) {
        UserEntity userEntity = new UserEntity(aUser);
        userRepository.save(userEntity);
    }

}
