package com.Seavus.AliExpress.IO;

import java.util.HashMap;
import com.Seavus.AliExpress.Exceptions.QuantityException;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Service.ProductService;

public class Output {

	public Product registerProduct(UI input) {

		Product p = new Product();
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
		AppInfo.appInfo();
		return p;
	}

	public Product updateProduct(UI input) {

		Product p = new Product();
		System.out.println("Product update page:\n\n");
		System.out
				.println("Insert product id first and then updated columns for that product\n");
		System.out.println("Product id:");
		p.setId(input.getInput().nextLine());
		System.out.println("Product name: ");
		p.setName(input.getInput().nextLine());
		System.out.println("Product price: ");
		p.setPrice(Integer.parseInt(input.getInput().nextLine()));
		System.out.println("Quantity: ");
		p.setQuantity(Integer.parseInt(input.getInput().nextLine()));
		return p;
	}

	public String removeProduct(UI input) {
		System.out.println("Product unregister page:\n\n");
		System.out.println("Product id: ");
		String line = input.getInput().nextLine();
		System.out.println("\n\n");
		AppInfo.appInfo();
		return line;
	}

	public HashMap<String, Integer> addProductsToBasket(UI input,
			ProductService service) {
		System.out.println("Add products to basket page\n\n");
		System.out.println("Insert in format: productId-quantity\n");
		System.out.println("end - to stop adding products and print the bill\n");

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String line;
		while (!(line = input.getInput().nextLine()).equals("end")) {
			String[] elements = line.split("-");
			String id = elements[0];
			int quantity = Integer.parseInt(elements[1]);
			Product p = service.getProductById(id);
			if (quantity > p.getQuantity()) {
				try {
					throw new QuantityException("Product quantity exception");
				} catch (QuantityException e) {
					e.printStackTrace();
				}
			} else {
				map.put(id, quantity);
			}
		}
		return map;
	}

}
