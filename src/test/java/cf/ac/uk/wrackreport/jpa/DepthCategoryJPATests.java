package cf.ac.uk.wrackreport.jpa;

import cf.ac.uk.wrackreport.data.jpa.entities.DepthCategoryEntity;
import cf.ac.uk.wrackreport.data.jpa.repositories.DepthCategoryRepository;
import cf.ac.uk.wrackreport.domain.DepthCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@DirtiesContext
public class DepthCategoryJPATests {

    @Autowired
    DepthCategoryRepository reportRepository;

    @Test
    public void shouldGetSixCategories() throws Exception {
        ArrayList<DepthCategoryEntity> categories = reportRepository.findAll();
        System.out.println("List of categories: "+categories);

        assertEquals(6, categories.size());
    }

    @Test
    public void shouldGet7CategoriesAfterInsertion() throws Exception {
        // Adding a new depth to the database
        DepthCategoryEntity depthCategory = new DepthCategoryEntity((short)10, "5m");
        reportRepository.save(depthCategory);

        // Fetch all predefined depths from database
        ArrayList<DepthCategoryEntity> depthCategoryArrayList = reportRepository.findAll();
        System.out.println(depthCategoryArrayList);

        // Check if database has been updated
        assertEquals(7, depthCategoryArrayList.size());
    }
}
