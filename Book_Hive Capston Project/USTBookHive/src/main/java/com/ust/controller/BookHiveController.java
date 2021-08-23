package com.ust.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.bookservice.BookService;
import com.ust.cartservice.CartService;
import com.ust.entity.Book;
import com.ust.entity.Cart;

@RestController
public class BookHiveController {
	
	// Book Service
	@Autowired
	private BookService bService;

	// aCart Service
	@Autowired
	private CartService cService;
	
	// Log Service
	private static final Logger logger = LoggerFactory.getLogger(BookHiveController.class);
	
	// --------------- * --------------- * ---------------ADMIN ACCESS--------------- * --------------- * ---------------
	
	// ADD New Book
	@PostMapping("/a/ADMIN/addBook")
	public Book addBook(@RequestBody Book book) {
		logger.info("Adding Book in Book List   **ADMIN**--->", book);
		Book addedBook = bService.addBook(book);
		return addedBook;
	}
	
	// Update Book
	@PutMapping("/a/ADMIN/update")
	public Book updateBook(@RequestBody Book book) {
		Book updatedBook = bService.updateBook(book);
		return  updatedBook;
	}
	
	// Delete Book
	@DeleteMapping("/a/ADMIN/delete/{bookId}")
	public Book deleteBook(@PathVariable Integer bookId){
		logger.info("Deleting Book in Book List **ADMIN** --->", bookId);
		Book deletedBook = bService.deleteBook(bookId);	
		return deletedBook;
	}
	
	// --------------- * --------------- * ---------------USER's--------------- * --------------- * ---------------
	
	// View All Details
		@GetMapping("/u/USER/allBook")
		public List<Book> getAllBookDetails(){
			List<Book> bookDetailList = bService.getAllBookDetails();
			return bookDetailList;
		}
		
	//View All Book Names
	@GetMapping("/u/USER/allBookNames")
	public List<String> getAllBookNames(){
		List<String> bookNamesList = bService.getAllBookNames();
		return bookNamesList;
	}
	
	// Filter By Genre
	@GetMapping("/u/USER/genre/{genre}")
	public List<Book> filterByGenre(@PathVariable("genre") String genre){
		List<Book> bookGenreList = bService.findByGenre(genre);
		return bookGenreList;
	}
	
	// Customer Status
	@GetMapping("/u/USER/status")
	public String customerStatus()
	{
		String status = cService.getStatus();
		return status;
	}
	
	// --------------- * --------------- * ---------------CART SERVICE--------------- * --------------- * ---------------
	
	// ADD New Book In Cart
		@PostMapping("/c/CART/addBook")
		public Cart addBooktoCart(@RequestBody Cart book) {
			logger.info("Adding Book in Cart List --->", book);
			Cart addedBook = cService.addBooktoCart(book);
			return addedBook;
		}
		
	// ADD List of  Books In Cart
		@PostMapping("/c/CART/addListBook")
		public List<Cart> addBookListtoCart(@RequestBody List<Cart> bookList) {
			logger.info("Added List of Book in Cart List --->", bookList);
		List<Cart> addedBookList = (List<Cart>) cService.addBookListtoCart(bookList);
		return addedBookList;
		}
			
	// Remove Books In Cart
		@DeleteMapping("/c/CART/removeBook/{bookId}")
		public Cart removeBook(@PathVariable Integer bookId){
			logger.info("Deleting Book in Cart List --->", bookId);
			Cart removedBook = cService.removeBook(bookId);	
			return removedBook;
		}
		
	// View All Details
		@GetMapping("/c/CART/cartBook")
		public List<Cart> cartBook(){
			List<Cart> bookCart = cService.cartBook();
			return bookCart;
				}
}





