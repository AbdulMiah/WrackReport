package cf.ac.uk.wrackreport.service;

import cf.ac.uk.wrackreport.service.dto.DepthCategoryDTO;

import java.util.ArrayList;

public interface DepthCategoryService {

    ArrayList<DepthCategoryDTO> findAll();
}
