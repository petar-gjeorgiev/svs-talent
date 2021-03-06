package com.Seavus.AliExpress.Service;

import java.util.Set;

import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Model.ShoppingBasket;

public interface ShoppingBasketService {

	public void addProduct(ShoppingBasket basket, Product p,int quantity);

	public Set<Product> listAllProducts(ShoppingBasket basket);
	
	public long calculateSum(ShoppingBasket basket);
	
	public void addBasket();
	
	public ShoppingBasket getNewestBasket();
	
	public void updateBasket(ShoppingBasket basket);

	public int getSum(ShoppingBasket basket);
}
