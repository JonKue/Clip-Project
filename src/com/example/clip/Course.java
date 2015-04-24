package com.example.clip;

public class Course {
	// Data Members
	private CourseAbbreviation courseAbb;
	private int courseNum;
	private String courseName;
	private String courseDescription;
	private String otherCourseInfo;
	public CourseAbbreviation getCourseAbb() {
		return courseAbb;
	}
	public void setCourseAbb(CourseAbbreviation courseAbb) {
		this.courseAbb = courseAbb;
	}
	public int getCourseNum() {
		return courseNum;
	}
	public void setCourseNum(int courseNum) {
		this.courseNum = courseNum;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public String getOtherCourseInfo() {
		return otherCourseInfo;
	}
	public void setOtherCourseInfo(String otherCourseInfo) {
		this.otherCourseInfo = otherCourseInfo;
	}
	
	// Constructor with course abbreviation and course number
	public Course(CourseAbbreviation courseAbb, int courseNum) {
		super();
		this.courseAbb = courseAbb;
		this.courseNum = courseNum;
	}
	
	@Override
	public String toString() {
		return "" + courseAbb + " " + courseNum;
	}
	
	
	
	
}
