package com.Seavus.Library.Templates.JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BookUnregisterSetter implements JDBCSetter {

	private long id;

	public BookUnregisterSetter(long id) {

		this.id = id;
	}

	public void execute(Connection connection) {
		try {
			Long id = new Long(this.id);
			String sql = "delete from book where id = " + id;
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
