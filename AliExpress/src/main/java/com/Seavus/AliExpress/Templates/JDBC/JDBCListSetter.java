package com.Seavus.AliExpress.Templates.JDBC;

import java.sql.Connection;
import java.util.Set;

import com.Seavus.AliExpress.Model.Product;

public interface JDBCListSetter {

	public Set<Product> execute(Connection connection);
	
}
