package fi.haagahelia.secondBookStore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.secondBookStore.domain.Category;
import fi.haagahelia.secondBookStore.domain.CategoryRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTests {

    @Autowired
    private CategoryRepository crepository;

    @Test
    public void findByNameShouldReturnCategory() {
        
        List<Category> categories = crepository.findByName("Crime");
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getCategoryid()).isNotNull();
    }
    
    @Test
    public void deleteCategory() {
		List<Category> categories = crepository.findByName("Fiction");
		assertThat(categories).hasSize(1);
    	crepository.deleteById((long) 3);
    	categories = crepository.findByName("Fiction");
    	assertThat(categories).hasSize(0);
    }
  
}
