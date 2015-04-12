package com.Seavus.AliExpress.IO;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Seavus.AliExpress.Exceptions.QuantityException;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Service.ProductService;

@Component
public class Output {

	private Product p;

	private HashMap<String, Integer> map;

	private AppInfo info;

	@Autowired
	public Output(Product p, HashMap<String, Integer> map, AppInfo info) {
		this.p = p;
		this.map = map;
		this.info = info;
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

	public String removeProduct(UI input) {
		System.out.println("Product unregister page:\n\n");
		System.out.println("Product id: ");
		String line = input.getInput().nextLine();
		System.out.println("\n\n");
		info.appInfo();
		return line;
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
