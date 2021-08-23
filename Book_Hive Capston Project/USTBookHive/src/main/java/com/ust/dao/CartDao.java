package com.ust.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.entity.Book;
import com.ust.entity.Cart;

public interface CartDao extends JpaRepository<Cart, Integer>{

	Cart save(Book addedBook);



}
