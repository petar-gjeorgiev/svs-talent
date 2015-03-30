package com.Seavus.Library.Application;

import java.util.Scanner;
import com.Seavus.Library.Controller.JDBCBookController;

public class LibraryJDBCApp {

	public static void main(String[] args) {

		JDBCBookController controller = new JDBCBookController();
		controller.appInfo();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String line;
		while (!(line = scanner.nextLine()).equals("end")) {
			if (line.equals("1")) {
				controller.registerBook();
			}
			if (line.equals("2")) {
				controller.listAllBooks();
			}
			if (line.equals("3")) {
				controller.updateBook();
			}
			if (line.equals("4")) {
				controller.unregisterBook();
			}
		}
	}

}
