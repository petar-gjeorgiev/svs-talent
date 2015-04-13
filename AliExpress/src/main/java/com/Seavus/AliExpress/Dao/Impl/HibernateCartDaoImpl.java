package com.Seavus.AliExpress.Dao.Impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.Seavus.AliExpress.Dao.HibernateCreditCartDao;
import com.Seavus.AliExpress.Model.CreditCart;
import com.Seavus.AliExpress.Templates.Hibernate.HibernateDaoTemplate;

public class HibernateCartDaoImpl implements HibernateCreditCartDao {

	private HibernateDaoTemplate template;

	private SessionFactory factory;

	public HibernateCartDaoImpl(HibernateDaoTemplate template) {
		this.template = template;
	}

	@Override
	public void create(CreditCart cart) {
		template.registerTransaction(factory, cart);
	}

	@Override
	public void delete(int id) {
		template.deleteCart(factory, id);
	}

	@Override
	public void update(CreditCart cart) {
		template.updateTransaction(factory, cart);
	}

	@Override
	public List<CreditCart> list() {
		return template.listCarts(factory);
	}

	@Override
	public CreditCart getCartById(int id) {
		return template.getCartById(factory, id);
	}

	@Override
	public void setFactory(SessionFactory factory) {
		if (this.factory == null) {
			this.factory = factory;
		}
	}

	@Override
	public void closeFactory() {
		this.factory.close();
	}

}
