package com.ust.cartservice;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ust.entity.Cart;

@Component
public interface CartService{

	// Add a book to Cart
	Cart addBooktoCart(Cart book);
	
	//List Of Books to Cart
	List<Cart> addBookListtoCart(List<Cart> bookList);

	// Remove Book from Cart
	Cart removeBook(Integer bookId);

	//View Books In Cart
	List<Cart> cartBook();

	//Get Status
	String getStatus();
}
