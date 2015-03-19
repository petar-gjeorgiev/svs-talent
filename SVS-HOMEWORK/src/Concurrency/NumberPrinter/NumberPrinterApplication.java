package Concurrency.NumberPrinter;

public class NumberPrinterApplication {

	public static void main(String[] args) throws InterruptedException {

		int number = Integer.parseInt(args[0]);
		long time = Long.parseLong(args[1]); // time in mils from command line

		NumberPrinter printer = new NumberPrinter(number);
		Thread t = new Thread(printer);
		
		t.start();
		t.join(time);
		t.interrupt();
	}

}
