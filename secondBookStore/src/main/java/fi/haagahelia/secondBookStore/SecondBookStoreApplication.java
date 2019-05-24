package fi.haagahelia.secondBookStore;

import org.apache.commons.logging.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.secondBookStore.domain.Book;
import fi.haagahelia.secondBookStore.domain.BookRepository;
import fi.haagahelia.secondBookStore.domain.Category;
import fi.haagahelia.secondBookStore.domain.CategoryRepository;

@SpringBootApplication
public class SecondBookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondBookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository,CategoryRepository crepository) {
	return (args) -> {
		
		
		crepository.save( new Category("Children"));
		crepository.save( new Category("Non-fiction"));
		crepository.save( new Category("Fiction"));
		crepository.save(new Category("Comic"));
		crepository.save(new Category("Crime"));
		crepository.save(new Category("Education"));
		
		Book b1 = new Book("If tomorrow comes","Sydney Sheldon", 1985,crepository.findByName("Crime").get(0),12223, 35.50);
		Book b2 = new Book("The Lord of the Rings","J. R. R. Tolkien", 1937,crepository.findByName("Non-fiction").get(0),12224, 45.00);
		Book b3 = new Book("Frankenstein","Mary Shelley", 1823,crepository.findByName("Education").get(0),12225, 25.50);
		Book b4 = new Book("Hamlet"," William Shakespeare", 1609,crepository.findByName("Comic").get(0),12221, 55.00);

		
		repository.save(b1);
		repository.save(b2);
		repository.save(b3);
		repository.save(b4);
		
	
	};
	}

}
