package SolidPrinciples.MotionDetector.Implementations;

import java.util.Scanner;
import SolidPrinciples.MotionDetector.Abstractions.ImageCapturingDevice;

public class MotionDetectorApplication {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		MotionDetector detector = new MotionDetector();
		String line = "";

		while (scanner.hasNext()) {
			line = scanner.next();
			byte [] img;
			if(line.equals("esc")) {
				img = null;
			}
			else {
				img = line.getBytes();
			}
			
			if(Thread.interrupted()) {
				break;
			}
			
			Image image = new Image();
			ImageCapturingDevice camera = new ImageAdapter(image);
			camera.captureImage(img);
			detector.run(camera);
		}

	}
}
