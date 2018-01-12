package pl.coderslab.apiBack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.coderslab.apiBack.model.Book;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@GetMapping("/test")
	public Book test() {
		return new Book(1L,
				"9788324631766",
				"Thinking in Java",
				"Bruce Eckel",
				"Helion",
				"programming");
	}
	
}
