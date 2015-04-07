package com.Seavus.Dao.Impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.Seavus.AliExpress.Dao.FillWarehouseDao;
import com.Seavus.AliExpress.Dao.ProductDao;
import com.Seavus.AliExpress.Model.Product;

public class FillWarehouseImpl implements FillWarehouseDao {
	
	@Override
	public void fillWarehouse() {
		Scanner scanner;
		
		ProductDao productDao = new ProductDaoImpl();
		
		try {
			scanner = new Scanner(
					new File(
							"C:/Users/student/Documents/PG/git/svs-talent/AliExpress/src/main/java/com/Seavus/AliExpress/Products.txt")); // Absolute
																														// path
																														// to
																														// Products.txt
																														// file
			String line = "";

			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				String[] productElements = line.split("\\|");
				String id = productElements[0];
				String name = productElements[1];
				int price = Integer.parseInt(productElements[2]);
				int quantity = Integer.parseInt(productElements[3]);
				productDao.addProduct(new Product(id, name, price, quantity));
			}

		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}

	
	
}
