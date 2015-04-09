package com.Seavus.AliExpress.inMemory;

public interface ProductInterface {

	public Product getProductById(String id);

	public void listAllProducts();

	public void addProduct(Product p);

	public void removeProduct(Product p);

}
