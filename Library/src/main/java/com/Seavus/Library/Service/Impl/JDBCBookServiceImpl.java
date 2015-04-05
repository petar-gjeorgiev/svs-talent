package com.Seavus.Library.Service.Impl;
import java.util.List;

import com.Seavus.Library.Dao.JDBCBookDao;
import com.Seavus.Library.Dao.Impl.JDBCBookDaoImpl;
import com.Seavus.Library.Model.Book;
import com.Seavus.Library.Service.JDBCBookService;

public class JDBCBookServiceImpl implements JDBCBookService {

	public JDBCBookDao bookDao = new JDBCBookDaoImpl();

	public void updateBook(Book b) {
		bookDao.update(b);
	}

	public void registerBook(Book b) {
		bookDao.register(b);
	}

	public List<Book> list() {
		return bookDao.list();
	}

	public void unregisterBook(long id) {
		bookDao.unregister(id);
	}



}
