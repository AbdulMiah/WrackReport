package cf.ac.uk.wrackreport.service.impl;

import cf.ac.uk.wrackreport.data.interfaces.WrackReportRepository;
import cf.ac.uk.wrackreport.domain.Category;
import cf.ac.uk.wrackreport.service.CategoryService;
import cf.ac.uk.wrackreport.service.dto.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//Lombok handles constructor depdendency injection for us
@Service
@AllArgsConstructor
//Slf4j for logging
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    //Repository allows us to run functions which will affect persistence
    //No need to assign field a value as the constructor will do it for us
    private WrackReportRepository wrackReportRepository;

    //findAll() returns an ArrayList containing all Category objects.
    //Used for presenting a dropdown list of options to the user
    public ArrayList<CategoryDTO> findAll() {
        //Call method on repository
        ArrayList<Category> categories = wrackReportRepository.findAllCategories();
        //Convert Category objects to DTOs
        ArrayList<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
        for(int i=0; i<categories.size(); i++){
            categoryDTOs.add(new CategoryDTO(categories.get(i)));
        }

        return categoryDTOs;
    }
}
