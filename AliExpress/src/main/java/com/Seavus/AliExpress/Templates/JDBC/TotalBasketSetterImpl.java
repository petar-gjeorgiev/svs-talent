package com.Seavus.AliExpress.Templates.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TotalBasketSetterImpl implements TotalSumBasketSetter {

	private int id;
	
	public TotalBasketSetterImpl(int id) {
		this.id = id;
	}

	public int execute(Connection connection) {
		int res = 0;
		try {
			Statement statement = connection.createStatement();
			String sql = "select sum from shoppingbasket where id = " + id;
			ResultSet resultSet = statement.executeQuery(sql);

			if(resultSet.next()) {
				res = resultSet.getInt("sum");
			}
			
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}
