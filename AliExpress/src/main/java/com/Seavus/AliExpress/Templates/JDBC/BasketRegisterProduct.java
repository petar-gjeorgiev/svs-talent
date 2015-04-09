package com.Seavus.AliExpress.Templates.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BasketRegisterProduct implements JDBCSetter {

	private String productId;

	private int basketId;

	public BasketRegisterProduct(String productId, int basketId) {
		this.productId = productId;
		this.basketId = basketId;
	}

	@Override
	public void execute(Connection connection) {
		String sql = "insert into bill (productId,basketId) values(?,?)";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, productId);
			preparedStatement.setInt(2, basketId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
