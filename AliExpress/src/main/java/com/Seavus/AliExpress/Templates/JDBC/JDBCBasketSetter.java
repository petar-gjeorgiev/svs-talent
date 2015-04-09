package com.Seavus.AliExpress.Templates.JDBC;

import java.sql.Connection;

import com.Seavus.AliExpress.Model.ShoppingBasket;

public interface JDBCBasketSetter {

	public ShoppingBasket execute(Connection connection);

}
