package com.Seavus.AliExpress.IO;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Seavus.AliExpress.Exceptions.QuantityException;
import com.Seavus.AliExpress.Model.Account;
import com.Seavus.AliExpress.Model.BalanceType;
import com.Seavus.AliExpress.Model.CreditCart;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Service.HibernateAccountService;
import com.Seavus.AliExpress.Service.HibernateCreditCartService;
import com.Seavus.AliExpress.Service.ProductService;

@Component
public class Output {

	private CreditCart cart;

	private Account account;

	private Product p;

	private HashMap<String, Integer> map;

	private AppInfo info;

	@Autowired
	public Output(Product p, HashMap<String, Integer> map, AppInfo info,CreditCart cart,Account account) {
		this.p = p;
		this.map = map;
		this.info = info;
		this.cart = cart;
		this.account = account;
	}

	public CreditCart registerCart(UI input) {
		try {
			System.out.println("Credit cart registration page\n");
			System.out.println("Balance:");
			
			cart.setBalance(Integer.parseInt(input.getInput().nextLine()));
		} catch (Exception e) {
			System.err.println(e.getMessage());
			registerCart(input);
		}

		return cart;
	}
	
	public Account loginIntoAccount(UI input,HibernateAccountService service) {
		System.out.println("Account login page:\n");
		String email,password;
		System.out.println("Email: "); 
		email = input.getInput().nextLine();
		System.out.println("Password: "); 
		password = input.getInput().nextLine();
		Account a = service.getAccountByCredentials(email, password);
		return a;
	}

	public Account registerAccount(UI input,
			HibernateCreditCartService cartService) {
		try {
			System.out.println("Account registration page\n\n");
			System.out.println("Name:");
			account.setName(input.getInput().nextLine());
			System.out.println("Email:");
			account.setEmail(input.getInput().nextLine());
			System.out.println("Password:");
			account.setPassword(input.getInput().nextLine());
			System.out.println("Cart id:");
			int id = Integer.parseInt(input.getInput().nextLine());
			CreditCart cart = cartService.getCartById(id);
			account.setCreditCart(cart);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			registerAccount(input, cartService);
		}
		return account;
	}

	public Product registerProduct(UI input) {
		try {
			System.out.println("Product registration page:\n\n");
			System.out.println("Product id:");
			p.setId(input.getInput().nextLine());
			System.out.println("Product name: ");
			p.setName(input.getInput().nextLine());
			System.out.println("Product price: ");
			p.setPrice(Integer.parseInt(input.getInput().nextLine()));
			System.out.println("Quantity: ");
			p.setQuantity(Integer.parseInt(input.getInput().nextLine()));
			System.out.println("\n\n");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			registerProduct(input);
		}

		info.appInfo();
		return p;
	}

	public Product updateProduct(UI input) {

		System.out.println("Product update page:\n\n");
		System.out
				.println("Insert product id first and then updated columns for that product\n");
		try {
			System.out.println("Product id:");
			p.setId(input.getInput().nextLine());
			System.out.println("Product name: ");
			p.setName(input.getInput().nextLine());
			System.out.println("Product price: ");
			p.setPrice(Integer.parseInt(input.getInput().nextLine()));
			System.out.println("Quantity: ");
			p.setQuantity(Integer.parseInt(input.getInput().nextLine()));

		} catch (Exception e) {
			System.err.println(e.getMessage());
			updateProduct(input);
		}
		return p;
	}

	public Account updateAccount(UI input,
			HibernateCreditCartService cartService,int accoutId) {
		System.out.println("Account update page\n");
		System.out
				.println("Insert account id first and then the updated columns for account");
		try {
			account.setId(accoutId);
			System.out.println("Name:");
			account.setName(input.getInput().nextLine());
			System.out.println("Email:");
			account.setEmail(input.getInput().nextLine());
			System.out.println("Password:");
			account.setPassword(input.getInput().nextLine());
			System.out.println("Cart id:");
			int id = Integer.parseInt(input.getInput().nextLine());
			CreditCart cart = cartService.getCartById(id);
			account.setCreditCart(cart);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			updateAccount(input, cartService,accoutId);
		}
		return account;
	}

	public CreditCart updateCart(CreditCart cart, int balance, BalanceType type) {
		if (type == BalanceType.ADD) {
			cart.setBalance(cart.getBalance() + balance);
		} else {
			cart.setBalance(cart.getBalance() - balance);
		}
		return cart;
	}

	public String removeProduct(UI input) {
		System.out.println("Product unregister page:\n\n");
		System.out.println("Product id: ");
		String line = input.getInput().nextLine();
		System.out.println("\n\n");
		info.appInfo();
		return line;
	}

	public int removeCart(UI input) {
		System.out.println("Cart remove page\n");
		System.out.println("Cart id:");
		int id = Integer.parseInt(input.getInput().nextLine());
		return id;
	}

	public HashMap<String, Integer> addProductsToBasket(UI input,
			ProductService service) {
		System.out.println("Add products to basket page\n\n");
		System.out.println("Insert in format: productId-quantity\n");
		System.out
				.println("end - to stop adding products and print the bill\n");
		try {

			String line;
			while (!(line = input.getInput().nextLine()).equals("end")) {
				String[] elements = line.split("-");
				String id = elements[0];
				int quantity = Integer.parseInt(elements[1]);
				Product p = service.getProductById(id);
				if (quantity > p.getQuantity()) {
					try {
						throw new QuantityException(
								"Product quantity exception");
					} catch (QuantityException e) {
						e.printStackTrace();
					}
				} else {
					map.put(id, quantity);
				}
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			addProductsToBasket(input, service);
		}
		return map;
	}

}
