package com.Seavus.AliExpress.Templates.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Seavus.AliExpress.Model.Product;

public class ProductByIdSetter implements JDBCProductSetter {

	private String id;

	public ProductByIdSetter(String id) {
		this.id = id;
	}

	public Product execute(Connection connection) {
		Product p = new Product();
		try {
			String sql = "select * from product where id = ?";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, id);

			ResultSet resultSet = preparedStatement.executeQuery(sql);

			if (resultSet.next()) {
				String prodId = resultSet.getString("id");
				String name = resultSet.getString("name");
				int price = resultSet.getInt("price");
				int quantity = resultSet.getInt("quantity");
				p.setId(prodId);
				p.setName(name);
				p.setPrice(price);
				p.setQuantity(quantity);
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

}
