package ClassesAndMethods;

public class Numbers {

	public static void main(String[] args) {

		int sum = 0;
		int j = 1;

		for (int i = args.length - 1; i >= 0; i--) {
			sum += ConvertWord(args[i]) * j;
			j *= 10;
		}

		System.out.println(sum);
	}

	public static int ConvertWord(String s) {

		switch (s) {
		case "zero":
			return 0;
		case "one":
			return 1;
		case "two":
			return 2;
		case "three":
			return 3;
		case "four":
			return 4;
		case "five":
			return 5;
		case "six":
			return 6;
		case "seven":
			return 7;
		case "eight":
			return 8;
		case "nine":
			return 9;
		default:
			return -1;
		}

	}

}
