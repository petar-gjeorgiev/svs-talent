package com.Seavus.AliExpress.Templates.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BasketRegisterProduct implements JDBCSetter {

	private String productId;

	private int basketId;
	
	private int quantity;

	public BasketRegisterProduct(String productId, int basketId,int quantity) {
		this.productId = productId;
		this.basketId = basketId;
		this.quantity = quantity;
	}

	public void execute(Connection connection) {
		String sql = "insert into bill (productid,basketid,quantity) values(?,?,?)";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, productId);
			preparedStatement.setInt(2, basketId);
			preparedStatement.setInt(3, quantity);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
