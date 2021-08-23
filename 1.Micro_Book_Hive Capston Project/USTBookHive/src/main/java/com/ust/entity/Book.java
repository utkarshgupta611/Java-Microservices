package com.ust.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "BookList")
public class Book {

	@Id
	@GeneratedValue
	private int bookId;
	private String bookName;
	private double bookPrice;
	private String authors;
	private String genre;


	// --------------- * --------------- * --------------- Constructor --------------- * --------------- * ---------------

	public Book() {}
	
	public Book(int bookId, String bookName, double bookPrice) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
	}
	public Book(int bookId, String bookName, double bookPrice, String authors, String genre) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.authors = authors;
		this.genre = genre;
	}

	// --------------- * --------------- * --------------- Copy Method --------------- * --------------- * ---------------

		public void copy(Book book) {
			this.bookName = book.getBookName();
			this.bookPrice = book.getBookPrice();
		}	
	
	// --------------- * --------------- * --------------- Getter And Setter --------------- * --------------- * ---------------
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	
	@Override
	public String toString() {
		return "[bookId=" + bookId + ", bookName=" + bookName + ", bookPrice=" + bookPrice + ", authors=" + authors
				+ ", genre=" + genre + "]" + "\n";
	}

	
	
}
