package com.Seavus.Library.UI.Impl;

import java.util.Scanner;

import com.Seavus.Library.Model.Magazine;
import com.Seavus.Library.UI.InputMagazineUI;

public class InputMagazineImpl implements InputMagazineUI {

	public Magazine UpdateInput() {
		Magazine magazine = new Magazine();
		StringBuilder sb = new StringBuilder();
		sb.append("Update magazine page\n");
		sb.append("Insert id for the item\nThen insert the new version title and issn\n");
		System.out.println(sb.toString());
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int counter = 0;
		while (counter < 3) {
			if (counter == 1) {
				System.out.println("Title:");
				magazine.setTitle(scanner.nextLine());
			}
			if (counter == 2) {
				System.out.println("ISSN:");
				magazine.setIssn(scanner.nextLine());
			}
			if (counter == 0) {
				System.out.println("ID:");
				magazine.setId(Long.parseLong(scanner.nextLine()));
			}
			counter++;
		}
		return magazine;
	}

	public Magazine RegisterInput() {
		StringBuilder sb = new StringBuilder();
		sb.append("Insert new magazine\n");
		System.out.println(sb.toString());

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int counter = 0;
		Magazine magazine = new Magazine();

		while (counter < 2) {
			if (counter == 0) {
				System.out.println("Title:");
				magazine.setTitle(scanner.nextLine());
			}
			if (counter == 1) {
				System.out.println("ISSN:");
				magazine.setIssn(scanner.nextLine());
			}
			counter++;
		}
		return magazine;
	}

	public long UnregisterInput() {
		StringBuilder sb = new StringBuilder();
		sb.append("Unregister magazine\n");
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
