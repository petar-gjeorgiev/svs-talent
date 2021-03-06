package com.Seavus.AliExpress.Dao.Impl;

import java.io.File;
import java.util.Scanner;

import com.Seavus.AliExpress.Dao.FillWarehouseDao;
import com.Seavus.AliExpress.Dao.ProductDao;
import com.Seavus.AliExpress.Factory.Factory;
import com.Seavus.AliExpress.IO.UI;
import com.Seavus.AliExpress.Model.Product;

public class FillWarehouseImpl implements FillWarehouseDao {

	ProductDao productDao = new ProductDaoImpl();

	public void fillWarehouse() {

		File f = new File(
				"D:/Education/Seavus/git/svs-talent/AliExpress/src/main/java/com/Seavus/AliExpress/inMemory/Products.txt");
		Scanner scanner = Factory.getScannerWithFile(f);

		UI ui = new UI(scanner);
		String line = "";

		while (ui.getInput().hasNextLine()) {
			line = ui.getInput().nextLine();
			String[] productElements = line.split("\\|");
			String id = productElements[0];
			String name = productElements[1];
			int price = Integer.parseInt(productElements[2]);
			int quantity = Integer.parseInt(productElements[3]);
			productDao.addProduct(new Product(id, name, price, quantity));
		}

	}

}
