package Concurrency.Stopwatch;

public class Stopwatch implements Runnable {

	private int startValue = 0;

	private boolean isPaused = false;

	private String stopped = "";

	@Override
	public void run() {
		while (!stopped.equals("stop")) {
			while (isPaused) {
				try {
					synchronized (this) {
						wait();
					}
				} catch (InterruptedException e) {
				}
			}
			startValue++;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			System.out.println(startValue);

		}
	}

	public void stop() {
		stopped = "stop";
	}

	public synchronized void resume() {
		isPaused = false;
	}

	public synchronized void pause() {
		isPaused = true;
	}

	public boolean isPaused() {
		return isPaused;
	}
}
