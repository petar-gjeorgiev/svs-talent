package com.ACME.classes;

import com.ACME.interfaces.ACMEThermoregulator;

public class EfficientThermoregulatorAdapter implements ACMEThermoregulator {

	private EfficientThermoregulator et;
	
	public EfficientThermoregulatorAdapter(EfficientThermoregulator et) {
		this.et = et;
	}

	@Override
	public void enablePower() {
		et.enablePower();
	}

	@Override
	public void disablePower() {
		et.enablePower();
	}

	@Override
	public void setTemperature(Integer temperature) {
		et.setTemperature(temperature);
	}

}
