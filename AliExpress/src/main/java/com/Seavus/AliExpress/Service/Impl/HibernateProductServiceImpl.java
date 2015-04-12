package com.Seavus.AliExpress.Service.Impl;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Seavus.AliExpress.Dao.HibernateProductDao;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Service.HibernateProductService;

@Service
public class HibernateProductServiceImpl implements HibernateProductService {

	public HibernateProductDao productDao;

	@Autowired
	public HibernateProductServiceImpl(HibernateProductDao productDao) {
		this.productDao = productDao;
	}
	
	public Product getProductById(String id) {
		return productDao.getProductById(id);
	}

	public Set<Product> listAllProducts() {
		return productDao.listAllProducts();
	}

	public void addProduct(Product p) {
		productDao.addProduct(p);
	}

	public void removeProduct(String id) {
		productDao.removeProduct(id);
	}

	public void updateProduct(Product p) {
		productDao.updateProduct(p);
	}

	public void setFactory(SessionFactory factory) {
		productDao.setFactory(factory);
	}

	public void closeFactory() {
		productDao.closeFactory();
	}

}
