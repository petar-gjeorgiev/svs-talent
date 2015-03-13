package InputOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AliExpress {

	private static Scanner scanner;

	public static void main(String[] args) {
		
		Warehouse warehouse = new Warehouse();
		
		try {
			scanner = new Scanner(new File("E:/PG/git/SVS-HOMEWORK/src/InputOutput/Products.txt"));
			
			String line = "";
			
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				String [] productElements = line.split("|");
				String id = productElements[0];
				String name = productElements[1];
				int price = Integer.parseInt(productElements[2]);
				int quantity = Integer.parseInt(productElements[3]);
				warehouse.addProduct(new Product(id,name,price,quantity));
			}
			
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}

		
		warehouse.listAllProducts();
		
	}

}
