package com.Seavus.Library.Service.Impl;

import java.util.Scanner;

import com.Seavus.Library.Dao.JDBCBookDao;
import com.Seavus.Library.Dao.Impl.JDBCBookDaoImpl;
import com.Seavus.Library.Model.Book;
import com.Seavus.Library.Service.JDBCBookService;

public class JDBCBookServiceImpl implements JDBCBookService {

	public JDBCBookDao bookDao = new JDBCBookDaoImpl();

	public void updateBook() {
		StringBuilder sb = new StringBuilder();
		sb.append("Update book\n");
		System.out.println(sb.toString());
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int counter = 0;
		Book book = new Book();

		while (counter < 3) {
			if (counter == 0) {
				System.out.println("Title:");
				book.setTitle(scanner.nextLine());
			}
			if (counter == 1) {
				System.out.println("ISBN:");
				book.setIsbn(scanner.nextLine());
			}
			if(counter == 2) {
				System.out.println("ID:");
				book.setId(Long.parseLong(scanner.nextLine()));
			}
			counter++;
		}
		
		System.out.println("Successful update\n");

		bookDao.updateBook(book);
	}

	public void registerBook() {
		StringBuilder sb = new StringBuilder();
		sb.append("Insert new book:\n");
		System.out.println(sb.toString());

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int counter = 0;
		Book book = new Book();

		while (counter < 2) {
			if (counter == 0) {
				System.out.println("Title:");
				book.setTitle(scanner.nextLine());
			}
			if (counter == 1) {
				System.out.println("ISBN:");
				book.setIsbn(scanner.nextLine());
			}
			counter++;
		}

		System.out.println("Successful registration!\n");
		bookDao.registerBook(book);
	}

	public void listAllBooks() {
		System.out.println(bookDao.listAllBooks());
	}

	public void unregisterBook() {
		StringBuilder sb = new StringBuilder();
		sb.append("Unregister book\n");
		System.out.println(sb.toString());
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int counter = 0;
		long id = 0;
		while (counter < 1) {
			if (counter == 0) {
				System.out.println("ID:");
				id = Long.parseLong(scanner.nextLine());
			}
			counter++;
		}

		System.out.println("Successful unregistration\n");
		bookDao.unregisterBook(id);
	}

	public void appInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("Welcome to the Library application :)\n");
		sb.append("This is a book CRUD application.\n\n");
		sb.append("Application menu:\n\n");
		sb.append("1 - Register book\n");
		sb.append("2 - List all books\n");
		sb.append("3 - Update book\n");
		sb.append("4 - unregister book\n");
		sb.append("end - for closing the application");
		System.out.println(sb.toString());
	}

}
