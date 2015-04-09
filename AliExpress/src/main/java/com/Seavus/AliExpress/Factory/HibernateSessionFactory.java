package com.Seavus.AliExpress.Factory;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class HibernateSessionFactory {

	private static SessionFactory sessionFactory;
	
//	public static void createSessionFactory() {
//		if (sessionFactory == null) {
//			Configuration configuration = new Configuration();
//			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//					.applySettings(configuration.getProperties()).build();
//
//			SessionFactory SessionFactory = configuration
//					.addAnnotatedClass(Book.class)
//					.addAnnotatedClass(Magazine.class)
//					.addAnnotatedClass(Loan.class)
//					.addAnnotatedClass(Member.class)
//					.addAnnotatedClass(Membership.class)
//					.buildSessionFactory(serviceRegistry);
//			sessionFactory = SessionFactory;
//		}
//	}

	public static SessionFactory getFactory() {
		return sessionFactory;
	}

	public static void closeFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
	
	
}
