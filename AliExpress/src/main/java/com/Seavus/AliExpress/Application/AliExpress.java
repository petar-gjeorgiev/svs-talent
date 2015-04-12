package com.Seavus.AliExpress.Application;

import org.hibernate.SessionFactory;

import com.Seavus.AliExpress.Controller.HibernateProductController;
import com.Seavus.AliExpress.Controller.HibernateShoppingBasketController;
import com.Seavus.AliExpress.Controller.ProductController;
import com.Seavus.AliExpress.Controller.ShoppingBasketController;
import com.Seavus.AliExpress.Factory.Factory;
import com.Seavus.AliExpress.Factory.HibernateSessionFactory;
import com.Seavus.AliExpress.IO.AppInfo;
import com.Seavus.AliExpress.IO.Output;
import com.Seavus.AliExpress.IO.UI;
import com.Seavus.AliExpress.Service.FillWarehouseService;
import com.Seavus.AliExpress.Service.HibernateProductService;
import com.Seavus.AliExpress.Service.HibernateShoppingBasketService;
import com.Seavus.AliExpress.Service.HibernateWarehouseService;
import com.Seavus.AliExpress.Service.ProductService;
import com.Seavus.AliExpress.Service.ShoppingBasketService;
import com.Seavus.AliExpress.inMemory.ShoppingBasket;
import com.Seavus.AliExpress.inMemory.Warehouse;

public class AliExpress {
	
	public static Warehouse warehouse = Factory.getWarehouseInstance();
	public static ShoppingBasket shoppingBasket = Factory.getBasketInstance();
	
	
	public static void main(String[] args)  {

		Warehouse.fillWarehouse(warehouse);
		UI input = Factory.Input();
		Output output = Factory.getOutputInstance();

		ProductService productService = Factory.getProductService();
		HibernateProductService hibernateProductService = Factory.getHibernateProductService();
		ShoppingBasketService basketService = Factory.getServiceBasketInstance();
		HibernateShoppingBasketService hibernateBasketService = Factory.getHibernateServiceBasketInstance();
		
		FillWarehouseService warehouseService = Factory.warehouseServiceInstance();
		HibernateWarehouseService hibernateWarehouseService = Factory.getHibernateWarehouseService();
		
		AppInfo.mainMenuInfo();
		ProductController productController;
		ShoppingBasketController shoppingController;
		
		HibernateProductController hibernateProductController;
		HibernateShoppingBasketController hibernateShoppingBasketController;
		
		String line;
		while (!(line = input.getInput().nextLine()).equals("end")) {
			if (line.equals("1")) {
				AppInfo.inMemoryAppMenu(Factory.Input(), warehouse, shoppingBasket);
				AppInfo.mainMenuInfo();
			}
			if (line.equals("2")) {
				productController = Factory.productControllerInstance(productService, warehouseService, output, input);
				shoppingController = Factory.shoppingControllerInstance(basketService, productService, input, output);
				AppInfo.JDBCAppMenu(Factory.Input(), productController,shoppingController,warehouseService);
				AppInfo.mainMenuInfo();
			}
			if (line.equals("3")) {
				hibernateProductController = Factory.hibernateProductController(hibernateProductService, hibernateWarehouseService, output, input);
				hibernateShoppingBasketController = Factory.hibernateBasketController(hibernateBasketService, hibernateProductService, input, output);
				HibernateSessionFactory.createSessionFactory();
				SessionFactory factory = HibernateSessionFactory.getFactory();
				hibernateProductController.setFactory(factory);
				hibernateShoppingBasketController.setBasketFactory(factory);
				hibernateShoppingBasketController.setProductFactory(factory);
				AppInfo.HibernateAppMenu(input,hibernateProductController,hibernateShoppingBasketController);
				HibernateSessionFactory.closeFactory();
			}
		}
		
	}


}
