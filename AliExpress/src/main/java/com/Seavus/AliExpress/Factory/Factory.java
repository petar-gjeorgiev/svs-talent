package com.Seavus.AliExpress.Factory;

import java.util.Scanner;

import com.Seavus.AliExpress.ShoppingBasket;
import com.Seavus.AliExpress.Warehouse;

public class Factory {

	public static Warehouse getWarehouseInstance () {
		return new Warehouse();
	}

	public static ShoppingBasket getBasketInstance() {
		return new ShoppingBasket();
	}
	
	public static Scanner scanner() {
		return new Scanner(System.in);
	}
}
