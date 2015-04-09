package com.Seavus.AliExpress.Service.Impl;

import java.util.List;

import com.Seavus.AliExpress.Dao.ShoppingBasketDao;
import com.Seavus.AliExpress.Dao.Impl.ShoppingBasketDaoImpl;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Model.ShoppingBasket;
import com.Seavus.AliExpress.Service.ShoppingBasketService;

public class ShoppingBasketServiceImpl implements ShoppingBasketService {

	public ShoppingBasketDao shoppingDao = new ShoppingBasketDaoImpl();

	public void addProduct(ShoppingBasket basket, Product p) {
		shoppingDao.addProduct(basket, p);
	}

	public List<Product> listAllProducts(ShoppingBasket basket) {
		return shoppingDao.listAllProducts(basket);
	}

	public long calculateSum(ShoppingBasket basket) {
		long sum = 0;
		for (Product p : listAllProducts(basket)) {
			sum += p.getPrice();
		}
		return sum;
	}

	public void addBasket() {
		shoppingDao.addBasket();
	}

	public ShoppingBasket getNewestBasket() {
		return shoppingDao.getNewestBasket();
	}
}
