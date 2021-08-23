package com.ust.bookservice;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ust.dao.BookDao;
import com.ust.entity.Book;

@RunWith(MockitoJUnitRunner.class)
class BookServiceImplTest {

	@InjectMocks
	private BookService bService;
	
	@Mock
	private BookDao bDao;
	
	@Test
	void testAddBook() {
		Book addedBook = new Book(41, "Harry Potter", 250, "JK Rowling", "Fiction");
		bDao = Mockito.mock(BookDao.class);
		Mockito.when(bDao.save(addedBook)).thenReturn(addedBook);
	}

	@Test
	void testUpdateBook() {
		Book addedBook = new Book(41, "Harry Potter", 250, "JK Rowling", "Fiction");
		Book book = new Book(41, "Harry Potter", 300, "JK Rowling", "Fiction");
		bDao = Mockito.mock(BookDao.class);
		Optional<Book> opt = bDao.findById(41);
		if(opt.isPresent()) {
			Book booktemp = opt.get();
			booktemp.copy(book);
			bDao.save(booktemp);
			Mockito.when(bDao.save(addedBook)).thenReturn(book);
		}
	}
}
