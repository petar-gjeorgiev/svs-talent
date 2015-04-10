package com.Seavus.AliExpress.Application;

import com.Seavus.AliExpress.Controller.JDBCProductController;
import com.Seavus.AliExpress.Controller.JDBCShoppingBasketController;
import com.Seavus.AliExpress.Factory.Factory;
import com.Seavus.AliExpress.IO.AppInfo;
import com.Seavus.AliExpress.IO.UI;
import com.Seavus.AliExpress.Service.FillWarehouseService;
import com.Seavus.AliExpress.inMemory.ShoppingBasket;
import com.Seavus.AliExpress.inMemory.Warehouse;

public class AliExpress {
	
	public static Warehouse warehouse = Factory.getWarehouseInstance();
	public static ShoppingBasket shoppingBasket = Factory.getBasketInstance();
	
	
	public static void main(String[] args)  {

		Warehouse.fillWarehouse(warehouse);
		UI input = Factory.Input();
		
		AppInfo.mainMenuInfo();
		JDBCProductController productController = Factory.productControllerInstance();
		JDBCShoppingBasketController shoppingController = Factory.shoppingControllerInstance();
		FillWarehouseService warehouseService = Factory.warehouseServiceInstance();
		
		String line;
		while (!(line = input.getInput().nextLine()).equals("end")) {
			if (line.equals("1")) {
				AppInfo.inMemoryAppMenu(Factory.Input(), warehouse, shoppingBasket);
				AppInfo.mainMenuInfo();
			}
			if (line.equals("2")) {
				AppInfo.JDBCAppMenu(Factory.Input(), productController,shoppingController,warehouseService);
				AppInfo.mainMenuInfo();
			}
			if (line.equals("3")) {
				AppInfo.HibernateAppMenu();
			}
		}
		
	}


}
