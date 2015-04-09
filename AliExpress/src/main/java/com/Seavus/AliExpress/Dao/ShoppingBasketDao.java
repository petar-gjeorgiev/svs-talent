package com.Seavus.AliExpress.Dao;

import java.util.List;

import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Model.ShoppingBasket;

public interface ShoppingBasketDao {

	public void addProduct(ShoppingBasket basket,Product p);

	public List<Product> listAllProducts(ShoppingBasket basket) ;
	
	public void addBasket();
	
	public ShoppingBasket getNewestBasket();
}
