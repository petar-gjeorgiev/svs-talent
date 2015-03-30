package com.Seavus.AliExpress;

import com.Seavus.AliExpress.Exceptions.EmptyShoppingBasketException;

public interface ShoppingCart {

	public void addProducts(Product p, int quantity);

	public void ListAllProducts() throws EmptyShoppingBasketException;
	
}
