package com.Seavus.Library.Service.Impl;

import java.util.List;

import com.Seavus.Library.Dao.HibernateBookDao;
import com.Seavus.Library.Dao.Impl.HibernateBookDaoImpl;
import com.Seavus.Library.Model.Book;
import com.Seavus.Library.Service.HibernateBookService;

public class HibernateBookServiceImpl implements HibernateBookService {

	HibernateBookDao bookDao = new HibernateBookDaoImpl();

	public void update(Book b) {
		bookDao.update(b);
	}

	public void register(Book b) {
		bookDao.register(b);
	}

	public List<Book> list() {
		return bookDao.list();
	}

	public void unregister(long id) {
		bookDao.unregister(id);
	}

	public void createSessionFactory() {
		bookDao.createSessionFactory();
	}

	public void closeSession() {
		bookDao.closeFactory();
	}

}
