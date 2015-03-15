package Exceptions;

public class ZipCode {

	private int zipCode;

	public ZipCode(int value) throws NumberException {

		Integer number = new Integer(value);

		String s = number.toString();

		if (s.length() != 5 && s.length() != 9) {
			throw new NumberException(
					"Invalid zipCode! Zip code must be 5 or 9 digit value.");
		} else {
			this.zipCode = value;
		}
	}

	public int getZipCode() {
		return zipCode;
	}

}
