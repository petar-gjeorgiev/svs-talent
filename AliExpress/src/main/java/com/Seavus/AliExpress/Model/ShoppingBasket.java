package com.Seavus.AliExpress.Model;

public class ShoppingBasket {

	private int id;

	private int sum;

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

}
