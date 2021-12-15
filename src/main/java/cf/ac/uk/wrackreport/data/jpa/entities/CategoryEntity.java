package cf.ac.uk.wrackreport.data.jpa.entities;

import cf.ac.uk.wrackreport.domain.Category;
import cf.ac.uk.wrackreport.domain.Report;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//Lombok annotations to create constructors and getters/setters for us
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class CategoryEntity {

    //Unique ID for categories. Using @GeneratedValue to auto-increment and @Id to declare primary key.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private short id;

    //Category has a friendly name to be displayed to users.
    @Column(name = "category_name")
    private String name;
}
