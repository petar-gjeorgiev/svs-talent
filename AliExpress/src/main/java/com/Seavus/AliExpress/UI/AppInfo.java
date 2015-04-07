package com.Seavus.AliExpress.UI;

import java.util.Scanner;

import com.Seavus.AliExpress.Product;
import com.Seavus.AliExpress.ShoppingBasket;
import com.Seavus.AliExpress.Warehouse;
import com.Seavus.AliExpress.Exceptions.InvalidInputException;
import com.Seavus.AliExpress.Exceptions.InvalidProductException;
import com.Seavus.AliExpress.Exceptions.QuantityException;

public class AppInfo {

	public static void appInfo() {
		System.out
				.println("Welcome to the AliExpress e-commerce application\n");
		System.out.println("Application guide:\n");
		System.out.println("1 - List all products");
		System.out.println("end - exit app");
	}

	public static void mainMenuInfo() {
		System.out.println("Welcome to the AliExpress e-commerce application\n");
		System.out.println("Application guide:\n");
		System.out.println("1 - In memory version\n");
		System.out.println("2 - Hibernate version\n");
		System.out.println("3 - JDBC version\n");
		System.out.println("end - exit app");
	}

	public static void addProductInBasketInfo() {
		System.out.println("Add products to shopping basket in format: ProductId-Quantity\n");
		System.out.println("end - exit");
	}
	
	public static void listProducts(Scanner scanner,Warehouse warehouse)
			throws InvalidInputException {
		if (!scanner.hasNextInt() || (scanner.nextInt() != 1)) {
			throw new InvalidInputException("Invalid input");
		} else {
			warehouse.listAllProducts();
		}
	}

	public static void addProductsToBasket(Scanner scanner,ShoppingBasket shoppingBasket,Warehouse warehouse)
			throws QuantityException, InvalidProductException {

		String line;
		while (!(line = scanner.nextLine()).equals("end")) {
			String[] el = line.split("-");
			String id = el[0];
			int quantity = Integer.parseInt(el[1]);
			if (warehouse.getProductById(id) == null) {
				throw new InvalidProductException(
						"There is no product with id " + id);
			} else {
				Product p = warehouse.getProductById(id);
				if (p.getQuantity() < quantity) {
					throw new QuantityException("There are only "
							+ p.getQuantity() + " " + p.getName()
							+ " in the warehouse!");
				} else {
					shoppingBasket.addProducts(p, quantity);
					p.setQuantity(p.getQuantity() - quantity);
					if (p.getQuantity() == 0) {
						warehouse.removeProduct(p);
					}
				}
			}
		}
	}
	
}
