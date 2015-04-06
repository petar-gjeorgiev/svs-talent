package com.Seavus.Library.UI.Impl;

import java.util.ArrayList;
import java.util.List;

import com.Seavus.Library.Model.Book;
import com.Seavus.Library.Model.Magazine;
import com.Seavus.Library.Model.Publication;
import com.Seavus.Library.UI.OutputUI;

public class OutputPublicationImpl implements OutputUI {

	public void list(List<Publication> publications) {
		if (publications.size() == 0) {
			System.out.println("There are no publications in the library!\n");
			return;
		}
		
		List<Book> books = new ArrayList<Book>();
		List<Magazine> magazines = new ArrayList<Magazine>();
		

		for (Publication b : publications) {
			if(b instanceof Book) {
				books.add((Book) b);
			}
			else {
				magazines.add((Magazine) b );
			}
		}
		
		StringBuilder sb = new StringBuilder();
		String id1 = "ID";
		String isbn1 = "ISBN";
		String title1 = "TITLE";
		String str = "BOOKS";
		sb.append(String.format("%13s", str) + "\n");
		sb.append(String.format("%-4s %-8s %-15s", id1, isbn1, title1) + "\n");

		for(Book b : books) {
			sb.append(String.format("%-4d %-8s %-15s", b.getId(), b.getIsbn(),
					b.getTitle()) + "\n");
		}
		
		sb.append("\n");
		str = "MAGAZINES";
		
		 id1 = "ID";
		 isbn1 = "ISSN";
		 title1 = "TITLE";
		sb.append(String.format("%13s", str) + "\n");

		 sb.append(String.format("%-4s %-8s %-15s", id1, isbn1, title1) + "\n");

		for(Magazine b : magazines) {
			sb.append(String.format("%-4d %-8s %-15s", b.getId(), b.getIssn(),
					b.getTitle()) + "\n");
		}
		
		System.out.println(sb.toString());
	}

	public void appInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("Publications menu:\n\n");
		sb.append("1 - Book\n");
		sb.append("2 - Magazine\n");
		sb.append("3 - List all publications\n");
		sb.append("end - exit menu\n");
		System.out.println(sb.toString());
	}

}
