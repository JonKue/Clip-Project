package com.example.example;

/*
 import java.text.ParseException;
 import java.text.SimpleDateFormat;
 import java.util.Date;

 import android.text.format.Formatter;*/

public class Medication {
    // Data Members
    private final int _id;
    private String pillName;
    private String noOfDosage;
    private String dateStarted;
    private String dateEnded;
    boolean setReminder;

	/*
	 * SimpleDateFormat dateFormat1 = new SimpleDateFormat("mmm d, yyyy");
	 * SimpleDateFormat dateFormat2 = new SimpleDateFormat("mm/dd/yyyy");
	 */

    public String getPillName() {
        return pillName;
    }

    public int get_id() {
        return _id;
    }

    public void setPillName(String pillName) {
        this.pillName = pillName;
    }



    public String getNoOfDosage() {
        return noOfDosage;
    }

    public void setNoOfDosage(String noOfDosage) {
        this.noOfDosage = noOfDosage;
    }

    public String getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(String dateStarted) {
        this.dateStarted = dateStarted;
    }

    public String getDateEnded() {
        return dateEnded;
    }

    public void setDateEnded(String dateEnded) {
        this.dateEnded = dateEnded;
    }

    public boolean isSetReminder() {
        return setReminder;
    }

    public void setSetReminder(boolean setReminder) {
        this.setReminder = setReminder;
    }

    public Medication(int _id) {
        super();
        this._id = _id;
    }

}
