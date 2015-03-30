package com.ACME.classes;

import com.ACME.interfaces.ACMEHeater;
import com.ACME.interfaces.ACMEThermometer;
import com.ventoelectrics.waterheater.VentoPoweredDevice;
import com.ventoelectrics.waterheater.VentoThermoregulator;

public class EfficientThermoregulatorAdapter implements VentoThermoregulator,VentoPoweredDevice {

	private EfficientThermoregulator et;

	private ACMEThermometer thermometer;

	private ACMEHeater heater;

	public EfficientThermoregulatorAdapter(EfficientThermoregulator et,
			ACMEThermometer thermometer, ACMEHeater heater) {
		this.et = et;
		this.thermometer = thermometer;
		this.heater = heater;
	}

	public void enablePower() {
		et.enablePower();
	}

	public void disablePower() {
		et.enablePower();
	}

	public void setTemperature(Integer temperature) {
		et.setTemperature(temperature);
	}

	public Integer getThermometerTemperature() {
		return thermometer.getTemperature();
	}

	public ACMEHeater getACMEHeater() {
		return heater;
	}
}
