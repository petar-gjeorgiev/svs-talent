package com.Seavus.AliExpress.Templates.JDBC;

import java.sql.Connection;
import java.util.List;

import com.Seavus.AliExpress.Model.Product;

public interface JDBCListSetter {

	public List<Product> execute(Connection connection);
	
}
