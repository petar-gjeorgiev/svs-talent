package com.Seavus.Library.Templates.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Seavus.Library.Model.Book;

public class BookUpdateSetter implements JDBCSetter {

	private Book b;
	
	public BookUpdateSetter(Book b) {
		this.b = b;
	}

	public void execute(Connection connection) {
		Long id = b.getId();
		String isbn = b.getIsbn();
		String title = b.getTitle();
		String sql = "update book set  isbn = ? ,title = ? where id = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, isbn);
			preparedStatement.setString(2, title);
			preparedStatement.setLong(3, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
