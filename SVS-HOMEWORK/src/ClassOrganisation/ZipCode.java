package ClassOrganisation;

public class ZipCode {

	private int zipCode;

	public ZipCode(int value) {

		Integer number = new Integer(value);

		String s = number.toString();

		if (s.length() == 9 || s.length() == 5) {
			this.zipCode = value;
		} 
	}

	public int getZipCode() {
		return zipCode;
	}

}
