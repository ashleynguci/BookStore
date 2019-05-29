package fi.haagahelia.secondBookStore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.secondBookStore.domain.Book;
import fi.haagahelia.secondBookStore.domain.BookRepository;
import fi.haagahelia.secondBookStore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository crepository;
	
	//Show all books
	@RequestMapping(value ="/booklist")
	public String bookList(Model model) {
		  model.addAttribute("books",repository.findAll());
		  return "booklist";
		  //return name of template
	}
	
//	// RESTful service to get all book
	@RequestMapping(value ="/books", method = RequestMethod.GET)	public @ResponseBody List<Book> bookListRest(){
		return (List<Book>) repository.findAll();
	}
//	
//
//	// RESTful service to get student by id
    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {	
   	return repository.findById(bookId);
    }       
   
	@RequestMapping(value="/add")
	public String addBook(Model model) {
		model.addAttribute("book",new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
		
		return "redirect:booklist";
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String deleteBook(@PathVariable("id")Long bookId, Model model ) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable("id") Long bookId, Model model){
	model.addAttribute("book", repository.findById(bookId));
	model.addAttribute("categories", crepository.findAll());
	
	return "editbook";
	
	}
	
}
