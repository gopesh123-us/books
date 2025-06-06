package live.learnjava.books.controllers;

import live.learnjava.books.Entities.Book;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	private List<Book> books = new ArrayList<Book>();
	
	//constructor to initialize books
	public BookController(){
		initializeBooks();
	}
	private void initializeBooks(){
		books.addAll(List.of(
		new Book("Title One", "Author One", "Math"),
		new Book("Title Two", "Author Two", "Physics"),
		new Book("Title Three", "Author Three", "Science")
		));
	}
	
	
	@GetMapping("/api-endpoint")
	public String apiEndPoint() {
		return "Hello! Gopi";
	}
	
	@GetMapping("/books")
		public List<Book> findBooks(){
			return books;
		}
	}
	

