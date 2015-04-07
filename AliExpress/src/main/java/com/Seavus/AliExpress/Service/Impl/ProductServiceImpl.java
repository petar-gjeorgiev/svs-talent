package com.Seavus.AliExpress.Service.Impl;

import com.Seavus.AliExpress.Dao.ProductDao;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Service.ProductService;
import com.Seavus.Dao.Impl.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {

	public ProductDao productDao = new ProductDaoImpl();
	
	@Override
	public Product getProductById(String id) {
		return productDao.getProductById(id);
	}

	@Override
	public void listAllProducts() {
		productDao.listAllProducts();
	}

	@Override
	public void addProduct(Product p) {
		productDao.addProduct(p);
	}

	@Override
	public void removeProduct(Product p) {
		productDao.removeProduct(p);
	}

}
