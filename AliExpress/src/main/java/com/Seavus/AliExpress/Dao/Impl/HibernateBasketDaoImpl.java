package com.Seavus.AliExpress.Dao.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.Seavus.AliExpress.Dao.ShoppingBasketDao;
import com.Seavus.AliExpress.Model.Bill;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Model.ShoppingBasket;
import com.Seavus.AliExpress.Templates.Hibernate.HibernateDaoTemplate;

public class HibernateBasketDaoImpl implements ShoppingBasketDao {

	private HibernateDaoTemplate template = new HibernateDaoTemplate();

	private SessionFactory sessionFactory;
	
	public void addProduct(ShoppingBasket basket, Product p) {
		
	}

	public List<Product> listAllProducts(ShoppingBasket basket) {
		int id = basket.getId();
		Session session = sessionFactory.openSession();
		Criteria c = session.createCriteria(Bill.class);
		//c.add(Restrictions.eq("", value))
		return null;
	}

	public void addBasket() {
		ShoppingBasket basket = new ShoppingBasket();
		basket.setSum(0);
		template.registerTransaction(sessionFactory, basket);
	}

	public ShoppingBasket getNewestBasket() {
		return null;
	}

}
