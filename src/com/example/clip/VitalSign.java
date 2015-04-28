package com.example.clip;

public class VitalSign {
	// Data Members
	//final int _id;
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
/*
	public int get_id() {
		return _id;
	}
*/
	public void setBodyTemperature(String string) {
		int bt = Integer.parseInt(string);
		this.bodyTemperature = bt;
	}

	public int getPulse() {
		return pulse;
	}

	public void setPulse(String string) {
		int p = Integer.parseInt(string);
		this.pulse = p;
	}

	
	public int getRespirationRate() {
		return respirationRate;
	}

	public void setRespirationRate(String string) {
		int rr = Integer.parseInt(string);
		this.respirationRate = rr;
	}

	
	
	public int[] getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(String[] string) {
		int [] bp = new int[2];
		bp[0] = Integer.parseInt(string[0]);
		bp[1] = Integer.parseInt(string[1]);
		this.bloodPressure = bp;
	}

	public VitalSign() {
		super();
		//this._id = _id;
		this.bodyTemperature = 0;
		this.pulse = 0;
		this.respirationRate = 0;
		this.bloodPressure = new int[2];
		this.bloodPressure[0] = 0;
		this.bloodPressure[1] = 0;
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
