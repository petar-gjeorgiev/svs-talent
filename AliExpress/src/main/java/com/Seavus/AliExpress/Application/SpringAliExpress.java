package com.Seavus.AliExpress.Application;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.Seavus.AliExpress.Controller.HibernateProductController;
import com.Seavus.AliExpress.Controller.HibernateShoppingBasketController;
import com.Seavus.AliExpress.Dao.HibernateFillWarehouseDao;
import com.Seavus.AliExpress.Dao.HibernateProductDao;
import com.Seavus.AliExpress.Dao.HibernateShoppingBasketDao;
import com.Seavus.AliExpress.Factory.Factory;
import com.Seavus.AliExpress.Factory.HibernateSessionFactory;
import com.Seavus.AliExpress.IO.AppInfo;
import com.Seavus.AliExpress.IO.Output;
import com.Seavus.AliExpress.IO.UI;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Service.HibernateProductService;
import com.Seavus.AliExpress.Service.HibernateShoppingBasketService;
import com.Seavus.AliExpress.Service.HibernateWarehouseService;
import com.Seavus.AliExpress.Templates.Hibernate.HibernateDaoTemplate;

public class SpringAliExpress implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringAliExpress.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception {
	
//		Scanner scan = Factory.getScannerIstance();
//		UI inp = Factory.Input(scan);
//		AppInfo info = Factory.getAppInfoIstance(inp);
//
//		File f = Factory.getFileIstance();
//		Scanner scannerFile = Factory.getScannerWithFile(f);
//		Scanner scanner = Factory.getScannerIstance();
//
//		UI input = Factory.Input(scanner);
//
//		UI inputFile = Factory.Input(scannerFile);
//
//		Product product = Factory.getProductIstance();
//		HashMap<String, Integer> map = Factory.getMapIstance();
//
//		Output output = Factory.getOutputInstance(product, map, info);
//
//		Product p1 = Factory.getProductIstance();
//
//		Set<Product> products = Factory.getProducts();
//
//		HibernateDaoTemplate hibernateDaoTemplate = Factory.getTemplate(p1,
//				products);
//
//		HibernateProductDao hibernateProductDao = Factory
//				.getHibernateProductDao(hibernateDaoTemplate);
//		HibernateShoppingBasketDao hibernateShoppingBasketDao = Factory
//				.getHibernateBasketDao(hibernateDaoTemplate);
//		HibernateFillWarehouseDao hibernateWarehouseDao = Factory
//				.getHibernateWarehouseDao(hibernateDaoTemplate,
//						hibernateProductDao, product, inputFile);
//
//	
//		HibernateProductService hibernateProductService = Factory
//				.getHibernateProductService(hibernateProductDao);
//	
//		HibernateShoppingBasketService hibernateBasketService = Factory
//				.getHibernateServiceBasketInstance(hibernateShoppingBasketDao);
//
//		HibernateWarehouseService hibernateWarehouseService = Factory
//				.getHibernateWarehouseService(hibernateWarehouseDao);
//
//		HibernateProductController hibernateProductController;
//		HibernateShoppingBasketController hibernateShoppingBasketController;
//		
//		hibernateProductController = Factory
//				.hibernateProductController(hibernateProductService,
//						hibernateWarehouseService, output, input, info);
//		hibernateShoppingBasketController = Factory
//				.hibernateBasketController(hibernateBasketService,
//						hibernateProductService, input, output);
//		HibernateSessionFactory.createSessionFactory();
//		SessionFactory factory = HibernateSessionFactory.getFactory();
//		hibernateProductController.setFactory(factory);
//		hibernateShoppingBasketController.setBasketFactory(factory);
//		hibernateShoppingBasketController.setProductFactory(factory);
//		info.HibernateAppMenu(input, hibernateProductController,
//				hibernateShoppingBasketController);
//		HibernateSessionFactory.closeFactory();
		
	}
	
}
