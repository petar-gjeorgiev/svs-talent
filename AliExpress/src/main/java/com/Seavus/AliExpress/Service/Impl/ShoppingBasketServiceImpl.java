package com.Seavus.AliExpress.Service.Impl;

import com.Seavus.AliExpress.Dao.ShoppingBasketDao;
import com.Seavus.AliExpress.Exceptions.EmptyShoppingBasketException;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Model.ShoppingBasket;
import com.Seavus.AliExpress.Service.ShoppingBasketService;
import com.Seavus.Dao.Impl.ShoppingBasketDaoImpl;

public class ShoppingBasketServiceImpl implements ShoppingBasketService {

	public ShoppingBasketDao shoppingDao = new ShoppingBasketDaoImpl();
	
	@Override
	public void addProduct(ShoppingBasket basket, Product p, int quantity) {
		shoppingDao.addProduct(basket, p, quantity);
	}

	@Override
	public void ListAllProducts(ShoppingBasket basket)
			throws EmptyShoppingBasketException {
		shoppingDao.ListAllProducts(basket);
	}

}
