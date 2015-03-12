package WorkingWithObjects;

import java.util.StringTokenizer;

public class DateParser {

	public static void main(String[] args) {

		String s = new String("11/25/1992");

		StringTokenizer st = new StringTokenizer(s, "/");

		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}

		// Other way
		System.out.println("\nOther way\n");

		String[] elements = s.split("/");

		for (int i = 0; i < elements.length; i++) {
			System.out.println(elements[i]);
		}

	}

}
