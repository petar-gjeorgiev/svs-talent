package com.Seavus.AliExpress.Templates.JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductUnregisterSetter implements JDBCSetter {

	private String id;

	public ProductUnregisterSetter(String id) {
		this.id = id;
	}

	@Override
	public void execute(Connection connection) {
		try {
			String sql = "delete from product where id = " + id;
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
