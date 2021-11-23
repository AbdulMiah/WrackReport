package cf.ac.uk.wrackreport.service.dto;

import cf.ac.uk.wrackreport.domain.DepthCategory;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class DepthCategoryDTO {
    Short id;
    String name;

    public DepthCategoryDTO(DepthCategory aDepth) {
        this.id = aDepth.getId();
        this.name = aDepth.getName();
    }
}
