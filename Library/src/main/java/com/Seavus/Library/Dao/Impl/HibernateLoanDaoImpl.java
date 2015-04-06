package com.Seavus.Library.Dao.Impl;

import org.hibernate.SessionFactory;

import com.Seavus.Library.Dao.HibernateLoanDao;
import com.Seavus.Library.Model.Loan;
import com.Seavus.Library.Templates.Hibernate.HibernateDaoTemplate;

public class HibernateLoanDaoImpl implements HibernateLoanDao {

	private SessionFactory sessionFactory = null;
	private HibernateDaoTemplate template = new HibernateDaoTemplate();

	public void register(Loan object) {
		template.registerTransaction(sessionFactory, object);
	}

	public void setFactory(SessionFactory factory) {
		this.sessionFactory = factory;
	}

	public void closeFactory() {
		template.closeFactory(this.sessionFactory);
	}

}
