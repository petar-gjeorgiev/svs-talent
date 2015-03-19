package Concurrency.NumberPrinter;

public class NumberPrinter implements Runnable {

	private int numberTo;

	public NumberPrinter(int numberTo) {
		this.numberTo = numberTo;
	}

	@Override
	public void run() {
		for (int i = 1; i <= numberTo; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
			System.out.println(String.valueOf(i));
		}
	}

}
