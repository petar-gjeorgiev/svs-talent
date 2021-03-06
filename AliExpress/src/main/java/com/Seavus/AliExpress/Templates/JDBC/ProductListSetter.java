package com.Seavus.AliExpress.Templates.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.Seavus.AliExpress.Model.Product;

public class ProductListSetter implements JDBCListSetter {

	public Set<Product> execute(Connection connection) {
		Set<Product> products = new HashSet<Product>();
		try {
			Statement statement = connection.createStatement();
			String sql = "select * from product";
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				String name = resultSet.getString("name");
				int quantity = resultSet.getInt("quantity");
				int price = resultSet.getInt("price");
				products.add(new Product(id, name, price, quantity));
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

}
