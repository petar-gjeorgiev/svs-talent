package com.Seavus.AliExpress.Templates.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Seavus.AliExpress.Model.Product;

public class ProductByIdSetter implements JDBCProductSetter {

	private String id;

	public ProductByIdSetter(String id) {
		this.id = id;
	}

	public Product execute(Connection connection) {
		Product p = new Product();
		try {
			Statement statement = connection.createStatement();
			String sql = "select * from product where id = '" + id + "'";
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				String id = resultSet.getString("id");
				String name = resultSet.getString("name");
				int quantity = resultSet.getInt("quantity");
				int price = resultSet.getInt("price");
				p = new Product(id,name,price,quantity);
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

}
