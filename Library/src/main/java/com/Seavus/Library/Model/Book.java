package com.Seavus.Library.Model;

public class Book {

	private long id;

	private String isbn;

	private String title;

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

}
