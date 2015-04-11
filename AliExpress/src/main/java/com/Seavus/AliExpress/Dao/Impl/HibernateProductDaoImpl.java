package com.Seavus.AliExpress.Dao.Impl;

import java.util.Set;

import org.hibernate.SessionFactory;

import com.Seavus.AliExpress.Dao.ProductDao;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Templates.Hibernate.HibernateDaoTemplate;

public class HibernateProductDaoImpl implements ProductDao {

	private HibernateDaoTemplate template = new HibernateDaoTemplate();

	private SessionFactory sessionFactory;

	public Product getProductById(String id) {
		return template.getProductTransaction(sessionFactory, id);
	}

	@SuppressWarnings("unchecked")
	public Set<Product> listAllProducts() {
		return (Set<Product>) template.listAllProducts(sessionFactory).list();
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

}
