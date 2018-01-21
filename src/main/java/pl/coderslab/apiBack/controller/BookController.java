package pl.coderslab.apiBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.coderslab.apiBack.model.Book;
import pl.coderslab.apiBack.model.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("")
	public List<Book> getList() {
		return this.bookService.getList();
	}

	@GetMapping("/{id}")
	public Book getById(@PathVariable long id) {
		
		return this.bookService.getById(id);
	}

	@PostMapping("")
	public Book addBook(@RequestBody Book book) {
		
		return this.bookService.add(book);
	}

	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable long id) {
		this.bookService.deleteById(id);
		return "{result: ok}";
	}

	@PutMapping("/{id}")
	public String putBook(@PathVariable long id, @RequestBody Book book) {
		this.bookService.edit(book);
		return "{result: ok}";
	}

}
