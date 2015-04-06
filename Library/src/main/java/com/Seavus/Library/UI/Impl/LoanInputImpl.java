package com.Seavus.Library.UI.Impl;

import java.util.Calendar;
import java.util.Scanner;

import com.Seavus.Library.Model.Loan;
import com.Seavus.Library.Model.Member;
import com.Seavus.Library.Model.Publication;
import com.Seavus.Library.Service.HibernateMemberService;
import com.Seavus.Library.Service.HibernatePublicationService;
import com.Seavus.Library.UI.LoanInputUI;

public class LoanInputImpl implements LoanInputUI {

	public Loan registerLoan(HibernatePublicationService publicationService,HibernateMemberService memberService) {
		StringBuilder sb = new StringBuilder();
		sb.append("Insert new loan\n");
		System.out.println(sb.toString());

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int counter = 0;
		Loan loan = new Loan();
		Member member = new Member();

		while (counter < 5) {

			if (counter == 0) {
				System.out.println("Start date: - format dd:mm:yyyy");
				String[] el = scanner.nextLine().split(":");
				int d = Integer.parseInt(el[0]);
				int m1 = Integer.parseInt(el[1]);
				int y = Integer.parseInt(el[2]);
				Calendar cal = Calendar.getInstance();
				cal.set(y, m1, d);
				loan.setStartDate(cal.getTime());
			}

			if (counter == 1) {
				System.out.println("End date: - format dd:mm:yyyy");
				String[] el = scanner.nextLine().split(":");
				int d = Integer.parseInt(el[0]);
				int m1 = Integer.parseInt(el[1]);
				int y = Integer.parseInt(el[2]);
				Calendar cal = Calendar.getInstance();
				cal.set(y, m1, d);
				loan.setEndDate(cal.getTime());
			}

			if (counter == 3) {
				System.out.println("Insert member id: ");
				Long id = Long.parseLong(scanner.nextLine());
				member = memberService.getMemberById(id);
				loan.setMember(member);
			}

			if (counter == 4) {
				System.out.println("Insert publication id: ");
				Long id = Long.parseLong(scanner.nextLine());
				Publication publication = publicationService
						.getPublicationById(id);
				loan.setPublication(publication);
			}
			counter++;
		}

		return loan;
	}

}
