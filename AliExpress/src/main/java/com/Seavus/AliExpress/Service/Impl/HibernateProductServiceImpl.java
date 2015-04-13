package com.Seavus.AliExpress.Service.Impl;

import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Seavus.AliExpress.Dao.HibernateProductDao;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Service.HibernateProductService;

@Service
@Transactional
public class HibernateProductServiceImpl implements HibernateProductService {

	@Autowired
	public HibernateProductDao productDao;

	public HibernateProductServiceImpl() {
		
	}
	
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
