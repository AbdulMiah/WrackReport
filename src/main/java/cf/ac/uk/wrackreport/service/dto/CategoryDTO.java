package cf.ac.uk.wrackreport.service.dto;

import cf.ac.uk.wrackreport.domain.Category;
import cf.ac.uk.wrackreport.domain.Report;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class CategoryDTO {
    Long id;
    String name;

    public CategoryDTO(Category aCategory) {
        this.id = aCategory.getId();
        this.name = aCategory.getName();
    }

    public Category toCategory(){
        return new Category(this.id, this.name);
    }
}
