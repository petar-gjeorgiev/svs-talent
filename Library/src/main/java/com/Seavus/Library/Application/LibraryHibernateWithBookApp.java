package com.Seavus.Library.Application;

import java.util.Scanner;
import com.Seavus.Library.Controller.HibernateBookController;

// It won't work because of the inheretence between
// Book and Publication 

public class LibraryHibernateWithBookApp {

	public static void main(String[] args) {
		HibernateBookController controller = new HibernateBookController();
		
		controller.createSessionFactory();
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
		controller.closeFactory();
	}

}
