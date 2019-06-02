package fi.haagahelia.secondBookStore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.secondBookStore.domain.Category;
import fi.haagahelia.secondBookStore.domain.Book;
import fi.haagahelia.secondBookStore.domain.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void findByTitleShouldReturnBook() {
        List<Book> books = repository.findByTitle("If tomorrow comes");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Sydney Sheldon");
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("To Kill a Mockingbird ","Harper Lee", 1960 ,new Category("Thriller"),12293, 39.50);;
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    
    

    @Test
    public void deleteBook() {
    	List<Book> books = repository.findByTitle("Dear John");
    	assertThat(books).hasSize(1);
    	repository.deleteById((long) 12);
    	books = repository.findByTitle("Dear John");
    	assertThat(books).hasSize(0);

    }

}
