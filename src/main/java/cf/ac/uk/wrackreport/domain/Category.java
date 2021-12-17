package cf.ac.uk.wrackreport.domain;

import cf.ac.uk.wrackreport.data.jpa.entities.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private short id;
    private String name;

    public Category(CategoryEntity entity){
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public void setName(String name){
        this.name = name;
    }
}
