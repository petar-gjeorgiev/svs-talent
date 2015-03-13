package InputOutput;

public class Product {

	private String id;

	private String name;

	private int price;

	private int quantity;

	public Product(String id, String name, int price, int quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return String.format("%5s %15s %5d", id,name,price);
	}
}
