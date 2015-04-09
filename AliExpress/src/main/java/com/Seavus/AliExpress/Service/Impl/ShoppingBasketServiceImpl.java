package com.Seavus.AliExpress.Service.Impl;

import java.util.List;

import com.Seavus.AliExpress.Dao.ShoppingBasketDao;
import com.Seavus.AliExpress.Dao.Impl.ShoppingBasketDaoImpl;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Model.ShoppingBasket;
import com.Seavus.AliExpress.Service.ShoppingBasketService;

public class ShoppingBasketServiceImpl implements ShoppingBasketService {

	public ShoppingBasketDao shoppingDao = new ShoppingBasketDaoImpl();

	@Override
	public void addProduct(ShoppingBasket basket, Product p) {
		shoppingDao.addProduct(basket, p);
	}

	@Override
	public List<Product> listAllProducts(ShoppingBasket basket) {
		return shoppingDao.listAllProducts(basket);
	}

	@Override
	public long calculateSum(ShoppingBasket basket) {
		long sum = 0;
		for (Product p : listAllProducts(basket)) {
			sum += p.getPrice();
		}
		return sum;
	}

	@Override
	public void addBasket() {
		shoppingDao.addBasket();
	}

	@Override
	public ShoppingBasket getNewestBasket() {
		return shoppingDao.getNewestBasket();
	}
}
