package com.Seavus.AliExpress.Dao;

import com.Seavus.AliExpress.Model.Product;


public interface ProductDao {

	public Product getProductById(String id);

	public void listAllProducts();

	public void addProduct(Product p);

	public void removeProduct(Product p);

}
