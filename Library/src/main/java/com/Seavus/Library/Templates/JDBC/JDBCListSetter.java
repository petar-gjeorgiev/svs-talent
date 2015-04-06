package com.Seavus.Library.Templates.JDBC;

import java.sql.Connection;
import java.util.List;

import com.Seavus.Library.Model.Book;

public interface JDBCListSetter {

	public List<Book> execute(Connection connection);
	
}
