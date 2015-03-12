package ClassOrganisation;

import java.text.DecimalFormat;

public class ZipCode {

	private String zipCode;

	public ZipCode(int code) {
		Integer Code = new Integer(code);
		String s = Code.toString();

		if (s.length() != 5 && s.length() != 9) {
			DecimalFormat format = s.length() < 5 ? new DecimalFormat("00000")
					: new DecimalFormat("000000000");
			this.zipCode = format.format(code);

		} else {
			this.zipCode = s;
		}
	}

	public String getZipCode() {
		return zipCode;
	}

}
