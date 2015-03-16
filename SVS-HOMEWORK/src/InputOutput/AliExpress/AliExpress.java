package InputOutput.AliExpress;

import java.util.Scanner;

public class AliExpress {

	public static Scanner scanner;
	public static Warehouse warehouse = new Warehouse();
	public static ShoppingBasket shoppingBasket = new ShoppingBasket();

	public static void main(String[] args) {

		Warehouse.fillWarehouse(warehouse);

		System.out
				.println("Welcome to the AliExpress e-commerce application\n");
		System.out.println("Application guide:\n");
		System.out.println("Type \"1\" to list all products in the warehouse\n");

		scanner = new Scanner(System.in);

		try {
			listProducts(scanner);
			System.out
					.println("Add products to shopping basket in format: ProductId-Quantity\n");
			System.out.println("To end inserting type \"end\".\n");
			scanner = new Scanner(System.in);
			addProductsToBasket(scanner);
			shoppingBasket.listAllProducts();
		} catch (InvalidInputException e) {
			System.err.println(e.getMessage());
		} catch (QuantityException | InvalidProductException e) {
			System.err.println(e.getMessage());
		} catch (EmptyShoppingBasketException e) {
			System.err.println(e.getMessage());
		}

	}

	public static void listProducts(Scanner scanner)
			throws InvalidInputException {
		if (!scanner.hasNextInt() || (scanner.nextInt() != 1)) {
			throw new InvalidInputException("Invalid input");
		} else {
			warehouse.listAllProducts();
		}
	}

	public static void addProductsToBasket(Scanner scanner)
			throws QuantityException, InvalidProductException {

		String line;
		while (!(line = scanner.nextLine()).equals("end")) {
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
	}

}
