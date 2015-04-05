package com.Seavus.Library.Service;

import java.util.List;

import com.Seavus.Library.Model.Book;

public interface JDBCBookService {

	public void updateBook(Book b);
	
	public void registerBook(Book b);
	
	public List<Book> list();

	public void unregisterBook(long id);

}
