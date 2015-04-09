package com.Seavus.AliExpress.IO;

import com.Seavus.AliExpress.Controller.JDBCProductController;
import com.Seavus.AliExpress.Controller.JDBCShoppingBasketController;
import com.Seavus.AliExpress.Exceptions.EmptyShoppingBasketException;
import com.Seavus.AliExpress.Exceptions.InvalidProductException;
import com.Seavus.AliExpress.Exceptions.QuantityException;
import com.Seavus.AliExpress.Factory.Factory;
import com.Seavus.AliExpress.Service.FillWarehouseService;
import com.Seavus.AliExpress.inMemory.Product;
import com.Seavus.AliExpress.inMemory.ShoppingBasket;
import com.Seavus.AliExpress.inMemory.Warehouse;

public class AppInfo {

	public static void appMainMemoryInfo() {
		System.out.println("\nIn memory menu:\n");
		System.out.println("1 - List all products");
		System.out.println("end - exit menu");
	}

	public static void appInfo() {
		System.out.println("1 - Register product\n");
		System.out.println("2 - Update product\n");
		System.out.println("3 - List all products\n");
		System.out.println("4 - Delete product\n");
		System.out.println("5 - Add product to shopping cart\n");
		System.out.println("end - exit menu");
	}

	public static void mainMenuInfo() {
		System.out
				.println("Welcome to the AliExpress e-commerce application\n");
		System.out.println("Application guide:\n");
		System.out.println("1 - In memory version\n");
		System.out.println("2 - JDBC version\n");
		System.out.println("3 - Hibernate version\n");
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

	public static void JDBCAppMenu(UI ui, JDBCProductController controller,JDBCShoppingBasketController shoppingController,FillWarehouseService warehouseService) {
		
		//warehouseService.fillWarehouse();
		appInfo();
		String line;
		while (!(line = ui.getInput().nextLine()).equals("end")) {
			if(line.equals("1")) {
				controller.registerProduct();
			}
			if(line.equals("2")) {
				controller.updateProduct();
			}
			if(line.equals("3")) {
				controller.listProducts();
			}
			if(line.equals("4")) {
				controller.unregisterProduct();
			}
			if(line.equals("5")) {
				shoppingController.addProductsToBasket();
			}
		}
	}

	public static void inMemoryAppMenu(UI ui, Warehouse warehouse,
			ShoppingBasket shoppingBasket) {
		appMainMemoryInfo();

		if (ui.getInput().nextLine().equals("1")) {
			warehouse.listAllProducts();
			AppInfo.addProductInBasketInfo();
			try {
				AppInfo.addProductsToBasket(Factory.Input(), shoppingBasket,
						warehouse);
			} catch (QuantityException e) {
				System.err.println(e.getMessage());
			} catch (InvalidProductException e) {
				System.err.println(e.getMessage());
			} catch (EmptyShoppingBasketException e) {
				System.err.println(e.getMessage());
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
