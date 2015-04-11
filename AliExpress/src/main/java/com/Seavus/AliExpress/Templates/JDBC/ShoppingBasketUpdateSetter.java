package com.Seavus.AliExpress.Templates.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Seavus.AliExpress.Model.ShoppingBasket;

public class ShoppingBasketUpdateSetter implements JDBCSetter {

	private ShoppingBasket basket;

	public ShoppingBasketUpdateSetter(ShoppingBasket basket) {
		this.basket = basket;
	}

	public void execute(Connection connection) {

		String sql = "update shoppingbasket set sum = ? where id = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(2, basket.getId());
			preparedStatement.setInt(1, basket.getSum());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
