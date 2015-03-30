package com.Seavus.Library.Dao;

import com.Seavus.Library.Model.Book;

public interface JDBCBookDao {

	public void registerBook(Book book);

	public String listAllBooks();

	public void updateBook(Book book);

	public void unregisterBook(long id);

}
