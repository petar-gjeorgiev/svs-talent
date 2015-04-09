package com.Seavus.AliExpress.Templates.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Seavus.AliExpress.Model.Product;

public class ProductRegisterSetter implements JDBCSetter {

	private Product product;

	public ProductRegisterSetter(Product product) {

		this.product = product;
	}

	@Override
	public void execute(Connection connection) {
		String sql = "insert into book(id,name,price,quantity) values(?,?,?,?)";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setInt(3, product.getPrice());
			preparedStatement.setInt(4, product.getQuantity());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
