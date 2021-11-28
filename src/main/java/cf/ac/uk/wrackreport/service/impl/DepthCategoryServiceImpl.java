package cf.ac.uk.wrackreport.service.impl;

import cf.ac.uk.wrackreport.data.interfaces.WrackReportRepository;
import cf.ac.uk.wrackreport.domain.DepthCategory;
import cf.ac.uk.wrackreport.service.DepthCategoryService;
import cf.ac.uk.wrackreport.service.dto.DepthCategoryDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DepthCategoryServiceImpl implements DepthCategoryService {

    private WrackReportRepository wrackReportRepository;

    public DepthCategoryServiceImpl(WrackReportRepository aRepo) {
        wrackReportRepository = aRepo;
    }

    public ArrayList<DepthCategoryDTO> findAll() {
        ArrayList<DepthCategory> depthCategories = wrackReportRepository.findAllDepthCategories();
        //Convert Categories to DTOs
        ArrayList<DepthCategoryDTO> depthCategoryDTO = new ArrayList<DepthCategoryDTO>();
        for(int i=0; i<depthCategories.size(); i++){
            depthCategoryDTO.add(new DepthCategoryDTO(depthCategories.get(i)));
        }
        return depthCategoryDTO;
    }
}
