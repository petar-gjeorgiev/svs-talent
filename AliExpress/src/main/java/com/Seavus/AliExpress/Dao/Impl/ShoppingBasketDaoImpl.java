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

public class ShoppingBasketDaoImpl implements ShoppingBasketDao {

	public JDBCDaoTemplate template = new JDBCDaoTemplate();

	public ProductDao productDao = new ProductDaoImpl();

	@Override
	public List<Product> listAllProducts(ShoppingBasket basket) {
		return template.executeList(new BasketProductList(basket.getId(),
				productDao));
	}

	@Override
	public void addProduct(ShoppingBasket basket, Product p) {
		template.execute(new BasketRegisterProduct(p.getId(), basket.getId()));
	}

	@Override
	public void addBasket() {
		template.execute(new BasketRegistration());
	}

	@Override
	public ShoppingBasket getNewestBasket() {
		// TODO Auto-generated method stub
		return null;
	}

}
