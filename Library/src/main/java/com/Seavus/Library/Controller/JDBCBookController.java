package com.Seavus.Library.Controller;

import com.Seavus.Library.Service.JDBCBookService;
import com.Seavus.Library.Service.Impl.JDBCBookServiceImpl;
import com.Seavus.Library.UI.InputUI;
import com.Seavus.Library.UI.OutputUI;
import com.Seavus.Library.UI.Impl.InputBookImpl;
import com.Seavus.Library.UI.Impl.OutputImpl;

public class JDBCBookController {

	public JDBCBookService service = new JDBCBookServiceImpl();
	public InputUI input = new InputBookImpl();
	public OutputUI output = new OutputImpl();
	
	public void registerBook() {
		service.registerBook(input.RegisterInput());
	}

	public void listAllBooks() {
		output.list(service.list());;
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
