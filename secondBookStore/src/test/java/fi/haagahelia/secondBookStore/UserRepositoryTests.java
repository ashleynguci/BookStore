package fi.haagahelia.secondBookStore;

import static org.assertj.core.api.Assertions.assertThat;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import fi.haagahelia.secondBookStore.domain.UserRepository;
import fi.haagahelia.secondBookStore.domain.User;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository urepository;

    @Test
    public void findByUserNameShouldReturnUser() {
        
       User users = urepository.findByUsername("user");
        
        assertThat(users.getRole()).isEqualTo("USER");
    }
    
  
}
