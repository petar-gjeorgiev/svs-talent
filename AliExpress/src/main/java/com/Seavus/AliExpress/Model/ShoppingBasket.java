package com.Seavus.AliExpress.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hibernate_basket")
public class ShoppingBasket {

	@Id
	private int id;

	private int sum;

	@OneToMany(mappedBy = "basket")
	private List<Bill> bills;

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

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

}
