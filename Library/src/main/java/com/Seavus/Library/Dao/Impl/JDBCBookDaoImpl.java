package com.Seavus.Library.Dao.Impl;

import java.util.List;

import com.Seavus.Library.Dao.JDBCBookDao;
import com.Seavus.Library.Model.Book;
import com.Seavus.Library.Templates.JDBC.BookListSetter;
import com.Seavus.Library.Templates.JDBC.BookRegisterSetter;
import com.Seavus.Library.Templates.JDBC.BookUnregisterSetter;
import com.Seavus.Library.Templates.JDBC.BookUpdateSetter;
import com.Seavus.Library.Templates.JDBC.JDBCDaoTemplate;

public class JDBCBookDaoImpl implements JDBCBookDao {


	public JDBCDaoTemplate template = new JDBCDaoTemplate();

	public void register(Book book) {
		template.execute(new BookRegisterSetter(book));

	}

	public List<Book> list() {
		return template.executeList(new BookListSetter());
	}

	public void update(Book book) {
		template.execute(new BookUpdateSetter(book));
	}

	public void unregister(long id1) {
		template.execute(new BookUnregisterSetter(id1));
	}

}
