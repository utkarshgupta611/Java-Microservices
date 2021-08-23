package com.ust.bookservice;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ust.entity.Book;

@Component
public interface BookService {

	List<Book> getAllBookDetails();

	Book addBook(Book book);

	Book updateBook(Book book);

	Book deleteBook(Integer bookId);

	List<String> getAllBookNames();

	List<Book> findByGenre(String genre);

}
