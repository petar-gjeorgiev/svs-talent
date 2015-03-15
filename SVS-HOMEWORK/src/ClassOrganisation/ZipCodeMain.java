package ClassOrganisation;

public class ZipCodeMain {

	public static void main(String[] args) {

		ZipCode zipCode = new ZipCode(1234);
		System.out.println(zipCode.getZipCode());

		ZipCode code = new ZipCode(12345);
		System.out.println(code.getZipCode());
	}

}
