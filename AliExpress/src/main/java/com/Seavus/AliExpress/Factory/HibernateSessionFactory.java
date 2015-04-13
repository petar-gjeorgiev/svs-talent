package com.Seavus.AliExpress.Factory;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.Seavus.AliExpress.Model.Account;
import com.Seavus.AliExpress.Model.Bill;
import com.Seavus.AliExpress.Model.CreditCart;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Model.ShoppingBasket;

public class HibernateSessionFactory {

	private static SessionFactory sessionFactory;

	public static void createSessionFactory() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			SessionFactory SessionFactory = configuration
					.addAnnotatedClass(Product.class)
					.addAnnotatedClass(Bill.class)
					.addAnnotatedClass(ShoppingBasket.class)
					.addAnnotatedClass(CreditCart.class)
					.addAnnotatedClass(Account.class)
					.buildSessionFactory(serviceRegistry);
			sessionFactory = SessionFactory;
		}
	}

	public static SessionFactory getFactory() {
		return sessionFactory;
	}

	public static void closeFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}

}
