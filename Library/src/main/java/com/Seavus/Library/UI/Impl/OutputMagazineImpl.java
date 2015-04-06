package com.Seavus.Library.UI.Impl;

import java.util.List;

import com.Seavus.Library.Model.Magazine;
import com.Seavus.Library.Model.Publication;
import com.Seavus.Library.UI.OutputUI;

public class OutputMagazineImpl implements OutputUI {

	public void list(List<Publication> objects) {
		if (objects.size() == 0) {
			System.out.println("There are no magazines in the library!\n");
			return;
		}
		StringBuilder sb = new StringBuilder();
		String id1 = "ID";
		String isbn1 = "ISSN";
		String title1 = "TITLE";
		sb.append(String.format("%-4s %-8s %-15s", id1, isbn1, title1) + "\n");

		for (Publication b1 : objects) {
			if (b1 instanceof Magazine) {
				Magazine b = (Magazine) b1;
				sb.append(String.format("%-4d %-8s %-15s", b.getId(),
						b.getIssn(), b.getTitle())
						+ "\n");
			}
		}
		System.out.println(sb.toString());
	}

	public void appInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("Magazine menu:\n\n");
		sb.append("1 - Register magazine\n");
		sb.append("2 - List all magazines\n");
		sb.append("3 - Update magazine\n");
		sb.append("4 - unregister magazine\n");
		sb.append("end - exit menu");
		System.out.println(sb.toString());
	}

}
