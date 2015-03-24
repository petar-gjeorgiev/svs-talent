package com.ACME.classes;

public class StandardThermoregulator implements Runnable {
	
	private Integer currentTemperature;

	private boolean powerEnabled = false;
	
	public StandardThermoregulator() {
		currentTemperature = 0;
	}

	public void enablePower() {
		powerEnabled = true;
	}

	public void disablePower() {
		powerEnabled = false;
	}

	public void isEnabled() {
		if(powerEnabled) {
			System.out.println("Standard Thermoregulator enabled");
		}
		else {
			System.out.println("Standard Thermoregulator disabled");
		}
	}
	
	public void setTemperature(Integer temp) {
		currentTemperature = temp;
	}

	public Integer getCurrentTemperature() {
		return currentTemperature;
	}
	
	@Override
	public void run() {

		try {
			while (true) {
				Thread.sleep(3000);
				System.out.println("Proba");
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}



}
