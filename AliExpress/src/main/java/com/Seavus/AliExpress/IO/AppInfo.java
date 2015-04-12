package com.Seavus.AliExpress.IO;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Seavus.AliExpress.Controller.HibernateProductController;
import com.Seavus.AliExpress.Controller.HibernateShoppingBasketController;
import com.Seavus.AliExpress.Controller.ProductController;
import com.Seavus.AliExpress.Controller.ShoppingBasketController;
import com.Seavus.AliExpress.Exceptions.EmptyShoppingBasketException;
import com.Seavus.AliExpress.Exceptions.InvalidInputException;
import com.Seavus.AliExpress.Exceptions.InvalidProductException;
import com.Seavus.AliExpress.Exceptions.QuantityException;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Service.FillWarehouseService;
import com.Seavus.AliExpress.inMemory.ShoppingBasket;
import com.Seavus.AliExpress.inMemory.Warehouse;

@Component
public class AppInfo {

	private UI input;

	@Autowired
	public AppInfo(UI input) {
		this.input = input;
	}
	
	public AppInfo() {
		
	}

	public void appMainMemoryInfo() {
		System.out.println("\nIn memory menu:\n");
		System.out.println("1 - List all products");
		System.out.println("end - exit menu");
	}

	public void appInfo() {
		System.out.println("1 - Register product\n");
		System.out.println("2 - Update product\n");
		System.out.println("3 - List all products\n");
		System.out.println("4 - Delete product\n");
		System.out.println("5 - Add product to shopping cart\n");
		System.out.println("end - exit menu");
	}

	public void mainMenuInfo() {
		System.out
				.println("Welcome to the AliExpress e-commerce application\n");
		System.out.println("Application guide:\n");
		System.out.println("1 - In memory version\n");
		System.out.println("2 - JDBC version\n");
		System.out.println("3 - Hibernate version\n");
		System.out.println("end - exit app");
	}

	public void addProductInBasketInfo() {
		System.out
				.println("Add products to shopping basket in format: ProductId-Quantity\n");
		System.out.println("end - proceed with payment");
	}

	public void printProducts(Set<Product> products, int sum) {
		StringBuilder sb = new StringBuilder();
		String name = "NAME";
		String price = "PRICE";
		String id = "ID";
		String quantity = "QUANTITY";
		sb.append(String.format("%-2s %-10s %-5s %-4s", id, name, price,
				quantity) + "\n");
		for (Product p : products) {
			sb.append(String.format("%s %-4s", p, p.getQuantity()) + "\n");
		}
		sb.append("\nTotal sum: " + sum);
		System.out.println(sb.toString());
	}

	public void JDBCAppMenu(UI ui, ProductController controller,
			ShoppingBasketController shoppingController,
			FillWarehouseService warehouseService) {

		// warehouseService.fillWarehouse();
		appInfo();
		String line;
		while (!(line = ui.getInput().nextLine()).equals("end")) {
			if (line.equals("1")) {
				controller.registerProduct();
			}
			if (line.equals("2")) {
				controller.updateProduct();
			}
			if (line.equals("3")) {
				controller.listProducts();
			}
			if (line.equals("4")) {
				controller.unregisterProduct();
			}
			if (line.equals("5")) {
				shoppingController.addProductsToBasket();
				printProducts(shoppingController.listAllProducts(),
						shoppingController.getSum());
			}
		}
	}

	public void HibernateAppMenu(UI ui,
			HibernateProductController hibernateProductController,
			HibernateShoppingBasketController hibernateShoppingBasketController) {
		/**
		 * To fill the Product table .. Execute this line when you run the app
		 * for the first time only..
		 */
		// hibernateProductController.fillWarehouse();
		appInfo();
		String line;
		while (!(line = ui.getInput().nextLine()).equals("end")) {
			if (line.equals("1")) {
				hibernateProductController.registerProduct();
			} else if (line.equals("2")) {
				hibernateProductController.updateProduct();
			} else if (line.equals("3")) {
				hibernateProductController.listProducts();
			} else if (line.equals("4")) {
				hibernateProductController.unregisterProduct();
			} else if (line.equals("5")) {
				hibernateShoppingBasketController.addProductsToBasket();
				printProducts(
						hibernateShoppingBasketController.listAllProducts(),
						hibernateShoppingBasketController.getSum());
			} else {
				try {
					throw new InvalidInputException("Invalid input! Try again");
				} catch (InvalidInputException e) {
					System.err.println(e.getMessage());
					;
				}
			}
		}
		mainMenuInfo();
	}

	public void inMemoryAppMenu(UI ui, Warehouse warehouse,
			ShoppingBasket shoppingBasket) {
		appMainMemoryInfo();

		if (ui.getInput().nextLine().equals("1")) {
			warehouse.listAllProducts();
			addProductInBasketInfo();
			try {
				addProductsToBasket(input, shoppingBasket, warehouse);
			} catch (QuantityException e) {
				System.err.println(e.getMessage());
			} catch (InvalidProductException e) {
				System.err.println(e.getMessage());
			} catch (EmptyShoppingBasketException e) {
				System.err.println(e.getMessage());
			}
		}

	}

	public void addProductsToBasket(UI ui, ShoppingBasket shoppingBasket,
			Warehouse warehouse) throws QuantityException,
			InvalidProductException, EmptyShoppingBasketException {

		String line;
		while (!(line = ui.getInput().nextLine()).equals("end")) {
			String[] el = line.split("-");
			String id = el[0];
			int quantity = Integer.parseInt(el[1]);
			if (warehouse.getProductById(id) == null) {
				throw new InvalidProductException(
						"There is no product with id " + id);
			} else {
				com.Seavus.AliExpress.inMemory.Product p = warehouse
						.getProductById(id);
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
