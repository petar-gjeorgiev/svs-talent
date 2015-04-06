package com.Seavus.Library.UI.Impl;

import java.util.Scanner;

import com.Seavus.Library.Model.Book;
import com.Seavus.Library.UI.InputBookUI;


public class InputBookImpl implements InputBookUI {

	public Book UpdateInput() {
		Book b = new Book();
		StringBuilder sb = new StringBuilder();
		sb.append("Update book page\n");
		sb.append("Insert id for the item\nThen insert the new version title and isbn\n");
		System.out.println(sb.toString());
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int counter = 0;
		while (counter < 3) {
			if (counter == 1) {
				System.out.println("Title:");
				b.setTitle(scanner.nextLine());
			}
			if (counter == 2) {
				System.out.println("ISBN:");
				b.setIsbn(scanner.nextLine());
			}
			if (counter == 0) {
				System.out.println("ID:");
				b.setId(Long.parseLong(scanner.nextLine()));
			}
			counter++;
		}
		return b;
	}

	public Book RegisterInput() {
		StringBuilder sb = new StringBuilder();
		sb.append("Insert new book\n");
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

		return book;
	}

	public long UnregisterInput() {
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

		return id;
	}

}
