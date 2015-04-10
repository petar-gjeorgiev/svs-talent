package com.Seavus.AliExpress.Templates.Hibernate;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Seavus.AliExpress.Model.Product;

public class HibernateDaoTemplate {

	private Transaction tx;
	private Session session;

	private HibernateSessionSetter saveSetter = new HibernateSessionSetter() {

		public void setSession(Session session, Object object) {
			session.save(object);
		}
	};

	private HibernateSessionSetter updateSetter = new HibernateSessionSetter() {

		public void setSession(Session session, Object object) {
			session.update(object);
		}
	};

	private HibernateSessionProductIdSetter deleteProductSetter = new HibernateSessionProductIdSetter() {

		public void setSession(Session session, String id) {
			session.delete((Product) session.get(Product.class, id));
		}
	};

	private HibernateSessionProductById getProductSetter = new HibernateSessionProductById() {

		public Product setSession(Session session, String id) {
			return (Product) session.get(Product.class, id);
		}

	};

	public void commit() {
		tx.commit();
	}

	public void transaction(SessionFactory factory) {
		session = factory.openSession();
		tx = session.beginTransaction();
	}

	public void registerTransaction(SessionFactory factory, Object o) {
		transaction(factory);
		saveSetter.setSession(session, o);
		commit();
	}

	public void updateTransaction(SessionFactory factory, Object o) {
		transaction(factory);
		updateSetter.setSession(session, o);
		commit();
	}

	public void deleteProductTransaction(SessionFactory factory, String id) {
		transaction(factory);
		deleteProductSetter.setSession(session, id);
		commit();
	}

	public void closeFactory(SessionFactory factory) {
		if (factory != null) {
			factory.close();
		}
	}

	public Product getProductTransaction(SessionFactory factory, String id) {
		Product p;
		transaction(factory);
		p = getProductSetter.setSession(session, id);
		commit();
		return p;
	}
	
	public Criteria listAllProducts(SessionFactory factory) {
		transaction(factory);
		Criteria c = session.createCriteria(Product.class);
		commit();
		return c;
	}

	
}
