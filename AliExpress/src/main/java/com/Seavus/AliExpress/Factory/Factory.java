package com.Seavus.AliExpress.Factory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.Seavus.AliExpress.Controller.HibernateProductController;
import com.Seavus.AliExpress.Controller.HibernateShoppingBasketController;
import com.Seavus.AliExpress.Controller.ProductController;
import com.Seavus.AliExpress.Controller.ShoppingBasketController;
import com.Seavus.AliExpress.Dao.HibernateFillWarehouseDao;
import com.Seavus.AliExpress.Dao.HibernateProductDao;
import com.Seavus.AliExpress.Dao.HibernateShoppingBasketDao;
import com.Seavus.AliExpress.Dao.Impl.HibernateBasketDaoImpl;
import com.Seavus.AliExpress.Dao.Impl.HibernateFillWarehouseImpl;
import com.Seavus.AliExpress.Dao.Impl.HibernateProductDaoImpl;
import com.Seavus.AliExpress.IO.AppInfo;
import com.Seavus.AliExpress.IO.Output;
import com.Seavus.AliExpress.IO.UI;
import com.Seavus.AliExpress.Model.Product;
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
import com.Seavus.AliExpress.Templates.Hibernate.HibernateDaoTemplate;
import com.Seavus.AliExpress.inMemory.ShoppingBasket;
import com.Seavus.AliExpress.inMemory.Warehouse;

public class Factory {

	public static Warehouse getWarehouseInstance() {
		return new Warehouse();
	}

	public static ShoppingBasket getBasketInstance() {
		return new ShoppingBasket();
	}

	public static UI Input(Scanner scanner) {
		return new UI(scanner);
	}

	public static Output getOutputInstance(Product p,
			HashMap<String, Integer> map, AppInfo info) {
		return new Output(p, map, info);
	}

	public static FillWarehouseService warehouseServiceInstance() {
		return new FillWarehouseServiceImpl();
	}

	public static HibernateWarehouseService getHibernateWarehouseService(
			HibernateFillWarehouseDao dao) {
		return new HibernateFillWarehouseServiceImpl(dao);
	}

	public static ProductService getProductService() {
		return new ProductServiceImpl();
	}

	public static HibernateProductService getHibernateProductService(
			HibernateProductDao productDao) {
		return new HibernateProductServiceImpl(productDao);
	}

	public static ShoppingBasketService getServiceBasketInstance() {
		return new ShoppingBasketServiceImpl();
	}

	public static HibernateShoppingBasketService getHibernateServiceBasketInstance(
			HibernateShoppingBasketDao shoppingDao) {
		return new HibernateShoppingBasketServiceImpl(shoppingDao);
	}

	public static ProductController productControllerInstance(
			ProductService service, FillWarehouseService warehouseService,
			Output output, UI input,AppInfo info) {
		return new ProductController(service, warehouseService, output, input,info);
	}

	public static ShoppingBasketController shoppingControllerInstance(
			ShoppingBasketService service, ProductService productService,
			UI input, Output output) {
		return new ShoppingBasketController(service, productService, input,
				output);
	}

	public static HibernateProductController hibernateProductController(
			HibernateProductService service,
			HibernateWarehouseService warehouseService, Output output,
			UI input, AppInfo info) {
		return new HibernateProductController(service, warehouseService,
				output, input, info);
	}

	public static HibernateShoppingBasketController hibernateBasketController(
			HibernateShoppingBasketService service,
			HibernateProductService productService, UI input, Output output) {
		return new HibernateShoppingBasketController(service, productService,
				input, output);
	}

	public static HibernateProductDao getHibernateProductDao(
			HibernateDaoTemplate template) {
		return new HibernateProductDaoImpl(template);
	}

	public static HibernateShoppingBasketDao getHibernateBasketDao(
			HibernateDaoTemplate template) {
		return new HibernateBasketDaoImpl(template);
	}

	public static HibernateFillWarehouseDao getHibernateWarehouseDao(
			HibernateDaoTemplate template, HibernateProductDao productDao,
			Product p, UI input) {
		return new HibernateFillWarehouseImpl(productDao, template, p, input);
	}

	public static HibernateDaoTemplate getTemplate(Product p,Set<Product> products) {
		return new HibernateDaoTemplate(p,products);
	}

	public static Product getProductIstance() {
		return new Product();
	}

	public static HashMap<String, Integer> getMapIstance() {
		return new HashMap<String, Integer>();
	}

	public static Scanner getScannerIstance() {
		return new Scanner(System.in);
	}

	public static File getFileIstance() {
		return new File(
				"D:/Education/Seavus/git/svs-talent/AliExpress/src/main/java/com/Seavus/AliExpress/inMemory/Products.txt");
	}

	public static Scanner getScannerWithFile(File f) {
		try {
			return new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static AppInfo getAppInfoIstance(UI input) {
		return new AppInfo(input);
	}

	public static Set<Product> getProducts() {
		return new HashSet<Product>();
	}
	
}
