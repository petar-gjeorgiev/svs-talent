package com.Seavus.Library.Templates.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Seavus.Library.Model.Book;

public class BookRegisterSetter implements JDBCSetter {

	private Book b;

	public BookRegisterSetter(Book b) {

		this.b = b;
	}

	public void execute(Connection connection) {
		String sql = "insert into book(isbn,title) values(?,?)";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, b.getIsbn());
			preparedStatement.setString(2, b.getTitle());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
