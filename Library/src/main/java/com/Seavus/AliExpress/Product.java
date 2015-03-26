package com.Seavus.AliExpress;

public class Product implements Comparable<Product> {

	private String id;

	private String name;

	private int price;

	private int quantity;

	public Product(String id, String name, int price, int quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return String.format("%-2s %-10s %-5d", id, name, price);
	}

	public int compareTo(Product o) {
		return id.compareTo(o.getId());
	}

}
