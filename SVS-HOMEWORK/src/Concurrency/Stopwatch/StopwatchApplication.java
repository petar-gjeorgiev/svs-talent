package Concurrency.Stopwatch;

import java.util.Scanner;

public class StopwatchApplication {
	
	public static void main(String[] args) throws InterruptedException {
		Stopwatch stopwatch = new Stopwatch();
		Thread w1 = new Thread(stopwatch);
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		String command;
		while(!(command=scanner.nextLine()).equals("stop")) {
			if(command.equals("start")) {
				w1.start();
			}
			if(command.equals("pause")) {
				stopwatch.pause();
			}
			if(command.equals("resume")) {
				stopwatch.resume();
				synchronized (stopwatch) {
					stopwatch.notify();
				}
			}
		}
		
		stopwatch.stop();
	}

}
