package com.Seavus.Library.UI.Impl;

import java.util.Calendar;
import java.util.Scanner;

import com.Seavus.Library.Model.Member;
import com.Seavus.Library.Model.Membership;
import com.Seavus.Library.UI.MemberInput;

public class MemberInputImpl implements MemberInput {

	public Member RegisterInput() {
		StringBuilder sb = new StringBuilder();
		sb.append("Insert new member\n");
		System.out.println(sb.toString());

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int counter = 0;
		Member member = new Member();

		while (counter < 2) {
			if (counter == 0) {
				System.out.println("Name:");
				member.setName(scanner.nextLine());
			}
			if (counter == 1) {
				System.out.println("email:");
				member.setEmail(scanner.nextLine());
			}
			counter++;
		}

		return member;
	}

	public Membership RegisterMembership(Member m) {
		StringBuilder sb = new StringBuilder();
		sb.append("Insert new membership\n");
		System.out.println(sb.toString());

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int counter = 0;
		Membership membership = new Membership();
		membership.setMember(m);
		
		while (counter < 3) {
			if (counter == 0) {
				System.out.println("Type:");
				membership.setMembershipType(scanner.nextLine());
			}
			if (counter == 1) {
				System.out.println("Start date: - format dd:mm:yyyy");
				String [] el = scanner.nextLine().split(":");
				int d = Integer.parseInt(el[0]);
				int m1 = Integer.parseInt(el[1]);
				int y = Integer.parseInt(el[2]);
				Calendar cal = Calendar.getInstance();
				cal.set(y, m1, d);
				membership.setStartDate(cal.getTime());
			}
			if(counter == 2) {
				System.out.println("End date: - format dd:mm:yyyy");
				String [] el = scanner.nextLine().split(":");
				int d = Integer.parseInt(el[0]);
				int m1 = Integer.parseInt(el[1]);
				int y = Integer.parseInt(el[2]);
				Calendar cal = Calendar.getInstance();
				cal.set(y, m1, d);
				membership.setEndDate(cal.getTime());
			}
			counter++;
		}

		return membership;
	}

}
