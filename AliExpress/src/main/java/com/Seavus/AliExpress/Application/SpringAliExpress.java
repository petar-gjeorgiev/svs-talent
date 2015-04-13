package com.Seavus.AliExpress.Application;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.Seavus.AliExpress.Controller.HibernateAccountController;
import com.Seavus.AliExpress.Controller.HibernateCartController;
import com.Seavus.AliExpress.Controller.HibernateProductController;
import com.Seavus.AliExpress.Controller.HibernateShoppingBasketController;

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
import com.Seavus.AliExpress.Service.HibernateAccountService;
import com.Seavus.AliExpress.Service.HibernateCreditCartService;
import com.Seavus.AliExpress.Service.HibernateProductService;
import com.Seavus.AliExpress.Service.HibernateShoppingBasketService;
import com.Seavus.AliExpress.Service.HibernateWarehouseService;
import com.Seavus.AliExpress.Templates.Hibernate.HibernateDaoTemplate;

@EnableAutoConfiguration
@Configuration
@ComponentScan
public class SpringAliExpress implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringAliExpress.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

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

		Output output = Factory.getOutputInstance(product, map, info, cart,
				account);

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

		HibernateAccountDao hibernateAccountDao = Factory
				.getAccountDaoInstance(hibernateDaoTemplate);
		HibernateCreditCartDao hibernateCartDao = Factory
				.getCartDaoInstance(hibernateDaoTemplate);

		HibernateProductService hibernateProductService = Factory
				.getHibernateProductService(hibernateProductDao);
		HibernateShoppingBasketService hibernateBasketService = Factory
				.getHibernateServiceBasketInstance(hibernateShoppingBasketDao);

		HibernateWarehouseService hibernateWarehouseService = Factory
				.getHibernateWarehouseService(hibernateWarehouseDao);

		HibernateAccountService hibernateAccountService = Factory
				.getAccountServiceIstance(hibernateAccountDao);
		HibernateCreditCartService hibernateCartService = Factory
				.getCartServiceIstance(hibernateCartDao);

		HibernateAccountController hibernateAccountController = Factory
				.getAccountController(hibernateAccountService, output, input,
						info, hibernateCartService);
		;
		HibernateCartController hibernateCartController = Factory
				.getCartController(hibernateCartService, output, input, info);
		;

		HibernateProductController hibernateProductController = Factory
				.hibernateProductController(hibernateProductService,
						hibernateWarehouseService, output, input, info);
		HibernateShoppingBasketController hibernateShoppingBasketController = Factory
				.hibernateBasketController(hibernateBasketService,
						hibernateProductService, input, output);
		HibernateSessionFactory.createSessionFactory();
		SessionFactory factory = HibernateSessionFactory.getFactory();
		hibernateProductController.setFactory(factory);
		hibernateShoppingBasketController.setBasketFactory(factory);
		hibernateShoppingBasketController.setProductFactory(factory);

		hibernateAccountController.setFactory(factory);
		hibernateCartController.setFactory(factory);

		info.springHibernateMenu(input, hibernateProductController,
				hibernateShoppingBasketController, hibernateCartController,
				hibernateAccountController);
		HibernateSessionFactory.closeFactory();

	}

}
