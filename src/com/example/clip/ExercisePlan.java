package com.example.clip;

import android.text.format.Time;

public class ExercisePlan {
	// Date Members
	private String exerciseName;
	private Routine routine;
	private Time startTime;
	private Time endTime;
	private String otherInfo;
	private boolean setReminder;
	public String getExerciseName() {
		return exerciseName;
	}
	public void setExerciseName(String exerciseDescription) {
		this.exerciseName = exerciseDescription;
	}
	public Routine getRoutine() {
		return routine;
	}
	public void setRoutine(Routine routine) {
		this.routine = routine;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
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
	public ExercisePlan(String exerciseName) {
		super();
		this.exerciseName = exerciseName;
	}
	
	
}
