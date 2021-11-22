package cf.ac.uk.wrackreport.service;

import cf.ac.uk.wrackreport.service.dto.CategoryDTO;

import java.util.ArrayList;

public interface CategoryService {

    ArrayList<CategoryDTO> findAll();

    boolean checkValidID(short id);
}
