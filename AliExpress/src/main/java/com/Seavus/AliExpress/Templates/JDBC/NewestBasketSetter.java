package com.Seavus.AliExpress.Templates.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Seavus.AliExpress.Model.ShoppingBasket;

public class NewestBasketSetter implements JDBCBasketSetter {

	@Override
	public ShoppingBasket execute(Connection connection) {
		ShoppingBasket basket = new ShoppingBasket();
		try {
			Statement statement = connection.createStatement();
			String sql = "select LAST(id),LAST(sum) from shoppingBasket";
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				int sum = resultSet.getInt("sum");
				basket.setId(id);
				basket.setSum(sum);
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return basket;
	}

}
