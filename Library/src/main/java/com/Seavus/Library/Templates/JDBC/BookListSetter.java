package com.Seavus.Library.Templates.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Seavus.Library.Model.Book;

public class BookListSetter implements JDBCListSetter {

	public List<Book> execute(Connection connection) {
		List<Book> books = new ArrayList<Book>();
		try {
			Statement statement = connection.createStatement();
			String sql = "select * from book";
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String isbn = resultSet.getString("isbn");
				String title = resultSet.getString("title");
				books.add(new Book(id, isbn, title));
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

}
