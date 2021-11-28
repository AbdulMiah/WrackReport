package cf.ac.uk.wrackreport.service.impl;

import cf.ac.uk.wrackreport.data.interfaces.WrackReportRepository;
import cf.ac.uk.wrackreport.domain.Category;
import cf.ac.uk.wrackreport.service.CategoryService;
import cf.ac.uk.wrackreport.service.dto.CategoryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private WrackReportRepository wrackReportRepository;

    public CategoryServiceImpl(WrackReportRepository aRepo) {
        wrackReportRepository = aRepo;
    }

    public ArrayList<CategoryDTO> findAll() {
        ArrayList<Category> categories = wrackReportRepository.findAllCategories();
        //Convert Categories to DTOs
        ArrayList<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
        for(int i=0; i<categories.size(); i++){
            categoryDTOs.add(new CategoryDTO(categories.get(i)));
        }

        return categoryDTOs;
    }

    public boolean checkValidID(short id) {
        return wrackReportRepository.checkValidCategoryID(id);
    }
}
