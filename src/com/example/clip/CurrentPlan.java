package com.example.clip;

import java.util.ArrayList;
import java.util.Calendar;

public class CurrentPlan extends EducationPlan{
	// Data Members
	private int tuition;
	private String coursePlanList;	// May change this to a class (create Course)
	

	private String dateStarted;
	private String dateGraduating;
	
	public int getTuition() {
		return tuition;
	}
	public void setTuition(int tuition) {
		this.tuition = tuition;
	}
	
	public String getCoursePlan() {
		return coursePlanList;
	}
	public void setCoursePlanList(String coursePlanList) {
		this.coursePlanList = coursePlanList;
	}
	public String getDateStarted() {
		return dateStarted;
	}
	public void setDateStarted(String dateStarted) {
		this.dateStarted = dateStarted;
	}
	public String getDateGraduating() {
		return dateGraduating;
	}
	public void setDateGraduating(String dateGraduating) {
		this.dateGraduating = dateGraduating;
	}
	
	// Constructor using super class
	public CurrentPlan(Institution school, DegreeType degree) {
		super(school, degree);
		// TODO Auto-generated constructor stub
	}
	
	// Method to add courses to planner
	public void addCourses(Course course){
		String currCourseList = this.getCoursePlan();
		this.setCoursePlanList(currCourseList);
	}
	
	
	/* may not be required
	// Method to change School
	public void changeSchool(){
		
	}
	
	// Method to change Degree
	public void changeDegree(){
		
	}
	
	// Method to change Program
	public void changeProgram(){
		
	}
	*/
}
