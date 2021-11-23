package cf.ac.uk.wrackreport.data.jpa.entities;

import cf.ac.uk.wrackreport.domain.DepthCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "depth_categories")
public class DepthCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "depth_category_id")
    private short id;

    @Column(name = "depth_name")
    private String name;

    public DepthCategoryEntity(DepthCategory aDepth) {
        this.id = aDepth.getId();
        this.name = aDepth.getName();
    }
}
