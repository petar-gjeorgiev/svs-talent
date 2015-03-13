package InputOutput;

import java.util.TreeSet;

public class Warehouse {

	TreeSet<Product> products;

	public Warehouse() {
		products = new TreeSet<Product>();
	}

	public void addProduct(Product p) {
		products.add(p);
	}

	public void listAllProducts() {
		StringBuilder sb = new StringBuilder();
		sb.append("All products:\n");
		String id = "ID";
		String name = "Name";
		String price = "Price";
		sb.append(String.format("%5s %15s %5s", id, name, price) + "\n");
		for (Product p : products) {
			sb.append(p + "\n");
		}
	}
}
