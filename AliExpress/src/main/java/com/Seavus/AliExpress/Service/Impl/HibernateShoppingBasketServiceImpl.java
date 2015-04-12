package com.Seavus.AliExpress.Service.Impl;

import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Seavus.AliExpress.Dao.HibernateShoppingBasketDao;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Model.ShoppingBasket;
import com.Seavus.AliExpress.Service.HibernateShoppingBasketService;

@Service
@Transactional
public class HibernateShoppingBasketServiceImpl implements
		HibernateShoppingBasketService {

	@Autowired
	public HibernateShoppingBasketDao shoppingDao;
	
	public HibernateShoppingBasketServiceImpl(HibernateShoppingBasketDao shoppingDao) {
		this.shoppingDao = shoppingDao;
	}
	
	public void addProduct(ShoppingBasket basket, Product p, int quantity) {
		shoppingDao.addProduct(basket, p, quantity);
	}

	public Set<Product> listAllProducts(ShoppingBasket basket) {
		return shoppingDao.listAllProducts(basket);
	}

	public long calculateSum(ShoppingBasket basket) {
		return shoppingDao.getSum(basket);
	}

	public void addBasket() {
		shoppingDao.addBasket();
	}

	public ShoppingBasket getNewestBasket() {
		return shoppingDao.getNewestBasket();
	}

	public void updateBasket(ShoppingBasket basket) {
		shoppingDao.updateBasket(basket);
	}

	public int getSum(ShoppingBasket basket) {
		return shoppingDao.getSum(basket);
	}

	public void setFactory(SessionFactory factory) {
		shoppingDao.setFactory(factory);
	}

	public void closeFactory() {
		shoppingDao.closeFactory();
	}

}
