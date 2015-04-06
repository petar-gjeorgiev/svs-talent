package com.Seavus.Library.UI.Impl;

/**
 * In order first version to work where there is only a book entity
 */

import java.util.List;

import com.Seavus.Library.Model.Book;
import com.Seavus.Library.UI.OutputBookUI;

public class OutputBookImpl implements OutputBookUI {

	public void list(List<Book> objects) {
		if (objects.size() == 0) {
			System.out.println("There are no books in the library!\n");
			return;
		}
		StringBuilder sb = new StringBuilder();
		String id1 = "ID";
		String isbn1 = "ISBN";
		String title1 = "TITLE";
		sb.append(String.format("%-4s %-8s %-15s", id1, isbn1, title1) + "\n");

		for (Book b : objects) {
			sb.append(String.format("%-4d %-8s %-15s", b.getId(), b.getIsbn(),
					b.getTitle()) + "\n");
		}
		System.out.println(sb.toString());
	}

	public void appInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("Book menu:\n\n");
		sb.append("1 - Register book\n");
		sb.append("2 - List all books\n");
		sb.append("3 - Update book\n");
		sb.append("4 - unregister book\n");
		sb.append("end - exit menu");
		System.out.println(sb.toString());
	}

}
