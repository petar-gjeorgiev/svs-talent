package com.Seavus.Library.Controller;

import com.Seavus.Library.Service.JDBCBookService;
import com.Seavus.Library.Service.Impl.JDBCBookServiceImpl;

public class JDBCBookController {

	public JDBCBookService service = new JDBCBookServiceImpl();

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
	
}
