package com.Seavus.Library.Controller;

import com.Seavus.Library.Service.HibernateBookService;
import com.Seavus.Library.Service.Impl.HibernateBookServiceImpl;
import com.Seavus.Library.UI.InputUI;
import com.Seavus.Library.UI.OutputUI;
import com.Seavus.Library.UI.Impl.InputBookImpl;
import com.Seavus.Library.UI.Impl.OutputImpl;

public class HibernateBookController {

	public HibernateBookService service = new HibernateBookServiceImpl();
	public InputUI input = new InputBookImpl();
	public OutputUI output = new OutputImpl();
	
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
