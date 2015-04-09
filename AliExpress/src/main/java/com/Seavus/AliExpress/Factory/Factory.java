package com.Seavus.AliExpress.Factory;

import com.Seavus.AliExpress.Controller.JDBCProductController;
import com.Seavus.AliExpress.Controller.JDBCShoppingBasketController;
import com.Seavus.AliExpress.IO.UI;
import com.Seavus.AliExpress.Service.FillWarehouseService;
import com.Seavus.AliExpress.Service.Impl.FillWarehouseServiceImpl;
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

	public static JDBCProductController productControllerInstance() {
		return new JDBCProductController();
	}

	public static JDBCShoppingBasketController shoppingControllerInstance() {
		return new JDBCShoppingBasketController();
	}

	public static FillWarehouseService warehouseServiceInstance() {
		return new FillWarehouseServiceImpl();
	}
}
