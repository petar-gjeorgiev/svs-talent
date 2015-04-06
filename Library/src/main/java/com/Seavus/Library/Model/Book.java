package com.Seavus.Library.Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;

@Entity
@DiscriminatorValue("book")
//@Table(name = "Book_Hibernate")
public class Book extends Publication {

	//@Id
	//@GeneratedValue
	//private long id;

	private String isbn;

	//private String title;

	public Book() {

	}

	public Book(long id, String isbn, String title) {
		super(id, title);
		this.isbn = isbn;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}
