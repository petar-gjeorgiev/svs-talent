package com.Seavus.AliExpress.Controller;

import java.util.List;

import org.hibernate.SessionFactory;

import com.Seavus.AliExpress.IO.AppInfo;
import com.Seavus.AliExpress.IO.Output;
import com.Seavus.AliExpress.IO.UI;
import com.Seavus.AliExpress.Model.Account;
import com.Seavus.AliExpress.Service.HibernateAccountService;
import com.Seavus.AliExpress.Service.HibernateCreditCartService;

public class HibernateAccountController {

	private HibernateAccountService service;

	private HibernateCreditCartService cartService;

	private Output output;

	private UI input;

	@SuppressWarnings("unused") // may be used in the future ...
	private AppInfo info;

	public HibernateAccountController(HibernateAccountService service,
			Output output, UI input, AppInfo info,
			HibernateCreditCartService cartService) {
		this.service = service;
		this.output = output;
		this.input = input;
		this.info = info;
		this.cartService = cartService;
	}

	public void register() {
		service.create(output.registerAccount(input, cartService));
	}
	
	public Account login() {
		return output.loginIntoAccount(input, service);
	}

	public void remove(int id) {
		service.delete(id);
	}

	public void update(int id) {
		service.update(output.updateAccount(input, cartService,id));
	}

	public void list() {
		StringBuilder sb = new StringBuilder();
		String id = "ID";
		String name = "NAME";
		String email = "EMAIL";
		sb.append(String.format("%-5s %-10s %-15s", id, name, email) + "\n");
		List<Account> accounts = service.list();
		for (Account a : accounts) {
			sb.append(a + "\n");
		}
		System.out.println(sb.toString() + "\n");
	}

	public void setFactory(SessionFactory factory) {
		service.setFactory(factory);
	}

	public void closeFactory() {
		service.closeFactory();
	}

}
