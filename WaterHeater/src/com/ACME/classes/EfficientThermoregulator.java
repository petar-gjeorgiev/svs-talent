package com.ACME.classes;

import com.ventoelectrics.waterheater.NoPowerException;

public class EfficientThermoregulator {
	
	private boolean powerEnabled = false;
	private Integer configuredTemp;
	
	public void enablePower() {
		powerEnabled = true;
	}

	public void disablePower() {
		powerEnabled = false;
	}

	public void setTemperature(Integer temperature) throws NoPowerException  {
		if(!powerEnabled) {
			throw new NoPowerException();
		}
		this.configuredTemp = temperature;
	}

	public Integer getConfiguredTemp() {
		return configuredTemp;
	}
	
}
