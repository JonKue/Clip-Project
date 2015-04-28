package com.example.clip;

import java.util.Date;

public class InterviewInfo {
	
	private Date date;
	private String outcome;
	private String lessonLearned;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getOutcome() {
		return outcome;
	}
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
	public String getLessonLearned() {
		return lessonLearned;
	}
	public void setLessonLearned(String lessonLearned) {
		this.lessonLearned = lessonLearned;
	}
	public InterviewInfo(Date date) {
		super();
		this.date = date;
	}
	
	
}
