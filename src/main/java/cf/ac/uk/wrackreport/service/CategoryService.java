package cf.ac.uk.wrackreport.service;

import cf.ac.uk.wrackreport.service.dto.CategoryDTO;

import java.util.ArrayList;
//Interface for CategoryService
public interface CategoryService {
    ArrayList<CategoryDTO> findAll();
}
