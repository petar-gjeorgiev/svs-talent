package com.Seavus.Library.Dao.Impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Seavus.Library.Dao.HibernateLoanDao;
import com.Seavus.Library.Model.Loan;

public class HibernateLoanDaoImpl implements HibernateLoanDao {

	private SessionFactory sessionFactory = null;
	
	public void register(Loan object) {
		Transaction tx = null;
		Session session = sessionFactory.openSession();
		try {
			tx = session.beginTransaction();
			session.save(object);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}

	public void setFactory(SessionFactory factory) {
		this.sessionFactory = factory;
	}

	public void closeFactory() {
		if (this.sessionFactory != null) {
			this.sessionFactory.close();
		}
	}

}
