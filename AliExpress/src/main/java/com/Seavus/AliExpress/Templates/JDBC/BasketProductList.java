package com.Seavus.AliExpress.Templates.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.Seavus.AliExpress.Dao.ProductDao;
import com.Seavus.AliExpress.Dao.Impl.ProductDaoImpl;
import com.Seavus.AliExpress.Exceptions.EmptyShoppingBasketException;
import com.Seavus.AliExpress.Model.Product;

public class BasketProductList implements JDBCListSetter {

	private int id;
	
	private ProductDao productDao;
	
	public BasketProductList(int id,ProductDao productDao) {
		this.id = id;
		productDao = this.productDao;
	}

	public Set<Product> execute(Connection connection) {
		Set<Product> products = new HashSet<Product>();
		Product p = new Product();
		try {
			Statement statement = connection.createStatement();
			String sql = "select productid,quantity  from bill where basketid = " + id;
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				productDao = new ProductDaoImpl();
				String product_id = resultSet.getString("productid");
				int quantity = resultSet.getInt("quantity");
				p = productDao.getProductById(product_id);
				p.setQuantity(quantity);
				products.add(p);
			}
			if(products.size() == 0) {
				try {
					throw new EmptyShoppingBasketException("Empty basket");
				} catch (EmptyShoppingBasketException e) {
					System.err.println(e.getMessage());
				}
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

}
