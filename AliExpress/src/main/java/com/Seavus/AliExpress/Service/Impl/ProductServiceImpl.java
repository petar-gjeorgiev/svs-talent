package com.Seavus.AliExpress.Service.Impl;

import java.util.Set;

import com.Seavus.AliExpress.Dao.ProductDao;
import com.Seavus.AliExpress.Dao.Impl.ProductDaoImpl;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Service.ProductService;

public class ProductServiceImpl implements ProductService {

	public ProductDao productDao = new ProductDaoImpl();

	public Product getProductById(String id) {
		return productDao.getProductById(id);
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

	public Set<Product> listAllProducts() {
		return productDao.listAllProducts();
	}

}
