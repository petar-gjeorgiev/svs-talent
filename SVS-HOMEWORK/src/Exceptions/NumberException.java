package Exceptions;

public class NumberException extends Exception {

	private static final long serialVersionUID = 1L;
	public String message;

	public NumberException(String message) {
		super(message);
	}
}
