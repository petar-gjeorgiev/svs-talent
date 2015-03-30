package com.Seavus.Library.Dao.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Seavus.Library.Dao.JDBCBookDao;
import com.Seavus.Library.Model.Book;

public class JDBCBookDaoImpl implements JDBCBookDao {

	public static Connection connection;

	public static final String DB = "jdbc:postgresql://localhost:5432/Library";

	public static final String USERNAME = "postgres";

	public static final String PASSWORD = "postgres";

	public void registerBook(Book book) {
		try {
			connection = DriverManager.getConnection(DB, USERNAME, PASSWORD);
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

	public String listAllBooks() {
		StringBuilder sb = new StringBuilder();
		try {
			connection = DriverManager.getConnection(DB, USERNAME, PASSWORD);
			Statement statement = connection.createStatement();
			String sql = "select * from book";
			ResultSet resultSet = statement.executeQuery(sql);
			String id1 = "ID";
			String isbn1 = "ISBN";
			String title1 = "TITLE";
			sb.append(String.format("%-4s %-8s %-15s", id1, isbn1, title1)
					+ "\n");
			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String isbn = resultSet.getString("isbn");
				String title = resultSet.getString("title");
				sb.append(String.format("%-4d %-8s %-15s", id, isbn, title)
						+ "\n");
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public void updateBook(Book book) {
		try {
			connection = DriverManager.getConnection(DB, USERNAME, PASSWORD);
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

	public void unregisterBook(long id1) {
		try {
			connection = DriverManager.getConnection(DB, USERNAME, PASSWORD);
			Long id = new Long(id1);
			String sql = "delete from book where id = " + id;
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
