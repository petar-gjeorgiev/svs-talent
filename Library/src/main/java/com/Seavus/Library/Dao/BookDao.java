package com.Seavus.Library.Dao;

import com.Seavus.Library.Model.Book;

public interface BookDao {

	public void registerBook(Book book);

	public void listAllBooks();

	public void updateBook(Book book);

	public void unregisterBook(Book book);

}
