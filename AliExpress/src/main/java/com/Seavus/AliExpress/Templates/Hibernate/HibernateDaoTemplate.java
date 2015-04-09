package com.Seavus.AliExpress.Templates.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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

	public void closeFactory(SessionFactory factory) {
		if (factory != null) {
			factory.close();
		}
	}

}
