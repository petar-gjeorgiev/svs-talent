package com.Seavus.AliExpress.Dao.Impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Seavus.AliExpress.Dao.HibernateFillWarehouseDao;
import com.Seavus.AliExpress.Dao.HibernateProductDao;
import com.Seavus.AliExpress.IO.UI;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Templates.Hibernate.HibernateDaoTemplate;

@Repository
public class HibernateFillWarehouseImpl implements HibernateFillWarehouseDao {

	private HibernateProductDao productDao;

	private HibernateDaoTemplate template;

	private SessionFactory sessionFactory;

	private Product product;

	private UI input;

	@Autowired
	public HibernateFillWarehouseImpl(HibernateProductDao productDao,
			HibernateDaoTemplate template, Product p, UI ui) {
		this.productDao = productDao;
		this.template = template;
		this.input = ui;
		this.product = p;
	}

	public void fillWarehouse() {

		UI ui = input;
		String line = "";

		productDao.setFactory(sessionFactory);

		while (ui.getInput().hasNextLine()) {
			line = ui.getInput().nextLine();
			String[] productElements = line.split("\\|");
			String id = productElements[0];
			String name = productElements[1];
			int price = Integer.parseInt(productElements[2]);
			int quantity = Integer.parseInt(productElements[3]);
			product.setId(id);
			product.setName(name);
			product.setPrice(price);
			product.setQuantity(quantity);
			productDao.addProduct(product);
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