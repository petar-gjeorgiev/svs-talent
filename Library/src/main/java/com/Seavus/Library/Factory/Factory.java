package com.Seavus.Library.Factory;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.Seavus.Library.Model.Book;
import com.Seavus.Library.Model.Loan;
import com.Seavus.Library.Model.Magazine;
import com.Seavus.Library.Model.Member;
import com.Seavus.Library.Model.Membership;

public class Factory {

	private static SessionFactory sessionFactory;
		
	public static void createSessionFactory() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			SessionFactory SessionFactory = configuration
					.addAnnotatedClass(Book.class)
					.addAnnotatedClass(Magazine.class)
					.addAnnotatedClass(Loan.class)
					.addAnnotatedClass(Member.class)
					.addAnnotatedClass(Membership.class)
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
