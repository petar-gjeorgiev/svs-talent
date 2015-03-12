package Arrays;

public class YearlyCalendar {

	static final int YEAR = 2004;

	static final int[] MONTHS = fillMonths();

	public static void main(String[] args) {

		String[] s = isLeapYear(YEAR, 2) ? new String[366] : new String[365];

		fillArray(s, MONTHS, YEAR);

		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}

	}

	static int[] fillMonths() {

		int[] months = new int[12];

		for (int i = 0; i < 12; i++) {
			months[i] = i + 1;
		}
		return months;
	}

	static boolean isLeapYear(int year, int month) {
		return DayCounter.countDays(month, year) > 28;
	}

	static void fillArray(String[] s, int[] months, int year) {
		int dayCounter = 0;
		for (int i = 0; i < months.length; i++) {
			int days = DayCounter.countDays(months[i], year);
			for (int j = 0; j < days; j++) {
				s[dayCounter] = new Integer(j + 1).toString() + "/"
						+ new Integer(i + 1).toString() + "/"
						+ new Integer(year).toString();
				dayCounter++;
			}
		}
	}

}
