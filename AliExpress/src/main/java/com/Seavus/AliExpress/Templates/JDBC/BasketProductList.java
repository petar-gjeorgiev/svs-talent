package com.Seavus.AliExpress.Templates.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Seavus.AliExpress.Dao.ProductDao;
import com.Seavus.AliExpress.Exceptions.EmptyShoppingBasketException;
import com.Seavus.AliExpress.Model.Product;

public class BasketProductList implements JDBCListSetter {

	private int id;

	private ProductDao productDao;
	
	public BasketProductList(int id,ProductDao productDao) {
		this.id = id;
		productDao = this.productDao;
	}

	public List<Product> execute(Connection connection) {
		List<Product> products = new ArrayList<Product>();
		try {
			Statement statement = connection.createStatement();
			String sql = "select productId  from bill where id = " + id;
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				Product p = productDao.getProductById(id);
				products.add(p);
			}
			if(products.size() == 0) {
				try {
					throw new EmptyShoppingBasketException("Empty basket");
				} catch (EmptyShoppingBasketException e) {
					e.printStackTrace();
				}
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

}
