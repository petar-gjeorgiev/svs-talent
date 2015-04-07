package com.Seavus.Library.Templates.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.Seavus.Library.Model.Book;

public class JDBCDaoTemplate {

	public static final String DB = "jdbc:postgresql://localhost:5432/Library";

	public static final String USERNAME = "postgres";

	public static final String PASSWORD = "library1!";

	public static Connection connection;

	public Connection getConnection() {
		try {
			connection = DriverManager.getConnection(DB, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void execute(JDBCSetter setter) {
		setter.execute(getConnection());
	}
	
	public List<Book> executeList(JDBCListSetter setter) {
		return setter.execute(getConnection());
	}

}
