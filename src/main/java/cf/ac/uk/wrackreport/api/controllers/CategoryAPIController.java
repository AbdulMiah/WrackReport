package cf.ac.uk.wrackreport.api.controllers;

import cf.ac.uk.wrackreport.data.interfaces.WrackReportRepository;
import cf.ac.uk.wrackreport.data.jpa.adaptors.WrackReportRepositoryAdaptor;
import cf.ac.uk.wrackreport.data.jpa.entities.CategoryEntity;
import cf.ac.uk.wrackreport.domain.Category;
import cf.ac.uk.wrackreport.service.CategoryService;
import cf.ac.uk.wrackreport.service.dto.CategoryDTO;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api")
public class CategoryAPIController {
    private CategoryService categoryService;
    private WrackReportRepository wrackReportRepository;

    public CategoryAPIController(CategoryService acategoryService, WrackReportRepository wrr){
        categoryService = acategoryService;
        wrackReportRepository = wrr;
    }

    @PostMapping("category")
    public ResponseEntity<?> add(HttpServletRequest request){
        CategoryDTO categoryDTO = new CategoryDTO();
        if(request.getParameter("name") == "" || request.getParameter("name") == null){
            return ResponseEntity.badRequest().build();
        }else{
            categoryDTO.setName(request.getParameter("name"));

            categoryService.add(categoryDTO);
            return ResponseEntity.ok().build();
        }
    }
}
