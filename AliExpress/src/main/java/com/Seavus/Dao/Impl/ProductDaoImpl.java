package com.Seavus.Dao.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Seavus.AliExpress.Dao.ProductDao;
import com.Seavus.AliExpress.Model.Product;

public class ProductDaoImpl implements ProductDao {

	public static Connection connection;

	@Override
	public Product getProductById(String id) {

		Product p = new Product();

		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/AliExpress", "postgres",
					"library1!");

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

	@Override
	public void listAllProducts() {
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/AliExpress", "postgres",
					"library1!");
			Statement statement = connection.createStatement();
			String sql = "select * from product";
			ResultSet resultSet = statement.executeQuery(sql);
			List<Product> products = new ArrayList<Product>();
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				String name = resultSet.getString("name");
				int price = resultSet.getInt("price");
				int quantity = resultSet.getInt("quantity");
				products.add(new Product(id, name, price, quantity));
			}
			statement.close();

			StringBuilder sb = new StringBuilder();
			sb.append("List of all products:\n");
			String id = "ID";
			String name = "Name";
			String price = "Price";
			sb.append(String.format("%2s %-10s %-5s", id, name, price) + "\n");
			for (Product p : products) {
				sb.append(p + "\n");
			}
			System.out.println(sb.toString());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addProduct(Product p) {
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/AliExpress", "postgres",
					"library1!");

			String sql = "insert into product(name,price,quantity) values(?,?,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, p.getName());
			preparedStatement.setInt(2, p.getPrice());
			preparedStatement.setInt(3, p.getQuantity());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeProduct(Product p) {
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/AliExpress", "postgres",
					"library1!");
			String id = p.getId();
			String sql = "delete from product where id = " + id;
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
