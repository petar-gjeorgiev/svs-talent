package com.Seavus.AliExpress.Controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Seavus.AliExpress.IO.AppInfo;
import com.Seavus.AliExpress.IO.Output;
import com.Seavus.AliExpress.IO.UI;
import com.Seavus.AliExpress.Model.CreditCart;
import com.Seavus.AliExpress.Service.HibernateCreditCartService;

@Component
public class HibernateCartController {

	private HibernateCreditCartService service;
	
	private Output output;
	
	private UI input;
	
	private AppInfo info;

	public HibernateCartController() {
		
	}
	
	@Autowired
	public HibernateCartController(HibernateCreditCartService service,
			Output output, UI input, AppInfo info) {
		this.service = service;
		this.output = output;
		this.input = input;
		this.info = info;
	}
	
	public void updateCart(CreditCart cart) {
		service.update(cart);
	}
	
	public CreditCart getCartById (int id) {
		return service.getCartById(id);
	}
	
	public void registerCart() {
		service.create(output.registerCart(input));
	}
	
	public void unregisterCart() {
		service.delete(output.removeCart(input));
	}
	
	public void listCarts() {
		StringBuilder sb = new StringBuilder();
		String id = "ID";
		String balance = "BALANCE";
		sb.append(String.format("%-5s %-10s", id,balance) + "\n");
		for(CreditCart c : service.list()) {
			sb.append(c + "\n");
		}
		System.out.println(sb.toString() + "\n");
		info.cartMenu();
	}
	
	
	public void setFactory(SessionFactory factory) {
		service.setFactory(factory);
	}
	
	public void closeFactory() {
		service.closeFactory();
	}
	
}
