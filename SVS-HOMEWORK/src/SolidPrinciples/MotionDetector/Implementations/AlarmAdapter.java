package SolidPrinciples.MotionDetector.Implementations;

import SolidPrinciples.MotionDetector.Abstractions.AlarmChannel;

public class AlarmAdapter implements AlarmChannel {

	private Alarm alarm;
	
	public AlarmAdapter(Alarm alarm) {
		this.alarm = alarm;
	}

	@Override
	public void sendAlarm() {
		alarm.sendAlarm();
	}

}
