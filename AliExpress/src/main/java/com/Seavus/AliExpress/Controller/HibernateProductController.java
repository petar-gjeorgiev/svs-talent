package com.Seavus.AliExpress.Controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Seavus.AliExpress.IO.AppInfo;
import com.Seavus.AliExpress.IO.Output;
import com.Seavus.AliExpress.IO.UI;
import com.Seavus.AliExpress.Model.Product;
import com.Seavus.AliExpress.Service.HibernateProductService;
import com.Seavus.AliExpress.Service.HibernateWarehouseService;

@Component
public class HibernateProductController {

	private HibernateProductService service;

	private HibernateWarehouseService warehouseService;

	private Output output;

	private UI input;

	@SuppressWarnings("unused")
	private AppInfo info;

	public HibernateProductController() {
		
	}
	
	@Autowired
	public HibernateProductController(HibernateProductService service,
			HibernateWarehouseService warehouseService, Output output,
			UI input, AppInfo info) {
		this.service = service;
		this.warehouseService = warehouseService;
		this.output = output;
		this.input = input;
		this.info = info;
	}

	public void registerProduct() {
		service.addProduct(output.registerProduct(input));
	}

	public void updateProduct() {
		service.updateProduct(output.updateProduct(input));
	}

	public void unregisterProduct() {
		service.removeProduct(output.removeProduct(input));
	}

	public void listProducts() {
		StringBuilder sb = new StringBuilder();
		String name = "NAME";
		String price = "PRICE";
		String id = "ID";
		sb.append(String.format("%-2s %-10s %-5s", id, name, price) + "\n");
		for (Product p : service.listAllProducts()) {
			sb.append(p + "\n");
		}
		System.out.println(sb.toString());

		System.out.println("\n");
	}

	public void fillWarehouse() {
		warehouseService.fillWarehouse();
	}

	public void closeFactory() {
		service.closeFactory();
		warehouseService.closeFactory();
	}

	public void setFactory(SessionFactory factory) {
		service.setFactory(factory);
		warehouseService.setFactory(factory);
	}

}
