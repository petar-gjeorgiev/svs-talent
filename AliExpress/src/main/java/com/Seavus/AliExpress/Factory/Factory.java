package com.Seavus.AliExpress.Factory;

import com.Seavus.AliExpress.Controller.HibernateProductController;
import com.Seavus.AliExpress.Controller.HibernateShoppingBasketController;
import com.Seavus.AliExpress.Controller.ProductController;
import com.Seavus.AliExpress.Controller.ShoppingBasketController;
import com.Seavus.AliExpress.IO.Output;
import com.Seavus.AliExpress.IO.UI;
import com.Seavus.AliExpress.Service.FillWarehouseService;
import com.Seavus.AliExpress.Service.HibernateProductService;
import com.Seavus.AliExpress.Service.HibernateShoppingBasketService;
import com.Seavus.AliExpress.Service.HibernateWarehouseService;
import com.Seavus.AliExpress.Service.ProductService;
import com.Seavus.AliExpress.Service.ShoppingBasketService;
import com.Seavus.AliExpress.Service.Impl.FillWarehouseServiceImpl;
import com.Seavus.AliExpress.Service.Impl.HibernateFillWarehouseServiceImpl;
import com.Seavus.AliExpress.Service.Impl.HibernateProductServiceImpl;
import com.Seavus.AliExpress.Service.Impl.HibernateShoppingBasketServiceImpl;
import com.Seavus.AliExpress.Service.Impl.ProductServiceImpl;
import com.Seavus.AliExpress.Service.Impl.ShoppingBasketServiceImpl;
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

	public static Output getOutputInstance() {
		return new Output();
	}

	public static FillWarehouseService warehouseServiceInstance() {
		return new FillWarehouseServiceImpl();
	}

	public static HibernateWarehouseService getHibernateWarehouseService() {
		return new HibernateFillWarehouseServiceImpl();
	}

	public static ProductService getProductService() {
		return new ProductServiceImpl();
	}

	public static HibernateProductService getHibernateProductService() {
		return new HibernateProductServiceImpl();
	}

	public static ShoppingBasketService getServiceBasketInstance() {
		return new ShoppingBasketServiceImpl();
	}

	public static HibernateShoppingBasketService getHibernateServiceBasketInstance() {
		return new HibernateShoppingBasketServiceImpl();
	}

	public static ProductController productControllerInstance(
			ProductService service, FillWarehouseService warehouseService,
			Output output, UI input) {
		return new ProductController(service, warehouseService, output, input);
	}

	public static ShoppingBasketController shoppingControllerInstance(
			ShoppingBasketService service, ProductService productService,
			UI input, Output output) {
		return new ShoppingBasketController(service, productService, input,
				output);
	}
	
	public static HibernateProductController hibernateProductController(
			HibernateProductService service,
			HibernateWarehouseService warehouseService, Output output, UI input) {
		return new HibernateProductController(service, warehouseService,
				output, input);
	}

	public static HibernateShoppingBasketController hibernateBasketController(
			HibernateShoppingBasketService service,
			HibernateProductService productService, UI input, Output output) {
		return new HibernateShoppingBasketController(service, productService,
				input, output);
	}

}
