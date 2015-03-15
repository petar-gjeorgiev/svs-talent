package InputOutput.AliExpress;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class Warehouse implements ProductInterface {

	TreeSet<Product> products;

	public Warehouse() {
		products = new TreeSet<Product>();
	}

	public void addProduct(Product p) {
		products.add(p);
	}

	public void removeProduct(Product p) {
		products.remove(p);
	}

	public Product getProductById(String id) {
		Product p = null;
		for (Product p1 : products) {
			if (p1.getId().equals(id)) {
				p = p1;
				break;
			}
		}
		return p;
	}

	public void listAllProducts() {
		StringBuilder sb = new StringBuilder();
		sb.append("List of all products:\n");
		String id = "ID";
		String name = "Name";
		String price = "Price";
		sb.append(String.format("%2s %-10s %-5s", id, name, price) + "\n");
		for (Product p : products) {
			sb.append(p + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void fillWarehouse(Warehouse warehouse) {

		Scanner scanner;
		try {
			scanner = new Scanner(
					new File(
							"C:/Users/user/git/svs-homework/SVS-HOMEWORK/src/InputOutput/AliExpress/Products.txt"));

			String line = "";

			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				String[] productElements = line.split("\\|");
				String id = productElements[0];
				String name = productElements[1];
				int price = Integer.parseInt(productElements[2]);
				int quantity = Integer.parseInt(productElements[3]);
				Product p = new Product(id, name, price, quantity);
				warehouse.addProduct(p);
			}

		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}

}
