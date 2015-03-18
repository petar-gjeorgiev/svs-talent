package Concurrency;


public class NumberPrinter {

	public static void main(String[] args) throws InterruptedException {

		int to = Integer.parseInt(args[0]);
		float timeInterval = Float.parseFloat(args[1]);
		long time =  (long) (timeInterval*1000);
		
		final Numbers numbers = new Numbers(to);
		Thread t = new Thread(numbers);
		
		
		t.start();
		Thread.sleep(time);
		t.interrupt();
	}

	
	public static class Numbers implements Runnable {

		public int to;
		
		public Numbers(int to) {
			this.to = to;
		}

		@Override
		public void run() {
			for(int i=1;i<=to;i++) {
				if(Thread.interrupted()) {
					System.out.println("Interrupted\n");
					return;
				}
				System.out.println(i);
			}
		}
		
	}
}
