package com.ventoelectrics.waterheater;

import com.ACME.interfaces.HeaterInterface;

public class VentoHeater implements VentoPoweredDevice,HeaterInterface {
	
	private boolean powerEnabled = false;
	
	@Override
	public void enablePower() {
		powerEnabled = true;
	}

	@Override
	public void disablePower() {
		powerEnabled = false;
	}
	
	public void enable() {
		if (!powerEnabled) {
			throw new NoPowerException();
		}
		System.out.println("VentoHeater.enable()");
	}
	
	public void disable() {
		System.out.println("VentoHeater.disable()");
	}
}
