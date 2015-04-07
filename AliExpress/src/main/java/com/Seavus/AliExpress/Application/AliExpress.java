package com.Seavus.AliExpress.Application;

import java.util.Scanner;

import com.Seavus.AliExpress.ShoppingBasket;
import com.Seavus.AliExpress.Warehouse;
import com.Seavus.AliExpress.Exceptions.EmptyShoppingBasketException;
import com.Seavus.AliExpress.Exceptions.InvalidInputException;
import com.Seavus.AliExpress.Exceptions.InvalidProductException;
import com.Seavus.AliExpress.Exceptions.QuantityException;
import com.Seavus.AliExpress.Factory.Factory;
import com.Seavus.AliExpress.UI.AppInfo;

public class AliExpress {

	public static Scanner scanner;
	public static Warehouse warehouse = Factory.getWarehouseInstance();
	public static ShoppingBasket shoppingBasket = Factory.getBasketInstance();

	public static void main(String[] args) {

		Warehouse.fillWarehouse(warehouse);

		AppInfo.appInfo();

		scanner = new Scanner(System.in);

		try {
			AppInfo.listProducts(scanner, warehouse);
			AppInfo.addProductInBasketInfo();
			scanner = new Scanner(System.in);
			AppInfo.addProductsToBasket(scanner, shoppingBasket, warehouse);
			shoppingBasket.ListAllProducts();
		} catch (InvalidInputException e) {
			System.err.println(e.getMessage());
		} catch (QuantityException | InvalidProductException e) {
			System.err.println(e.getMessage());
		} catch (EmptyShoppingBasketException e) {
			System.err.println(e.getMessage());
		}

	}




}
