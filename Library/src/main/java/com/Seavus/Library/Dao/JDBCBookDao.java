package com.Seavus.Library.Dao;

import java.util.List;

import com.Seavus.Library.Model.Book;

public interface JDBCBookDao {

	public void register(Book object);

	public List<Book> list();

	public void update(Book object);

	public void unregister(long id);

}
