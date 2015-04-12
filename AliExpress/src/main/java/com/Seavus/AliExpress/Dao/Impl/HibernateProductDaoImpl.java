package com.Seavus.AliExpress.Dao.Impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.Seavus.AliExpress.Dao.HibernateProductDao;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Templates.Hibernate.HibernateDaoTemplate;

@Repository
public class HibernateProductDaoImpl implements HibernateProductDao {

	private HibernateDaoTemplate template;

	private SessionFactory sessionFactory;

	public HibernateProductDaoImpl(HibernateDaoTemplate template) {
		this.template = template;
	}
	
	public Product getProductById(String id) {
		return template.getProductTransaction(sessionFactory, id);
	}

	@SuppressWarnings("unchecked")
	public Set<Product> listAllProducts() {
		List<Product> products = template.listAllProducts(sessionFactory).list();
		Set<Product> res = new HashSet<Product>();
		for(int i=0;i<products.size();i++) {
			res.add(products.get(i));
		}
		return res;
	}

	public void addProduct(Product p) {
		template.registerTransaction(sessionFactory, p);
	}

	public void removeProduct(String id) {
		template.deleteProductTransaction(sessionFactory, id);
	}

	public void updateProduct(Product p) {
		template.updateTransaction(sessionFactory, p);
	}

	public void setFactory(SessionFactory factory) {
		if(sessionFactory == null) {
			sessionFactory = factory;
		}
	}

	public void closeFactory() {
		template.closeFactory(sessionFactory);
	}

}
