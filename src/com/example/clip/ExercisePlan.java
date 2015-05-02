package com.example.clip;

import android.text.format.Time;

public class ExercisePlan {
	// Date Members
	private final int _id;
	private String exerciseName;
	private String routine;
	private String startTime;
	private String endTime;
	private String otherInfo;
	private boolean setReminder;
	
	
	public ExercisePlan(int _id) {
		super();
		this._id = _id;
	}
	public int get_id() {
		return _id;
	}
	public String getExerciseName() {
		return exerciseName;
	}
	public void setExerciseName(String exerciseDescription) {
		this.exerciseName = exerciseDescription;
	}
	
	public String getRoutine() {
		return routine;
	}
	public void setRoutine(String routine) {
		this.routine = routine;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public boolean isSetReminder() {
		return setReminder;
	}
	public void setSetReminder(boolean setReminder) {
		this.setReminder = setReminder;
	}
	
	public String getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
	
	
}
