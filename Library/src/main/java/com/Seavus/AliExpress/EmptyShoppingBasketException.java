package com.Seavus.AliExpress;

public class EmptyShoppingBasketException extends Exception {

	private static final long serialVersionUID = 1L;

	public EmptyShoppingBasketException(String message) {
		super(message);
	}
}
