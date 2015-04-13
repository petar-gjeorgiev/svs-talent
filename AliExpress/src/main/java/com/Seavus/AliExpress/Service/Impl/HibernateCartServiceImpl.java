package com.Seavus.AliExpress.Service.Impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.Seavus.AliExpress.Dao.HibernateCreditCartDao;
import com.Seavus.AliExpress.Model.CreditCart;
import com.Seavus.AliExpress.Service.HibernateCreditCartService;

public class HibernateCartServiceImpl implements HibernateCreditCartService {

	private HibernateCreditCartDao dao;

	public HibernateCartServiceImpl(HibernateCreditCartDao dao) {
		this.dao = dao;
	}

	@Override
	public void create(CreditCart cart) {
		dao.create(cart);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public void update(CreditCart cart) {
		dao.update(cart);
	}

	@Override
	public List<CreditCart> list() {
		return dao.list();
	}

	@Override
	public CreditCart getCartById(int id) {
		return dao.getCartById(id);
	}

	@Override
	public void setFactory(SessionFactory factory) {
		dao.setFactory(factory);
	}

	@Override
	public void closeFactory() {
		dao.closeFactory();
	}

}
