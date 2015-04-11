package com.Seavus.AliExpress.Dao;

import java.util.Set;

import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Model.ShoppingBasket;

public interface ShoppingBasketDao {

	public void addProduct(ShoppingBasket basket,Product p,int quantity);

	public Set<Product> listAllProducts(ShoppingBasket basket) ;
	
	public void addBasket();
	
	public ShoppingBasket getNewestBasket();
	
	public void updateBasket(ShoppingBasket basket);
	
	public int getSum(ShoppingBasket basket);
	
}
