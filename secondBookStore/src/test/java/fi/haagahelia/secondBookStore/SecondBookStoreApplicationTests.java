package fi.haagahelia.secondBookStore;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.secondBookStore.web.BookController;
import fi.haagahelia.secondBookStore.web.UserDetailServiceImpl;
/**
* Testing that the context is creating your controller
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SecondBookStoreApplicationTests {

	@Autowired
	private BookController controller;

	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
		assertThat(userDetailServiceImpl).isNotNull();
	}

}
