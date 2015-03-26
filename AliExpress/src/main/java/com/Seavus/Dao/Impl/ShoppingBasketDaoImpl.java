package com.Seavus.Dao.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Seavus.AliExpress.Dao.ProductDao;
import com.Seavus.AliExpress.Dao.ShoppingBasketDao;
import com.Seavus.AliExpress.Exceptions.EmptyShoppingBasketException;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Model.ShoppingBasket;

public class ShoppingBasketDaoImpl implements ShoppingBasketDao {

	public static Connection connection;

	@Override
	public void addProduct(ShoppingBasket basket, Product p, int quantity) {

		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/AliExpress", "postgres",
					"library1!");

			String sql = "insert into shoppingBasket(baskte_id,product_id,quantity) values(?,?,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(2, p.getId());
			preparedStatement.setInt(1, basket.getId());
			preparedStatement.setInt(3, quantity);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void ListAllProducts(ShoppingBasket basket)
			throws EmptyShoppingBasketException {

		Product p = new Product();

		ProductDao productDao = new ProductDaoImpl();

		StringBuilder sb = new StringBuilder();

		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/AliExpress", "postgres",
					"library1!");

			String sql = "select * from shoppingBasket where basket_id = ?";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setInt(1, basket.getId());

			ResultSet resultSet = preparedStatement.executeQuery(sql);

			int sum = 0;
			String id = "ID";
			String name = "Name";
			String price = "Price";
			sb.append("\nShopping cart items:\n"
					+ String.format("%2s %-10s %-5s", id, name, price) + "\n");

			while (resultSet.next()) {
				String prodId = resultSet.getString("id");
				int quantity = resultSet.getInt("quantity");
				p = productDao.getProductById(prodId);

				sum += p.getPrice() * quantity;
				sb.append(p + "  " + "x" + quantity + "\n");

			}
			if (sum == 0) {
				throw new EmptyShoppingBasketException(
						"There are no products in the shopping basket!");
			}

			sb.append("\nSum: " + sum);

			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println(sb.toString());
	}

}
