package com.Seavus.AliExpress.Dao;

import java.util.List;

import com.Seavus.AliExpress.Model.Product;


public interface ProductDao {

	public Product getProductById(String id);

	public List<Product> listAllProducts();

	public void addProduct(Product p);

	public void removeProduct(String id);

	public void updateProduct(Product p);
	
}
