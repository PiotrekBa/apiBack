package pl.coderslab.apiBack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class MemoryBookService {
	private List<Book> list;

	public MemoryBookService() {
		this.list = new ArrayList<>();

		list = new ArrayList<>();
		list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));

		list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.", "Sierra Kathy, Bates Bert", "Helion",
				"programming"));

		list.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion",
				"programming"));

	}

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}

	public Book getById(long id) throws NoSuchElementException {

		Predicate<Book> bookById = c -> c.getId() == id;
		Book book = this.list.stream().filter(bookById).findFirst().get();
		return book;
	}

	public void edit(Book book) throws NoSuchElementException {
		Book b = getById(book.getId());
		b = book;
	}

	public void delete(Book book) throws NoSuchElementException {
		deleteById(book.getId());
	}

	public void deleteById(long id) throws NoSuchElementException {
		Book b = getById(id);
		this.list.remove(b);
	}

}
