package cf.ac.uk.wrackreport.domain;

import cf.ac.uk.wrackreport.data.jpa.entities.DepthCategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepthCategory {
    private short id;
    private String name;

    public DepthCategory(DepthCategoryEntity aDepthCategoryEntity) {
        this.id = aDepthCategoryEntity.getId();
        this.name = aDepthCategoryEntity.getName();
    }
}
