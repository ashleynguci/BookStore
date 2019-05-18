package fi.haagahelia.secondBookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.secondBookStore.domain.Book;
import fi.haagahelia.secondBookStore.domain.BookRepository;
import fi.haagahelia.secondBookStore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository crepository;
	@RequestMapping("/booklist")
	public String bookList(Model model) {
		  model.addAttribute("books",repository.findAll());
		  return "booklist";
		  //return name of template
	}
	@RequestMapping(value="/add")
	public String addBook(Model model) {
		model.addAttribute("book",new Book());
		model.addAttribute("category", crepository.findAll());
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
	
	
	return "editbook";
	
	}
}
