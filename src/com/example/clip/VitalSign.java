package com.example.clip;

public class VitalSign {
	// Data Members
	private int bodyTemperature;
	private int pulse;
	private int respirationRate;
	private int[] bloodPressure;
	/*private int[] pulseRateRange = new int[2];
	private int[] respirationRateRange = new int[2];
	private int[] bloodPressureRange = new int[2];*/

	
	public int getBodyTemperature() {
		return bodyTemperature;
	}

	public void setBodyTemperature(int bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
	}

	public int getPulse() {
		return pulse;
	}

	public void setPulse(int pulse) {
		this.pulse = pulse;
	}

	
	public int getRespirationRate() {
		return respirationRate;
	}

	public void setRespirationRate(int respirationRate) {
		this.respirationRate = respirationRate;
	}

	

	

	
	public int[] getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(int[] bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public VitalSign(int bodyTemperature, int pulseRate, int respirationRate, int[] bloodPressure) {
		super();
		this.bodyTemperature = bodyTemperature;
		this.pulse = pulseRate;
		this.respirationRate = respirationRate;
		this.bloodPressure = bloodPressure;
	}

	/*
	public boolean isNormal (){
		if ((this.getPulse() > this.getPulseRateRange()[0]) && (this.getPulse() < this.getPulseRateRange()[1])
				&& (this.getRespirationRate() > this.getRespirationRateRange()[0]) && (this.getRespirationRate() < this.getRespirationRateRange()[1])
				&& (this.getBloodPressure() > this.getBloodPressureRange()[0]) && (this.getBloodPressure() < this.getBloodPressureRange()[1]))
			return true;
		else 
			return false;
	}*/
	

}
