package com.Seavus.Library.UI.Impl;

import com.Seavus.Library.UI.AppInfoUI;

public class AppInfoImpl implements AppInfoUI {

	public void AppInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("Welcome to the Library Application\n");
		sb.append("This is the main menu\n");
		sb.append("1 - Publications\n");
		sb.append("2 - Add Member\n");
		sb.append("end - Terminate app");
		System.out.println(sb.toString());
	}

	public void subMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("Welcome to the Library Application\n");
		sb.append("This is the main menu\n");
		sb.append("1 - Publications\n");
		sb.append("end - Terminate app");
		System.out.println(sb.toString());
	}
	
}
