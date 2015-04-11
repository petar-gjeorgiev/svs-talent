package com.Seavus.AliExpress.Templates.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Seavus.AliExpress.Model.ShoppingBasket;

public class NewestBasketSetter implements JDBCBasketSetter {

	public ShoppingBasket execute(Connection connection) {
		List<ShoppingBasket> items = new ArrayList<ShoppingBasket>();
		ShoppingBasket basket = new ShoppingBasket();
		try {
			Statement statement = connection.createStatement();
			String sql = "select * from shoppingbasket";
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int sum = resultSet.getInt("sum");
				basket.setId(id);
				basket.setSum(sum);
				items.add(basket);
			}
			statement.close();
			basket = items.get(items.size() - 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return basket;
	}

}
