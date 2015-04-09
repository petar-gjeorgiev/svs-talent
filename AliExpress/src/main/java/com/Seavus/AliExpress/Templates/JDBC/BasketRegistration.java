package com.Seavus.AliExpress.Templates.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BasketRegistration implements JDBCSetter {

	@Override
	public void execute(Connection connection) {
		String sql = "insert into shoppingBasket (sum) values(?)";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			int sum = 0;
			preparedStatement.setInt(1, sum);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	

}
