package com.Seavus.Library.Service;

import java.util.List;

import com.Seavus.Library.Model.Book;

public interface HibernateBookService {

	public void createSessionFactory();

	public void update(Book b);

	public void register(Book b);

	public List<Book> list();

	public void unregister(long id);

	public void closeSession();
}
