package com.Seavus.AliExpress.IO;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Seavus.AliExpress.Controller.HibernateAccountController;
import com.Seavus.AliExpress.Controller.HibernateCartController;
import com.Seavus.AliExpress.Controller.HibernateProductController;
import com.Seavus.AliExpress.Controller.HibernateShoppingBasketController;
import com.Seavus.AliExpress.Controller.ProductController;
import com.Seavus.AliExpress.Controller.ShoppingBasketController;
import com.Seavus.AliExpress.Exceptions.EmptyShoppingBasketException;
import com.Seavus.AliExpress.Exceptions.FundsException;
import com.Seavus.AliExpress.Exceptions.InvalidCredentialsException;
import com.Seavus.AliExpress.Exceptions.InvalidInputException;
import com.Seavus.AliExpress.Exceptions.InvalidProductException;
import com.Seavus.AliExpress.Exceptions.QuantityException;
import com.Seavus.AliExpress.Model.Account;
import com.Seavus.AliExpress.Model.CreditCart;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Service.FillWarehouseService;
import com.Seavus.AliExpress.inMemory.ShoppingBasket;
import com.Seavus.AliExpress.inMemory.Warehouse;

@Component
public class AppInfo {

	private UI input;

	@Autowired
	private Account account;

	@Autowired
	public AppInfo(UI input) {
		this.input = input;
	}

	public AppInfo() {

	}

	public void cartMenu() {
		System.out.println("Credit cart menu: \n");
		System.out.println("1 - Register cart\n");
		System.out.println("2 - List all carts\n");
		System.out.println("3 - Delete cart\n");
		System.out.println("end - exit menu");
	}
	
	

	public void accountMenu() {
		System.out.println("Account menu:\n");
		System.out.println("1 - Register account\n");
		System.out.println("2 - Update account\n");
		System.out.println("3 - List all accounts\n");
		System.out.println("4 - Delete account\n");
		System.out.println("5 - Login\n");
		System.out.println("6 - Logout\n");
		System.out.println("end - exit menu");
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

	public void categoryMenu() {
		System.out.println("Categories menu:\n");
		System.out.println("1 - Products\n");
		System.out.println("2 - Credit carts\n");
		System.out.println("3 - Accounts\n");
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

	public void cartAppMenu(UI ui,HibernateCartController controller) {
		cartMenu();
		String line;
		while(!(line=ui.getInput().nextLine()).equals("end")) {
			if(line.equals("1")) {
				controller.registerCart();
			}
			else if(line.equals("2")) {
				controller.listCarts();
			}
			else if (line.equals("3")) {
				controller.unregisterCart();
			}
			else {
				try {
					throw new InvalidInputException("Invalid input! Try again\n");
				} catch (InvalidInputException e) {
					System.err.println(e.getMessage());
				}
			}
		}
		categoryMenu();
	}
	
	public void accountAppMenu(UI ui,HibernateAccountController controller) {
		accountMenu();		
		String line;
		while(!(line=ui.getInput().nextLine()).equals("end")) {
			if(line.equals("1")) {
				controller.register();
				accountMenu();
			}
			else if(line.equals("2")) {
				if(account != null) {
					controller.update(account.getId());
				}
				else {
					try {
						throw new InvalidCredentialsException("You are not logged in\n");
					} catch (InvalidCredentialsException e) {
						System.err.println(e.getMessage());
					}
				}
				accountMenu();
			}
			else if (line.equals("3")) {
				controller.list();
				accountMenu();
			}
			else if(line.equals("4")) {
				if(account != null) {
					controller.remove(account.getId());
				}
				else {
					try {
						throw new InvalidCredentialsException("You are not logged in\n");
					} catch (InvalidCredentialsException e) {
						System.err.println(e.getMessage());
					}
				}

				accountMenu();
			}
			else if (line.equals("5")) {
				// LOGIN
				if((this.account = controller.login()) == null) {
					try {
						throw new InvalidCredentialsException("Invalid credentials! Try again!\n");
					} catch (InvalidCredentialsException e) {
						System.err.println(e.getMessage());
						accountAppMenu(ui, controller);
					} 
				}
				else {
					System.out.println(account);
				}
				accountMenu();
			}
			else if (line.equals("6")) {
				if(account == null) {
					try {
						throw new InvalidCredentialsException("You are not logged in!\n");
					} catch (InvalidCredentialsException e) {
						System.err.println(e.getMessage());
					}
				}
				else {
					account = null;
				}
				accountMenu();
			}
			else {
				try {
					throw new InvalidInputException("Invalid input! Try again\n");
				} catch (InvalidInputException e) {
					System.err.println(e.getMessage());
				}
			}
		}
		categoryMenu();
	}
	
	public void HibernateAppMenu(UI ui,
			HibernateProductController hibernateProductController,
			HibernateShoppingBasketController hibernateShoppingBasketController,HibernateCartController cardController) {
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
				int sum = hibernateShoppingBasketController.getSum();
				printProducts(
						hibernateShoppingBasketController.listAllProducts(),
						sum);
				System.out.println("pay - to pay");
				if((ui.getInput().nextLine()).equals("pay")) {
					if(account != null) {
						if(account.getCreditCart().getBalance() > sum) {
							CreditCart c = account.getCreditCart();
							c.setBalance(c.getBalance() - sum);
							cardController.updateCart(c);
						}
						else {
							try {
								throw new FundsException("There are no enough funds in the credit cart!\n");
							} catch (FundsException e) {
								System.err.println(e.getMessage());
								HibernateAppMenu(ui, hibernateProductController, hibernateShoppingBasketController, cardController);
							}
						}
					}
					else {
						try {
							throw new InvalidCredentialsException("You are not logged in!\n");
						} catch (InvalidCredentialsException e) {
							System.err.println(e.getMessage());
						}
					}
				}
			} else {
				try {
					throw new InvalidInputException("Invalid input! Try again");
				} catch (InvalidInputException e) {
					System.err.println(e.getMessage());
				}
			}
			appInfo();
		}
		categoryMenu();
	}

	public void springHibernateMenu(
			UI ui,
			HibernateProductController hibernateProductController,
			HibernateShoppingBasketController hibernateShoppingBasketController,
			HibernateCartController cartController,
			HibernateAccountController accountController) {
		categoryMenu();
		String line;
		
		while (!(line = ui.getInput().nextLine()).equals("end")) {
			if (line.equals("1")) {
				HibernateAppMenu(ui, hibernateProductController, hibernateShoppingBasketController,cartController);
			} else if (line.equals("2")) {
				cartAppMenu(ui, cartController);
			} else if (line.equals("3")) {
				accountAppMenu(ui, accountController);
			} else {
				try {
					throw new InvalidInputException(
							"Invalid input! Try again\n");
				} catch (InvalidInputException e) {
					System.err.println(e.getMessage());
				}
			}
		}
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
