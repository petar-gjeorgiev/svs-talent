package com.Seavus.Library.Application;

import java.util.Scanner;

import com.Seavus.Library.Controller.HibernateLoanController;
import com.Seavus.Library.Controller.HibernateMemberController;
import com.Seavus.Library.Controller.HibernatePublicationController;
import com.Seavus.Library.Factory.Factory;
import com.Seavus.Library.UI.AppInfoUI;
import com.Seavus.Library.UI.Impl.AppInfoImpl;

public class LibraryHibernateAppPublication {
	
	public static void main(String[] args) {
		HibernatePublicationController controller = new HibernatePublicationController();
		HibernateMemberController memberController = new HibernateMemberController();
		HibernateLoanController loanController = new HibernateLoanController();
		
		AppInfoUI appInfo = new AppInfoImpl();
		Factory.createSessionFactory();
		controller.setFactory(Factory.getFactory());
		memberController.setFactory(Factory.getFactory());
		loanController.setFactory(Factory.getFactory());
		appInfo.AppInfo();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String line;
		while (!(line = scanner.nextLine()).equals("end")) {
			
			if (line.equals("1")) {
				controller.appInfo();
				@SuppressWarnings("resource")
				Scanner scanner1 = new Scanner(System.in);
				while(!(line = scanner1.nextLine()).equals("end")) {
					
					@SuppressWarnings("resource")
					Scanner scanner3 = new Scanner(System.in);
					
					if(line.equals("1")) {
						controller.appBookInfo();
						
						while(!(line = scanner3.nextLine()).equals("end")) {
							
							if(line.equals("1")) {
								controller.registerBook();
								System.out.println("Successful registration\n");
							}
							
							if(line.equals("2")) {
								controller.listAllBooks();
							}
							
							if(line.equals("3")) {
								controller.updateBook();
								
							}
							
							if(line.equals("4")) {
								controller.unregisterBook();
							}
						}
						controller.appInfo();
					}
					
					if(line.equals("2")) {
						controller.appMagazineInfo();
	
						while(!(line = scanner3.nextLine()).equals("end")) {
							if(line.equals("1")) {
								controller.registerMagazine();							
							}
							
							if(line.equals("2")) {
								controller.listAllMagazines();
							}
							
							if(line.equals("3")) {
								controller.updateMagazine();
							}
							
							if(line.equals("4")) {
								controller.unregisterMagazine();
							}
						}
						controller.appMagazineInfo();
					}
					
					if(line.equals("3")) {
						controller.listAllPublications();
					}
				}
				appInfo.AppInfo();
			}
			if(line.equals("2")) {
				memberController.registerMember();
				memberController.registerMembership();
			}
			
			if(line.equals("3")) {
				loanController.registerLoan();
			}
			
		}
		controller.closeFactory();
	}
	
}
