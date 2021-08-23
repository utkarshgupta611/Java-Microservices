package com.ust.cartservice;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ust.dao.CartDao;
import com.ust.entity.Cart;

@RunWith(MockitoJUnitRunner.class)
class CartserviceImplTest {

	@InjectMocks
	private CartService cService;
	
	@Mock
	private CartDao cDao;
	
	@Test
	void testAddBooktoCart() {
		Cart addedBook = new Cart(41, "Harry Potter", 250);
		cDao = Mockito.mock(CartDao.class);
		Mockito.when(cDao.save(addedBook)).thenReturn(addedBook);
	}
	
	@Test
	void testAddBookListtoCart() {
		List<Cart> bookListL = new ArrayList<>();
		Cart addedBook = new Cart(41, "Harry Potter", 250);
		Cart addedBook1 = new Cart(42, "Harry Potter2", 2520);
		bookListL.add(addedBook);
		bookListL.add(addedBook1);
		cDao = Mockito.mock(CartDao.class);
		Mockito.when(cDao.save(addedBook)).thenReturn(addedBook);
	}

//	@Test(expected = BookNotFoundException.class)
//	void testRemoveBook() throws BookNotFoundException{
//		Cart deletedBook = new Cart(41, "Harry Potter", 250);
//		cDao = Mockito.mock(CartDao.class);
//		Mockito.when(cDao.delete(deletedBook)).thenReturn(deletedBook);
//	}
}
