package com.Seavus.AliExpress.Service;

import java.util.List;

import com.Seavus.AliExpress.Model.Product;

public interface ProductService {

	public Product getProductById(String id);

	public List<Product> listAllProducts();

	public void addProduct(Product p);

	public void removeProduct(String id);
	
	public void updateProduct(Product p);
	
}
