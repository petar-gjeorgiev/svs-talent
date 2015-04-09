package com.Seavus.AliExpress.Dao.Impl;

import java.util.List;

import com.Seavus.AliExpress.Dao.ProductDao;
import com.Seavus.AliExpress.Dao.ShoppingBasketDao;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Model.ShoppingBasket;
import com.Seavus.AliExpress.Templates.JDBC.BasketProductList;
import com.Seavus.AliExpress.Templates.JDBC.BasketRegisterProduct;
import com.Seavus.AliExpress.Templates.JDBC.BasketRegistration;
import com.Seavus.AliExpress.Templates.JDBC.JDBCDaoTemplate;
import com.Seavus.AliExpress.Templates.JDBC.NewestBasketSetter;

public class ShoppingBasketDaoImpl implements ShoppingBasketDao {

	public JDBCDaoTemplate template = new JDBCDaoTemplate();

	public ProductDao productDao = new ProductDaoImpl();

	public List<Product> listAllProducts(ShoppingBasket basket) {
		return template.executeList(new BasketProductList(basket.getId(),
				productDao));
	}
	public void addProduct(ShoppingBasket basket, Product p) {
		template.execute(new BasketRegisterProduct(p.getId(), basket.getId()));
	}

	public void addBasket() {
		template.execute(new BasketRegistration());
	}
	
	public ShoppingBasket getNewestBasket() {
		return template.executeNewestBasket(new NewestBasketSetter());
	}

}
