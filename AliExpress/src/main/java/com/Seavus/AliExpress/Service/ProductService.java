package com.Seavus.AliExpress.Service;

import com.Seavus.AliExpress.Model.Product;

public interface ProductService {

	public Product getProductById(String id);

	public void listAllProducts();

	public void addProduct(Product p);

	public void removeProduct(Product p);

}
