package com.Seavus.AliExpress.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hibernate_bill")
public class Bill {

	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	private Product product;

	@ManyToOne
	private ShoppingBasket basket;

	private int quantity;

	public Bill() {

	}

	public Bill(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ShoppingBasket getBasket() {
		return basket;
	}

	public void setBasket(ShoppingBasket basket) {
		this.basket = basket;
	}

}
