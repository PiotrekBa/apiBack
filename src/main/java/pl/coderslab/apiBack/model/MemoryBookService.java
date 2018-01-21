package pl.coderslab.apiBack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class MemoryBookService implements BookService {
	private static long nextid = 1L;
	private List<Book> list;

	public MemoryBookService() {
		this.list = new ArrayList<>();

		add(new Book(0, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));

		add(new Book(0, "9788324627738", "Rusz glowa, Java.", "Sierra Kathy, Bates Bert", "Helion",
				"programming"));

		add(new Book(0, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion",
				"programming"));

	}

	@Override
	public List<Book> getList() {
		return list;
	}

	@Override
	public void setList(List<Book> list) {
		this.list = list;
	}

	@Override
	public Book getById(long id) throws NoSuchElementException {

		Predicate<Book> bookById = c -> c.getId() == id;
		Book book = this.list.stream().filter(bookById).findFirst().get();
		return book;
	}


	@Override
	public void edit(Book book) throws NoSuchElementException {
		Book b = getById(book.getId());
		b = book;
	}

	@Override
	public void delete(Book book) throws NoSuchElementException {
		deleteById(book.getId());
	}

	@Override
	public void deleteById(long id) throws NoSuchElementException {
		Book b = getById(id);
		this.list.remove(b);
	}

	
	@Override
	public Book add(Book book) {
		book.setId(nextid++);
		this.list.add(book);
		return book;
	}

}
