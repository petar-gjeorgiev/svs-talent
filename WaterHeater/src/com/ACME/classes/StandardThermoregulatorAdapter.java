package com.ACME.classes;

import com.ACME.interfaces.ACMEThermoregulator;
import com.ACME.interfaces.ACMEHeater;
import com.ventoelectrics.waterheater.VentoHeater;
import com.ventoelectrics.waterheater.VentoThermometer;
import com.ventoelectrics.waterheater.VentoThermoregulator;

public class StandardThermoregulatorAdapter implements ACMEThermoregulator,VentoThermoregulator {

	private StandardThermoregulator t;
	
	private ACMEHeater vh;
	
	public StandardThermoregulatorAdapter(VentoHeater vh,VentoThermometer vt) {
		t = new StandardThermoregulator();
		this.vh = vh;
		t.setTemperature(vt.getTemperature());
	}

	@Override
	public void enablePower() {
		t.enablePower();
	}

	@Override
	public void disablePower() {
		t.disablePower();
	}

	@Override
	public void setTemperature(Integer temp) {
		t.setTemperature(temp);
	}

	public ACMEHeater getVh() {
		return vh;
	}

}
