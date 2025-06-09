package live.learnjava.books.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import live.learnjava.books.Entities.Book;

@RestController
public class BookController {

	private List<Book> books = new ArrayList<Book>();

	// constructor to initialize books
	public BookController() {
		initializeBooks();
	}

	private void initializeBooks() {
		books.addAll(List.of(new Book("Title One", "Author One", "Math"),
				new Book("Title Two", "Author Two", "Physics"), new Book("Title Three", "Author Three", "Science")));
	}

	@GetMapping("/api-endpoint")
	public String apiEndPoint() {
		return "Hello! Gopi";
	}

	@GetMapping("/books")
	public List<Book> findBooks() {
		return books;
	}

	@GetMapping("/books/{title}")
	public Book getBookByTitle(@PathVariable String title) {
		return books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
	}
}
