package com.ust.bookservice;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.controller.BookHiveController;
import com.ust.dao.BookDao;
import com.ust.entity.Book;


@Service("bService")
public class BookServiceImpl implements BookService {

	// Book List
	@Autowired
	private BookDao bDao;
	
	//--------------- * --------------- * --------------- Services --------------- * --------------- * ---------------
	
	// Get All Book Details	
	@Override
	public List<Book> getAllBookDetails() {
		return bDao.findAll();
	}

	// Add Book
	@Override
	public Book addBook(Book book) {
		return bDao.save(book);
	}

	// Update Book
	@Override
	public Book updateBook(Book book) {
	Optional<Book> opt = bDao.findById(book.getBookId());
	if(opt.isPresent()) {
		Book booktemp = opt.get();
		booktemp.copy(book);
		bDao.save(booktemp);
		return booktemp;
	}
		return null;
	}

	//Delete a Book
	@Override
	public Book deleteBook(Integer bookId) {
		Optional<Book> opt = bDao.findById(bookId);
		if(opt.isPresent()) {
		Book bookdel = opt.get();
		bDao.delete(bookdel);
		return bookdel;
		}
		return null;
	}

	// Get all Book Names
	@Override
	public List<String> getAllBookNames() {
		return bDao.getBookNames();
	}

	// Select By Genre
	@Override
	public List<Book> findByGenre(String genre) {
		return bDao.findByGenre(genre);
	}
}
