package com.Seavus.AliExpress.Dao.Impl;

import java.io.File;

import org.hibernate.SessionFactory;

import com.Seavus.AliExpress.Dao.HibernateFillWarehouseDao;
import com.Seavus.AliExpress.Dao.HibernateProductDao;
import com.Seavus.AliExpress.IO.UI;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Templates.Hibernate.HibernateDaoTemplate;

public class HibernateFillWarehouseImpl implements HibernateFillWarehouseDao {

	public HibernateProductDao productDao = new HibernateProductDaoImpl();

	public HibernateDaoTemplate template = new HibernateDaoTemplate();

	public SessionFactory sessionFactory;

	public void fillWarehouse() {

		File f = new File(
				"D:/Education/Seavus/git/svs-talent/AliExpress/src/main/java/com/Seavus/AliExpress/inMemory/Products.txt");

		UI ui = new UI(f);
		String line = "";

		productDao.setFactory(sessionFactory);

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

	public void setFactory(SessionFactory factory) {
		if (sessionFactory == null) {
			sessionFactory = factory;
		}
	}

	public void closeFactory() {
		template.closeFactory(sessionFactory);
	}

}