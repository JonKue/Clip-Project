package com.example.example;

public class VitalSign {
    // Data Members
    private double bodyTemperature;
    private int pulse;
    private int respirationRate;
    private int[] bloodPressure;
    /*private int[] pulseRateRange = new int[2];
	private int[] respirationRateRange = new int[2];
	private int[] bloodPressureRange = new int[2];*/


    public VitalSign() {

        this.bodyTemperature = -1.0;
        this.pulse = -1;
        this.respirationRate = -1;
        this.bloodPressure = new int[2];
        this.bloodPressure[0] = -1;
        this.bloodPressure[1] = -1;
    }


    public VitalSign(double bodyTemperature, int pulse, int respirationRate,
                     int[] bloodPressure) {
        super();
        this.bodyTemperature = bodyTemperature;
        this.pulse = pulse;
        this.respirationRate = respirationRate;
        this.bloodPressure = bloodPressure;
    }

    public String getBodyTemperature() {
        String s;
        s = String.valueOf(this.bodyTemperature);
        return s;
    }

    public void setBodyTemperature(String string) {
        this.bodyTemperature = Double.parseDouble(string);
    }

    public String getPulse() {
        String s;
        s = String.valueOf(this.pulse);
        return s;
    }

    public void setPulse(String string) {
        this.pulse = Integer.parseInt(string);
    }

    public String getRespirationRate() {
        String s;
        s = String.valueOf(this.respirationRate);
        return s;
    }

    public void setRespirationRate(String string) {
        this.respirationRate = Integer.parseInt(string);
    }

    public String[] getBloodPressure() {
        String s = String.valueOf(this.bloodPressure[0]);
        String d = String.valueOf(this.bloodPressure[1]);
        return new String[]{s, d};
    }

    public void setBloodPressure(String[] string) {
        int[] bp = new int[2];
        bp[0] = Integer.parseInt(string[0]);
        bp[1] = Integer.parseInt(string[1]);
        this.bloodPressure = bp;
    }
	
}
