package com.Seavus.AliExpress.Application;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.Seavus.AliExpress.Controller.HibernateAccountController;
import com.Seavus.AliExpress.Controller.HibernateCartController;
import com.Seavus.AliExpress.Controller.HibernateProductController;
import com.Seavus.AliExpress.Controller.HibernateShoppingBasketController;
import com.Seavus.AliExpress.Controller.ProductController;
import com.Seavus.AliExpress.Controller.ShoppingBasketController;
import com.Seavus.AliExpress.Dao.HibernateAccountDao;
import com.Seavus.AliExpress.Dao.HibernateCreditCartDao;
import com.Seavus.AliExpress.Dao.HibernateFillWarehouseDao;
import com.Seavus.AliExpress.Dao.HibernateProductDao;
import com.Seavus.AliExpress.Dao.HibernateShoppingBasketDao;
import com.Seavus.AliExpress.Factory.Factory;
import com.Seavus.AliExpress.Factory.HibernateSessionFactory;
import com.Seavus.AliExpress.IO.AppInfo;
import com.Seavus.AliExpress.IO.Output;
import com.Seavus.AliExpress.IO.UI;
import com.Seavus.AliExpress.Model.Account;
import com.Seavus.AliExpress.Model.CreditCart;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Service.FillWarehouseService;
import com.Seavus.AliExpress.Service.HibernateAccountService;
import com.Seavus.AliExpress.Service.HibernateCreditCartService;
import com.Seavus.AliExpress.Service.HibernateProductService;
import com.Seavus.AliExpress.Service.HibernateShoppingBasketService;
import com.Seavus.AliExpress.Service.HibernateWarehouseService;
import com.Seavus.AliExpress.Service.ProductService;
import com.Seavus.AliExpress.Service.ShoppingBasketService;
import com.Seavus.AliExpress.Templates.Hibernate.HibernateDaoTemplate;
import com.Seavus.AliExpress.inMemory.ShoppingBasket;
import com.Seavus.AliExpress.inMemory.Warehouse;

@EnableAutoConfiguration
public class AliExpress {

	public static void main(String[] args) {
		
		Warehouse warehouse = Factory.getWarehouseInstance();
		ShoppingBasket shoppingBasket = Factory.getBasketInstance();

		Warehouse.fillWarehouse(warehouse);

		Scanner scan = Factory.getScannerIstance();
		UI inp = Factory.Input(scan);
		AppInfo info = Factory.getAppInfoIstance(inp);

		File f = Factory.getFileIstance();
		Scanner scannerFile = Factory.getScannerWithFile(f);
		Scanner scanner = Factory.getScannerIstance();

		UI input = Factory.Input(scanner);

		UI inputFile = Factory.Input(scannerFile);

		Product product = Factory.getProductIstance();
		HashMap<String, Integer> map = Factory.getMapIstance();

		CreditCart cart = Factory.getCartInstance();
		Account account = Factory.getAccountInstance();
		
		Output output = Factory.getOutputInstance(product, map, info,cart,account);

		Product p1 = Factory.getProductIstance();

		Set<Product> products = Factory.getProducts();

		HibernateDaoTemplate hibernateDaoTemplate = Factory.getTemplate(p1,
				products);

		HibernateProductDao hibernateProductDao = Factory
				.getHibernateProductDao(hibernateDaoTemplate);
		HibernateShoppingBasketDao hibernateShoppingBasketDao = Factory
				.getHibernateBasketDao(hibernateDaoTemplate);
		HibernateFillWarehouseDao hibernateWarehouseDao = Factory
				.getHibernateWarehouseDao(hibernateDaoTemplate,
						hibernateProductDao, product, inputFile);
		
		
		HibernateAccountDao hibernateAccountDao = Factory.getAccountDaoInstance(hibernateDaoTemplate);
		HibernateCreditCartDao hibernateCartDao = Factory.getCartDaoInstance(hibernateDaoTemplate);
		
		

		ProductService productService = Factory.getProductService();
		HibernateProductService hibernateProductService = Factory
				.getHibernateProductService(hibernateProductDao);
		ShoppingBasketService basketService = Factory
				.getServiceBasketInstance();
		HibernateShoppingBasketService hibernateBasketService = Factory
				.getHibernateServiceBasketInstance(hibernateShoppingBasketDao);

		FillWarehouseService warehouseService = Factory
				.warehouseServiceInstance();
		HibernateWarehouseService hibernateWarehouseService = Factory
				.getHibernateWarehouseService(hibernateWarehouseDao);

		
		
		HibernateAccountService hibernateAccountService = Factory.getAccountServiceIstance(hibernateAccountDao);
		HibernateCreditCartService hibernateCartService = Factory.getCartServiceIstance(hibernateCartDao);
		
		info.mainMenuInfo();
		ProductController productController;
		ShoppingBasketController shoppingController;

		HibernateProductController hibernateProductController;
		HibernateShoppingBasketController hibernateShoppingBasketController;

		HibernateAccountController hibernateAccountController;
		HibernateCartController hibernateCartController;
		
		String line;
		while (!(line = input.getInput().nextLine()).equals("end")) {
			Scanner scanner1 = Factory.getScannerIstance();
			UI input1 = Factory.Input(scanner1);
			if (line.equals("1")) {
				info.inMemoryAppMenu(input1, warehouse, shoppingBasket);
				info.mainMenuInfo();
			}
			if (line.equals("2")) {
				productController = Factory.productControllerInstance(
						productService, warehouseService, output, input, info);
				shoppingController = Factory.shoppingControllerInstance(
						basketService, productService, input, output);
				info.JDBCAppMenu(input1, productController, shoppingController,
						warehouseService);
				info.mainMenuInfo();
			}
			if (line.equals("3")) {
				hibernateAccountController = Factory.getAccountController(hibernateAccountService, output, input, info, hibernateCartService);
				hibernateCartController = Factory.getCartController(hibernateCartService, output, input, info);
				
				hibernateProductController = Factory
						.hibernateProductController(hibernateProductService,
								hibernateWarehouseService, output, input, info);
				hibernateShoppingBasketController = Factory
						.hibernateBasketController(hibernateBasketService,
								hibernateProductService, input, output);
				HibernateSessionFactory.createSessionFactory();
				SessionFactory factory = HibernateSessionFactory.getFactory();
				hibernateProductController.setFactory(factory);
				hibernateShoppingBasketController.setBasketFactory(factory);
				hibernateShoppingBasketController.setProductFactory(factory);
				
				hibernateAccountController.setFactory(factory);
				hibernateCartController.setFactory(factory);
				
//				info.HibernateAppMenu(input, hibernateProductController,
//						hibernateShoppingBasketController);
				info.springHibernateMenu(input, hibernateProductController, hibernateShoppingBasketController, hibernateCartController, hibernateAccountController);
				HibernateSessionFactory.closeFactory();
			}
		}

	}

}
