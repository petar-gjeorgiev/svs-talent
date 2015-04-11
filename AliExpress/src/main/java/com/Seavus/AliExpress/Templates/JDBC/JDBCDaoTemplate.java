package com.Seavus.AliExpress.Templates.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Set;

import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Model.ShoppingBasket;

public class JDBCDaoTemplate {

	public static final String DB = "jdbc:postgresql://localhost:5432/AliExpress";

	public static final String USERNAME = "postgres";

	public static final String PASSWORD = "postgres";

	public static Connection connection;

	public Connection getConnection() {
		try {
			connection = DriverManager.getConnection(DB, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void execute(JDBCSetter setter) {
		setter.execute(getConnection());
	}

	public Product executeProduct(JDBCProductSetter setter) {
		return setter.execute(getConnection());
	}

	public Set<Product> executeList(JDBCListSetter setter) {
		return setter.execute(getConnection());
	}
	
	public ShoppingBasket executeNewestBasket(JDBCBasketSetter setter) {
		return setter.execute(getConnection());
	}
	
	public int getTotalSum (TotalSumBasketSetter setter) {
		return setter.execute(getConnection());
	}
	
}
