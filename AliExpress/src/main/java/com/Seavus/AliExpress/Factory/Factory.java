package com.Seavus.AliExpress.Factory;

import com.Seavus.AliExpress.IO.UI;
import com.Seavus.AliExpress.inMemory.ShoppingBasket;
import com.Seavus.AliExpress.inMemory.Warehouse;

public class Factory {

	public static Warehouse getWarehouseInstance() {
		return new Warehouse();
	}

	public static ShoppingBasket getBasketInstance() {
		return new ShoppingBasket();
	}

	public static UI Input() {
		return new UI();
	}

}
