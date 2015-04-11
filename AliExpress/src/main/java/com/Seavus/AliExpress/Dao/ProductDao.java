package com.Seavus.AliExpress.Dao;

import java.util.Set;

import com.Seavus.AliExpress.Model.Product;


public interface ProductDao {

	public Product getProductById(String id);

	public Set<Product> listAllProducts();

	public void addProduct(Product p);

	public void removeProduct(String id);

	public void updateProduct(Product p);
	
}
