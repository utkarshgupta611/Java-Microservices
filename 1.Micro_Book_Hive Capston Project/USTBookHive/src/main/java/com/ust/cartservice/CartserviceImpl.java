package com.ust.cartservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ust.bookservice.BookService;
import com.ust.cartStatus.Status;
import com.ust.dao.CartDao;
import com.ust.entity.Cart;
import com.ust.exception.BookNotFoundException;

@Service("cService")
public class CartserviceImpl implements CartService{

	// Book List
		@Autowired
		private CartDao cDao;
		
	// To View All Book in Status
		@Autowired
		private BookService bService;
		

	//Cart Status
	@Autowired
	private Status status;
	//--------------- * --------------- * --------------- Cart Service --------------- * --------------- * ---------------
				
	// Add Book
	@Override
	public Cart addBooktoCart(Cart book) 
	{
		return cDao.save(book);
	}

	//Add List Of Books
	@Override
	public List<Cart> addBookListtoCart(List<Cart> bookList) 
	{
		List<Cart> bookListL = new ArrayList<>();
		for (Cart cart : bookList)
		{
			bookListL.add(cart);
		}
		return cDao.saveAll(bookList);
	}

	//Remove Book To Cart
	@Override
	public Cart removeBook(Integer bookId) {
		Optional<Cart> opt = cDao.findById(bookId);
		if(opt.isPresent()) 
		{
			Cart cartdel = opt.get();
			cDao.delete(cartdel);
			return cartdel;
		}
		else 
		{
		throw new BookNotFoundException("Failed to Find  Book to Delete");
		}
	}

	//All the Books In Cart
	@Override
	public List<Cart> cartBook()
	{
		return cDao.findAll();
	}

	// Get Status of Customer
	@Override
	public String getStatus() 
	{
		if(!cDao.findAll().isEmpty()) 
		{
			return status.getStatusNe();
		}
		else 
		{
			bService.getAllBookDetails();
		}
		return status.getEmptystatus() + "\n" + "\n" + bService.getAllBookDetails();
	}
}


