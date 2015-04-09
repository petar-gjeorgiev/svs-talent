package com.Seavus.AliExpress.Templates.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Seavus.AliExpress.Model.Product;

public class ProductUpdateSetter implements JDBCSetter {

	private Product product;

	public ProductUpdateSetter(Product product) {
		this.product = product;
	}

	@Override
	public void execute(Connection connection) {
		String id = product.getId();
		String name = product.getName();
		int quantity = product.getQuantity();
		int price = product.getPrice();
		
		String sql = "update product set  name = ? ,price = ? , quantity = ? where id = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, price);
			preparedStatement.setInt(3, quantity);
			preparedStatement.setString(4, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
