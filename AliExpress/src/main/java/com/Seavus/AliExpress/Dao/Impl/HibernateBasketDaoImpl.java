package com.Seavus.AliExpress.Dao.Impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Seavus.AliExpress.Dao.HibernateShoppingBasketDao;
import com.Seavus.AliExpress.Model.Bill;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Model.ShoppingBasket;
import com.Seavus.AliExpress.Templates.Hibernate.HibernateDaoTemplate;

@Repository
public class HibernateBasketDaoImpl implements HibernateShoppingBasketDao {

	@Autowired
	private HibernateDaoTemplate template;

	@Resource
	private SessionFactory sessionFactory;
	
	
	public HibernateBasketDaoImpl(HibernateDaoTemplate template) {
		this.template = template;
	}

	public Set<Product> listAllProducts(ShoppingBasket basket) {
		return template.listProducts(sessionFactory, basket.getId());
	}

	public void addBasket() {
		ShoppingBasket basket = new ShoppingBasket();
		basket.setSum(0);
		template.registerTransaction(sessionFactory, basket);
	}

	public ShoppingBasket getNewestBasket() {
		@SuppressWarnings("unchecked")
		List<ShoppingBasket> items = template.listAllShoppingBaskets(
				sessionFactory).list();
		return items.get(items.size() - 1);
	}

	public void updateBasket(ShoppingBasket basket) {
		template.updateTransaction(sessionFactory, basket);
	}

	public int getSum(ShoppingBasket basket) {
		ShoppingBasket sb = (ShoppingBasket) template
				.getTotalSum(sessionFactory, basket.getId()).list().get(0);
		return sb.getSum();
	}

	public void addProduct(ShoppingBasket basket, Product p, int quantity) {
		Bill b = new Bill();
		b.setBasket(basket);
		b.setProduct(p);
		b.setQuantity(quantity);
		template.registerTransaction(sessionFactory, b);
	}

	public void setFactory(SessionFactory factory) {
		if (sessionFactory == null) {
			sessionFactory = factory;
		}
	}

	public void closeFactory() {
		template.closeFactory(sessionFactory);
	}

}
