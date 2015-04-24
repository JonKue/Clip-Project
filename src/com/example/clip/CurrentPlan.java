package com.example.clip;

import java.util.ArrayList;
import java.util.Calendar;

public class CurrentPlan extends EducationPlan{
	// Data Members
	private int tuition;
	private ArrayList<Course> coursePlanList;	// May change this to a class (create Course)
	

	private Calendar dateStarted;
	private Calendar dateGraduating;
	
	public int getTuition() {
		return tuition;
	}
	public void setTuition(int tuition) {
		this.tuition = tuition;
	}
	
	public ArrayList<Course> getCoursePlanList() {
		return coursePlanList;
	}
	public void setCoursePlanList(ArrayList<Course> coursePlanList) {
		this.coursePlanList = coursePlanList;
	}
	public Calendar getDateStarted() {
		return dateStarted;
	}
	public void setDateStarted(Calendar dateStarted) {
		this.dateStarted = dateStarted;
	}
	public Calendar getDateGraduating() {
		return dateGraduating;
	}
	public void setDateGraduating(Calendar dateGraduating) {
		this.dateGraduating = dateGraduating;
	}
	
	// Constructor using super class
	public CurrentPlan(Institution school, DegreeType degree) {
		super(school, degree);
		// TODO Auto-generated constructor stub
		this.coursePlanList = new ArrayList<Course>();
	}
	
	// Method to add courses to planner
	public void addCourses(Course course){
		ArrayList <Course> currCourseList = this.getCoursePlanList();
		currCourseList.add(course);
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
