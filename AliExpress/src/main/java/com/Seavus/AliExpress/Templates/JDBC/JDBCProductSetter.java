package com.Seavus.AliExpress.Templates.JDBC;

import java.sql.Connection;

import com.Seavus.AliExpress.Model.Product;

public interface JDBCProductSetter {

	public Product execute(Connection connection);
}
