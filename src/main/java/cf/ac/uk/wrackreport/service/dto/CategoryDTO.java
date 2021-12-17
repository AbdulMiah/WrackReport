package cf.ac.uk.wrackreport.service.dto;

import cf.ac.uk.wrackreport.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
public class CategoryDTO {
    public Short id;
    public String name;

    public CategoryDTO(Category aCategory) {
        this.id = aCategory.getId();
        this.name = aCategory.getName();
    }

    public CategoryDTO(){}

    public void setName(String name){
        this.name = name;
    }

    public Category toCategory(){
        if(this.id != null){
            return new Category(this.id, this.name);
        }else{
            Category newCategory = new Category();
            newCategory.setName(this.name);
            return newCategory;
        }
    }
}
