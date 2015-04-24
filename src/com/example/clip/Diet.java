package com.example.clip;

import java.util.Date;

public class Diet {
	// Date Members
	private String dietType;
	private Date startDate;
	private Date endDate;
	private String otherInfo;
	
	public String getDietType() {
		return dietType;
	}
	public void setDietType(String dietType) {
		this.dietType = dietType;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public String getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
	public Diet(String dietType) {
		super();
		this.dietType = dietType;
	}
	
	
}
