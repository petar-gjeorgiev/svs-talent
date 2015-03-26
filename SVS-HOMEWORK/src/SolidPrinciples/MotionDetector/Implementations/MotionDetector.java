package SolidPrinciples.MotionDetector.Implementations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import SolidPrinciples.MotionDetector.Abstractions.AlarmChannel;
import SolidPrinciples.MotionDetector.Abstractions.ImageCapturingDevice;

public class MotionDetector {

	private List<AlarmChannel> alarms;

	private List<ImageCapturingDevice> images;

	public MotionDetector() {
		this.alarms = new ArrayList<AlarmChannel>();
		this.images = new ArrayList<ImageCapturingDevice>();
	}

	public void sendAlarm(AlarmChannel a) {
		alarms.add(a);
	}

	public boolean setAlarm() {
		if (images.size() > 1) {
			int size = images.size();
			if (!Arrays.equals(images.get(size - 2).getImage(),
					images.get(size - 1).getImage())) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	public void addImages(ImageCapturingDevice image) {
		images.add(image);
	}

	public void run(ImageCapturingDevice camera) {
		try {
			Thread.sleep(500);
			images.add(camera);
			if(camera.getImage() == null) {
				Thread.currentThread().interrupt();
				return;
			}
			if (setAlarm()) {
				Alarm a = new Alarm();
				AlarmChannel ac = new AlarmAdapter(a);
				ac.sendAlarm();
				sendAlarm(ac);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
