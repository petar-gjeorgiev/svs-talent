package com.ventoelectrics.waterheater;

import java.util.Random;

import com.ACME.interfaces.ACMEThermometer;

public class VentoThermometer implements VentoPoweredDevice,ACMEThermometer {
	
	private boolean powerEnabled = false;
	private Random random = new Random(System.currentTimeMillis());

	public Integer getTemperature() {
		if (!powerEnabled) {
			throw new NoPowerException();
		}
		return random.nextInt(60);
	}

	@Override
	public void enablePower() {
		powerEnabled = true;
	}

	@Override
	public void disablePower() {
		powerEnabled = false;
	}
	
	
}
