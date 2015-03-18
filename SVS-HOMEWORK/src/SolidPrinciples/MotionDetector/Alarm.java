package SolidPrinciples.MotionDetector;

import java.util.Arrays;
import java.util.List;

public class Alarm implements AlarmChannel {

	@Override
	public void notify(ImageCapturingDevice device) {

		List<byte[]> images = device.getAllImages();
		boolean changes = false;

		for (int i = 0; i < images.size() - 1; i++) {
			if (!Arrays.equals(images.get(i), images.get(i + 1))) {
				changes = true;
				break;
			}
		}

		if (changes) {
			System.out.println("Alarm.");
		}
	}

}
