package com.Seavus.Library.Dao.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Seavus.Library.Dao.BookDao;
import com.Seavus.Library.Model.Book;

public class JDBCBookDaoImpl implements BookDao {

	/**
	 * 
	 * 
	 */
	public static Connection connection;

	public void registerBook(Book book) {
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/Library", "postgres",
					"library1!");
			String sql = "insert into book(isbn,title) values(?,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, book.getIsbn());
			preparedStatement.setString(2, book.getTitle());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void listAllBooks() {
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/Library", "postgres",
					"library1!");
			Statement statement = connection.createStatement();
			String sql = "select * from book";
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String isbn = resultSet.getString("isbn");
				String title = resultSet.getString("title");
				System.out.println(id + " | " + isbn + " | " + title);
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateBook(Book book) {
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/Library", "postgres",
					"library1!");
			Long id = book.getId();
			String isbn = book.getIsbn();
			String title = book.getTitle();
			String sql = "update book set  isbn = ? ,title = ? where id = ?";
			PreparedStatement preparedStatement = connection
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

	public void unregisterBook(Book book) {
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/Library", "postgres",
					"library1!");
			Long id = book.getId();
			String sql = "delete from book where id = " + id;
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
