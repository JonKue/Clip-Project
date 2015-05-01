package com.example.clip;

public class VitalSign {
	// Data Members
	private double bodyTemperature;
	private int pulse;
	private int respirationRate;
	private int[] bloodPressure;
	/*private int[] pulseRateRange = new int[2];
	private int[] respirationRateRange = new int[2];
	private int[] bloodPressureRange = new int[2];*/

	
	
	public String getBodyTemperature() {
		String s;
		s = String.valueOf(this.bodyTemperature);
		return s;
	}


	public void setBodyTemperature(String string) {
		double bt = Double.parseDouble(string);
		this.bodyTemperature = bt;
	}

	public String getPulse() {
		String s;
		s = String.valueOf(this.pulse);
		return s;
	}

	public void setPulse(String string) {
		int p = Integer.parseInt(string);
		this.pulse = p;
	}

	
	public String getRespirationRate() {
		String s;
		s = String.valueOf(this.respirationRate);
		return s;
	}

	public void setRespirationRate(String string) {
		int rr = Integer.parseInt(string);
		this.respirationRate = rr;
	}

	
	
	public String[] getBloodPressure() {
		String s = String.valueOf(this.bloodPressure[0]);
		String d = String.valueOf(this.bloodPressure[1]);
		String[] bp = {s,d};
		return bp;
	}

	public void setBloodPressure(String[] string) {
		int [] bp = new int[2];
		bp[0] = Integer.parseInt(string[0]);
		bp[1] = Integer.parseInt(string[1]);
		this.bloodPressure = bp;
	}

	public VitalSign() {
		super();
		/*
		this.bodyTemperature = 0.0;
		this.pulse = 0;
		this.respirationRate = 0;
		this.bloodPressure = new int[2];
		this.bloodPressure[0] = 0;
		this.bloodPressure[1] = 0;
		*/
	}


	public VitalSign(double bodyTemperature, int pulse, int respirationRate,
			int[] bloodPressure) {
		super();
		this.bodyTemperature = bodyTemperature;
		this.pulse = pulse;
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
