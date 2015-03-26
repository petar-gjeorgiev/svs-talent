package com.Seavus.Library.Dao.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Seavus.Library.Dao.BookDao;
import com.Seavus.Library.Model.Book;

public class BookDaoImpl implements BookDao {
	
	public static Connection connection;
	
	@Override
	public void registerBook(Book book) {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "postgres");
			String sql = "insert into book(isbn,title) values(?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, book.getIsbn());
			preparedStatement.setString(2, book.getTitle());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void listAllBooks() {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "postgres");
			Statement statement = connection.createStatement();
			String sql = "select * from book";
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
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

	@Override
	public void updateBook(Book book) {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "postgres");
			Long id = book.getId();
			String isbn = book.getIsbn();
			String title = book.getTitle();
			String sql = "update book set  isbn = ? ,title = ? where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, book.getIsbn());
			preparedStatement.setString(2, book.getTitle());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void unregisterBook(Book book) {
		
	}

}
