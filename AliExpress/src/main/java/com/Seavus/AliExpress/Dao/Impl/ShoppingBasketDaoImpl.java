package com.Seavus.AliExpress.Dao.Impl;

import java.util.Set;

import com.Seavus.AliExpress.Dao.ProductDao;
import com.Seavus.AliExpress.Dao.ShoppingBasketDao;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Model.ShoppingBasket;
import com.Seavus.AliExpress.Templates.JDBC.BasketProductList;
import com.Seavus.AliExpress.Templates.JDBC.BasketRegisterProduct;
import com.Seavus.AliExpress.Templates.JDBC.BasketRegistration;
import com.Seavus.AliExpress.Templates.JDBC.JDBCDaoTemplate;
import com.Seavus.AliExpress.Templates.JDBC.NewestBasketSetter;
import com.Seavus.AliExpress.Templates.JDBC.ShoppingBasketUpdateSetter;
import com.Seavus.AliExpress.Templates.JDBC.TotalBasketSetterImpl;

public class ShoppingBasketDaoImpl implements ShoppingBasketDao {

	public JDBCDaoTemplate template = new JDBCDaoTemplate();

	public ProductDao productDao = new ProductDaoImpl();

	public Set<Product> listAllProducts(ShoppingBasket basket) {
		return template.executeList(new BasketProductList(basket.getId(),
				new ProductDaoImpl()));
	}
	public void addProduct(ShoppingBasket basket, Product p,int quantity) {
		template.execute(new BasketRegisterProduct(p.getId(), basket.getId(),quantity));
	}

	public void addBasket() {
		template.execute(new BasketRegistration());
	}
	
	public ShoppingBasket getNewestBasket() {
		return template.executeNewestBasket(new NewestBasketSetter());
	}
	public void updateBasket(ShoppingBasket basket) {
		template.execute(new ShoppingBasketUpdateSetter(basket));
	}
	public int getSum(ShoppingBasket basket) {
		return template.getTotalSum(new TotalBasketSetterImpl(basket.getId()));
	}


}
