package com.Seavus.AliExpress.inMemory;

import java.util.HashMap;

import com.Seavus.AliExpress.Exceptions.EmptyShoppingBasketException;

public class ShoppingBasket implements ShoppingCart {

	HashMap<Product, Integer> basket;

	public ShoppingBasket() {
		basket = new HashMap<Product, Integer>();
	}

	public void addProducts(Product p, int quantity) {
		basket.put(p, new Integer(quantity));
	}

	public void ListAllProducts() throws EmptyShoppingBasketException { // In
																		// the
																		// controller

		StringBuilder sb = new StringBuilder();
		int sum = 0;
		String id = "ID";
		String name = "Name";
		String price = "Price";
		sb.append("\nShopping cart items:\n"
				+ String.format("%2s %-10s %-5s", id, name, price) + "\n");
		for (Product p : basket.keySet()) {
			int quantity = basket.get(p).intValue();
			sum += p.getPrice() * quantity;
			sb.append(p + "  " + "x" + quantity + "\n");
		}
		if (sum == 0) {
			throw new EmptyShoppingBasketException(
					"There are no products in the shopping basket!");
		}
		sb.append("\nSum: " + sum);
		System.out.println("\n" + sb.toString());
	}

}
