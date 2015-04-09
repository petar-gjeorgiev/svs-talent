package com.Seavus.AliExpress.Application;

import com.Seavus.AliExpress.Factory.Factory;
import com.Seavus.AliExpress.IO.AppInfo;
import com.Seavus.AliExpress.inMemory.ShoppingBasket;
import com.Seavus.AliExpress.inMemory.Warehouse;

public class AliExpress {
	
	public static Warehouse warehouse = Factory.getWarehouseInstance();
	public static ShoppingBasket shoppingBasket = Factory.getBasketInstance();

	public static void main(String[] args)  {

		Warehouse.fillWarehouse(warehouse);

		AppInfo.mainMenuInfo();
		AppInfo.mainMenu(Factory.Input(), warehouse, shoppingBasket);
		
	}




}
