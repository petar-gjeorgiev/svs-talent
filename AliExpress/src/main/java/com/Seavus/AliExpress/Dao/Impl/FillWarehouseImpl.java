package com.Seavus.AliExpress.Dao.Impl;

import java.io.File;

import com.Seavus.AliExpress.Dao.FillWarehouseDao;
import com.Seavus.AliExpress.Dao.ProductDao;
import com.Seavus.AliExpress.IO.UI;
import com.Seavus.AliExpress.Model.Product;

public class FillWarehouseImpl implements FillWarehouseDao {

	ProductDao productDao = new ProductDaoImpl();

	@Override
	public void fillWarehouse() {

		File f = new File(
				"C:/Users/student/Documents/PG/git/svs-talent/AliExpress/src/main/java/com/Seavus/AliExpress/Products.txt");
		UI ui = new UI(f);
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
