package com.Seavus.AliExpress.IO;

import com.Seavus.AliExpress.Exceptions.EmptyShoppingBasketException;
import com.Seavus.AliExpress.Exceptions.InvalidProductException;
import com.Seavus.AliExpress.Exceptions.QuantityException;
import com.Seavus.AliExpress.Factory.Factory;
import com.Seavus.AliExpress.inMemory.Product;
import com.Seavus.AliExpress.inMemory.ShoppingBasket;
import com.Seavus.AliExpress.inMemory.Warehouse;

public class AppInfo {

	public static void appInfoInMemory() {
		System.out.println("\nIn memory menu:\n");
		System.out.println("1 - List all products");
		System.out.println("end - exit menu");
	}

	public static void mainMenuInfo() {
		System.out
				.println("Welcome to the AliExpress e-commerce application\n");
		System.out.println("Application guide:\n");
		System.out.println("1 - In memory version\n");
		System.out.println("2 - Hibernate version\n");
		System.out.println("3 - JDBC version\n");
		System.out.println("end - exit app");
	}

	public static void addProductInBasketInfo() {
		System.out
				.println("Add products to shopping basket in format: ProductId-Quantity\n");
		System.out.println("end - proceed with payment");
	}

	public static void mainMenu(UI input, Warehouse warehouse,
			ShoppingBasket shoppingBasket) {
		String line;
		while (!(line = input.getInput().nextLine()).equals("end")) {
			if (line.equals("1")) {
				inMemoryAppMenu(Factory.Input(), warehouse, shoppingBasket);
				mainMenuInfo();
			}
			if (line.equals("2")) {

			}
			if (line.equals("3")) {

			}
		}
	}

	public static void inMemoryAppMenu(UI ui, Warehouse warehouse,
			ShoppingBasket shoppingBasket) {
		appInfoInMemory();

		if (ui.getInput().nextLine().equals("1")) {
			warehouse.listAllProducts();
			AppInfo.addProductInBasketInfo();
			try {
				AppInfo.addProductsToBasket(Factory.Input(), shoppingBasket,
						warehouse);
			} catch (QuantityException e) {
				System.err.println(e.getMessage());
				//inMemoryAppMenu(ui, warehouse, shoppingBasket);
			} catch (InvalidProductException e) {
				System.err.println(e.getMessage());
				//inMemoryAppMenu(ui, warehouse, shoppingBasket);
			} catch (EmptyShoppingBasketException e) {
				System.err.println(e.getMessage());
				//inMemoryAppMenu(ui, warehouse, shoppingBasket);
			}
		}

	}

	public static void addProductsToBasket(UI ui,
			ShoppingBasket shoppingBasket, Warehouse warehouse)
			throws QuantityException, InvalidProductException,
			EmptyShoppingBasketException {

		String line;
		while (!(line = ui.getInput().nextLine()).equals("end")) {
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
		shoppingBasket.ListAllProducts();
		inMemoryAppMenu(ui, warehouse, shoppingBasket);
	}

}
