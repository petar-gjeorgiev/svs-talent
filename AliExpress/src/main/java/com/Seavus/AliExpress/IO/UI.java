package com.Seavus.AliExpress.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UI {

	private Scanner input;

	public UI() {
		input = new Scanner(System.in);
	}

	public UI(File file) {
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Scanner getInput() {
		return input;
	}

	public void setInput(Scanner input) {
		this.input = input;
	}

}
