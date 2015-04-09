package com.Seavus.AliExpress.Dao.Impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.Seavus.AliExpress.Dao.ProductDao;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Templates.Hibernate.HibernateDaoTemplate;

public class HibernateProductDaoImpl implements ProductDao {

	private HibernateDaoTemplate template = new HibernateDaoTemplate();

	private SessionFactory sessionFactory;

	public Product getProductById(String id) {

		return null;
	}

	public List<Product> listAllProducts() {

		return null;
	}

	public void addProduct(Product p) {

		template.registerTransaction(sessionFactory, p);
	}

	public void removeProduct(String id) {

	}

	public void updateProduct(Product p) {
		template.updateTransaction(sessionFactory, p);
	}

}
