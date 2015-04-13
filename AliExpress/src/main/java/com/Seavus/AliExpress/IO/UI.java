package com.Seavus.AliExpress.IO;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UI {

	
	private Scanner input;

	public UI() {
		
	}
	
	@Autowired
	public UI(Scanner scanner) {
		input = scanner;
	}

	public Scanner getInput() {
		return input;
	}

	public void setInput(Scanner input) {
		this.input = input;
	}

}
