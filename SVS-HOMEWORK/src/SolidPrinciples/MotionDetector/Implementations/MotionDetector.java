package SolidPrinciples.MotionDetector.Implementations;

import java.util.ArrayList;
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

	public void sendAlarm(Alarm a) {
		if(images.size()>1) {
			for(int i=0;i<images.size()-1;i++) {
				byte [] predecessor = images.get(i).getImage();
				byte [] follower = images.get(++i).getImage();
				if(!predecessor.toString().equals(follower.toString())) {
					alarms.add(new AlarmAdapter(a));
				}
			}
		}
		
	}
	
	
}
