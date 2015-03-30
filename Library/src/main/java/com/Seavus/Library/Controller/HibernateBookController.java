package com.Seavus.Library.Controller;

import com.Seavus.Library.Service.HibernateBookService;
import com.Seavus.Library.Service.Impl.HibernateBookServiceImpl;

public class HibernateBookController {

	public HibernateBookService service = new HibernateBookServiceImpl();
	
	public void registerBook() {
		service.registerBook();
	}

	public void listAllBooks() {
		service.listAllBooks();
	}

	public void updateBook() {
		service.updateBook();
	}

	public void unregisterBook() {
		service.unregisterBook();
	}

	public void appInfo() {
		service.appInfo();
	}
	
	public void createSessionFactory() {
		service.createSessionFactory();
	}
	
	public void closeFactory() {
		service.closeSession();
	}
}
