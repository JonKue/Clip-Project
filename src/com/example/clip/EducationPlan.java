package com.example.clip;

public abstract class EducationPlan {
	private Institution school;
	private DegreeType degree;
	private String program;		// Check to consider Enum type if possible
	private EnrollmentStatus enrollmentStatus;
	public Institution getSchool() {
		return school;
	}
	public void setSchool(Institution school) {
		this.school = school;
	}
	public DegreeType getDegree() {
		return degree;
	}
	public void setDegree(DegreeType degree) {
		this.degree = degree;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public EnrollmentStatus getEnrollmentStatus() {
		return enrollmentStatus;
	}
	public void setEnrollmentStatus(EnrollmentStatus enrollmentStatus) {
		this.enrollmentStatus = enrollmentStatus;
	}
	
	// Constructor with school and degree
	public EducationPlan(Institution school, DegreeType degree) {
		super();
		this.school = school;
		this.degree = degree;
	}

}
