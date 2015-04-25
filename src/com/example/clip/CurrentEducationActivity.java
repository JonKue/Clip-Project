package com.example.clip;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CurrentEducationActivity extends Activity {
	Button enter;
	TextView label;
	ArrayList<CurrentPlan> plan;
	
	String schoolName;
	String degreeType;
	String program;
	String enrollment;
	String dateStart;
	String dateGrad;
	String tuition;
	String course;
	
	@Override
	protected void onCreate(Bundle noneState) {
		// TODO Auto-generated method stub
		super.onCreate(noneState);
		
		
		plan = new ArrayList();
		
		
		//get information from add current education
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
				    schoolName = extras.getString("schoolName");
				    degreeType = extras.getString("degreeType");
				    program = extras.getString("program");
				    enrollment = extras.getString("enrollment");
				    dateStart = extras.getString("dateStart");
				    dateGrad = extras.getString("dateGrad");
				    tuition = extras.getString("tuition");
				    course = extras.getString("course");
				    
				    //default value for enrollment status is none
				    EnrollmentStatus status = EnrollmentStatus.NONE;
				    
				    if(enrollment.equalsIgnoreCase("FULLTIME"))
				    {
				    	status = EnrollmentStatus.FULLTIME;
				    }
				    else if(enrollment.equalsIgnoreCase("FULLTIME"))
				    {
				    	status = EnrollmentStatus.PARTTIME;
				    }
				    
				    //default value for degree type is diploma
				    DegreeType degree = DegreeType.DIPLOMA;
				    
				    if(degreeType.equalsIgnoreCase("ASSOCIATE"))
				    {
				    	degree = DegreeType.ASSOCIATE;
				    }
				    else if(degreeType.equalsIgnoreCase("BACHELOR"))
				    {
				    	degree = DegreeType.BACHELOR;
				    }
				    else if(degreeType.equalsIgnoreCase("MASTER"))
				    {
				    	degree = DegreeType.MASTER;
				    }
				    else if(degreeType.equalsIgnoreCase("PHD"))
				    {
				    	degree = DegreeType.PHD;
				    }
				    
				    plan.add(new CurrentPlan(new Institution(schoolName), degree));
				    
				    //set information for current education at the end of the array list
				    plan.get(plan.size()-1).setDegree(degree);
				    plan.get(plan.size()-1).setProgram(program);
				    plan.get(plan.size()-1).setEnrollmentStatus(status);
				    plan.get(plan.size()-1).setTuition(Integer.parseInt(tuition));
				    plan.get(plan.size()-1).setCoursePlanList(course);
				    plan.get(plan.size()-1).setDateStarted(dateStart);
				    plan.get(plan.size()-1).setDateGraduating(dateGrad);
				    
					
			}
			setContentView(R.layout.activity_none);

			enter = (Button) findViewById(R.id.bEnter);
			label = (TextView) findViewById(R.id.tvNone);
			enter.setText("Add");
			label.setText("Current Education");
			
			//for dynamic update of GUI
			LinearLayout ll = (LinearLayout)findViewById(R.id.NoneLayout);
			
	
			//dynamically add buttons
			Button[] tv = new Button[plan.size()];
			for(int i=0;i<plan.size();i++){          
				final int index = i;
			    tv[i] = new Button(getApplicationContext());
			    tv[i].setText(plan.get(i).getSchool().getSchoolName().toString());
			    tv[i].setTextSize(20);
			    tv[i].setPadding(15, 5, 15, 5);     
			    tv[i].setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						Intent j = new Intent(CurrentEducationActivity.this, DisplayCurrentEducationActivity.class);
						j.putExtra("schoolName", plan.get(index).getSchool().getSchoolName());
						j.putExtra("degreeType", plan.get(index).getDegree().toString());
						j.putExtra("program", plan.get(index).getProgram());
						j.putExtra("enrollment", plan.get(index).getEnrollmentStatus().toString());
						j.putExtra("tuition", String.valueOf(plan.get(index).getTuition()));
						j.putExtra("course", plan.get(index).getCoursePlan());
						j.putExtra("dateStart", plan.get(index).getDateStarted() );
						j.putExtra("dateGrad", plan.get(index).getDateGraduating());
						startActivity(j);
					}
			    });
			    ll.addView(tv[i]);    
			    
			}
			
			//displays a text view when user hasn't entered any current education
			if(plan.size() == 0)
			{
				TextView none;
				none = new TextView(getApplicationContext());
			    none.setText("No current education at this time. Try entering some!");
			    none.setTextSize(20);
			    none.setTextColor(Color.BLACK);
			    none.setPadding(15, 5, 15, 5);  
			    ll.addView(none); 
				
			}
			
			
			  //add a home button at the bottom of the list
		    Button back = new Button(getApplicationContext());
		    back.setText("Back");
		    back.setBackgroundColor(Color.BLUE);
		    back.setTextColor(Color.WHITE);
		    ll.addView(back);
		    //action listener for home button
		    back.setOnClickListener(new OnClickListener() {
		    	public void onClick(View v) {
		    		
		    		Intent j = new Intent(CurrentEducationActivity.this, EducationActivity.class);
		    		startActivity(j);
		    	
		    	}
			
		    });
		    
			
			
			
			enter.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					Intent startCurrentEducationInfo = new Intent(CurrentEducationActivity.this, CurrentEducationInfoActivity.class );
					startActivity(startCurrentEducationInfo);
					finish();	// need to change of modify this 
				}
				
			});

			}
	}


