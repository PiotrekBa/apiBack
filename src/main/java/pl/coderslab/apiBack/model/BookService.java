package pl.coderslab.apiBack.model;

import java.util.List;
import java.util.NoSuchElementException;

public interface BookService {

	List<Book> getList();

	void setList(List<Book> list);

	Book getById(long id) throws NoSuchElementException;

	void edit(Book book) throws NoSuchElementException;

	void delete(Book book) throws NoSuchElementException;

	void deleteById(long id) throws NoSuchElementException;

	Book add(Book book);

}