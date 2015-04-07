package com.Seavus.AliExpress.Service;

import com.Seavus.AliExpress.Exceptions.EmptyShoppingBasketException;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Model.ShoppingBasket;

public interface ShoppingBasketService {

	public void addProduct(ShoppingBasket basket,Product p, int quantity);

	public void ListAllProducts(ShoppingBasket basket) throws EmptyShoppingBasketException;
}
