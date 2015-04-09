package com.Seavus.AliExpress.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hibernate_basket")
public class ShoppingBasket {

	private int id;

	private int sum;

	@ManyToOne
	private Bill bill;

	public ShoppingBasket() {

	}

	public ShoppingBasket(int id, int sum) {
		this.id = id;
		this.sum = sum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

}
