package com.Seavus.AliExpress.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hibernate_bill")
public class Bill {

	@Id
	@GeneratedValue
	private int id;

	@OneToMany(mappedBy = "bill")
	private List<Product> products;

	@OneToMany(mappedBy = "bill")
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
