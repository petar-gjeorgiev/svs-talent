package com.Seavus.Library.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Book_Hibernate")
public class Book {

	@Id
	@GeneratedValue
	private long id;

	private String isbn;

	private String title;

	public Book() {

	}

	public Book(String isbn, String title) {
		this.isbn = isbn;
		this.title = title;
	}
	
	public Book(long id,String title) {
		this.id = id;
		this.title = title;
	}

	public Book(long id, String isbn, String title) {
		this.id = id;
		this.isbn = isbn;
		this.title = title;
	}

	public long getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return String.format("Title: %s ISBN: %s", title,isbn);
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
