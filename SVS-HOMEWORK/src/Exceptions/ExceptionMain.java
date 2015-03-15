package Exceptions;

public class ExceptionMain {

	public static void main(String[] args) {

		try {
			ZipCode code = new ZipCode(1234);
			System.out.println(code.getZipCode());
		} catch (NumberException e) {
			System.err.println(e.getMessage());
		}

	}
}
