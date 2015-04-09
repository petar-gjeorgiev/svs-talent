package com.Seavus.AliExpress.Model;

import java.util.List;

public class Bill {

	private int id;

	private List<Product> products;

	private List<ShoppingBasket> basket;

	public Bill() {

	}

	public Bill(int id, List<Product> products, List<ShoppingBasket> basket) {
		this.id = id;
		this.products = products;
		this.basket = basket;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<ShoppingBasket> getBasket() {
		return basket;
	}

	public void setBasket(List<ShoppingBasket> basket) {
		this.basket = basket;
	}

}
