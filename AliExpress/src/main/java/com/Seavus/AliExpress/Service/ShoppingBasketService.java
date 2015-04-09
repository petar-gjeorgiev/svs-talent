package com.Seavus.AliExpress.Service;

import java.util.List;

import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Model.ShoppingBasket;

public interface ShoppingBasketService {

	public void addProduct(ShoppingBasket basket, Product p);

	public List<Product> listAllProducts(ShoppingBasket basket);
	
	public long calculateSum(ShoppingBasket basket);
	
	public void addBasket();
	
	public ShoppingBasket getNewestBasket();
}
