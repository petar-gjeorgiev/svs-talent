package com.Seavus.Library.Controller;

import com.Seavus.Library.Service.HibernateBookService;
import com.Seavus.Library.Service.Impl.HibernateBookServiceImpl;
import com.Seavus.Library.UI.InputBookUI;
import com.Seavus.Library.UI.OutputBookUI;
import com.Seavus.Library.UI.Impl.InputBookImpl;
import com.Seavus.Library.UI.Impl.OutputBookImpl;

public class HibernateBookController {

	public HibernateBookService service = new HibernateBookServiceImpl();
	public InputBookUI input = new InputBookImpl();
	public OutputBookUI output = new OutputBookImpl();
	
	public void registerBook() {
		service.register(input.RegisterInput());
	}

	public void listAllBooks() {
		output.list(service.list());
	}

	public void updateBook() {
		service.update(input.UpdateInput());
	}

	public void unregisterBook() {
		service.unregister(input.UnregisterInput());
	}

	public void appInfo() {
		output.appInfo();
	}
	
	public void createSessionFactory() {
		service.createSessionFactory();
	}
	
	public void closeFactory() {
		service.closeSession();
	}
}
