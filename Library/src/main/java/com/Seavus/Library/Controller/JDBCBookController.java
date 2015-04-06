package com.Seavus.Library.Controller;

import com.Seavus.Library.Service.JDBCBookService;
import com.Seavus.Library.Service.Impl.JDBCBookServiceImpl;
import com.Seavus.Library.UI.InputBookUI;
import com.Seavus.Library.UI.OutputBookUI;
import com.Seavus.Library.UI.Impl.InputBookImpl;
import com.Seavus.Library.UI.Impl.OutputBookImpl;

public class JDBCBookController {

	public JDBCBookService service = new JDBCBookServiceImpl();
	public InputBookUI input = new InputBookImpl();
	public OutputBookUI output = new OutputBookImpl();
	
	public void registerBook() {
		service.registerBook(input.RegisterInput());
	}

	public void listAllBooks() {
		output.list(service.list());
	}

	public void updateBook() {
		service.updateBook(input.UpdateInput());
	}

	public void unregisterBook() {
		service.unregisterBook(input.UnregisterInput());
	}

	public void appInfo() {
		output.appInfo();
	}
	
}
