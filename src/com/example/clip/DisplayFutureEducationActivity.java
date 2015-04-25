package com.example.clip;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayFutureEducationActivity extends Activity {

	TextView name;
	TextView type;
	TextView prog;
	TextView enroll;
	TextView appD;
	TextView appS;
	
	String schoolName;
	String degreeType;
	String program;
	String enrollment;
	String appDate;
	String appStat;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_future_education);
		
		//get information from previous activity
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    schoolName = extras.getString("schoolName");
		    degreeType = extras.getString("degreeType");
		    program = extras.getString("program");
		    enrollment = extras.getString("enrollment");
		    appDate = extras.getString("appDate");
		    appStat = extras.getString("appStat");
		    
			
		}
		
		//connect text views to xml
		name = (TextView) findViewById(R.id.tvDisplayFSchoolName);
		type = (TextView) findViewById(R.id.tvDisplayFDegree);
		prog = (TextView) findViewById(R.id.tvDisplayFProgram);
		enroll = (TextView) findViewById(R.id.tvDisplayFES);
		appD = (TextView) findViewById(R.id.tvDisplayAppDate);
		appS = (TextView) findViewById(R.id.tvDisplayAppStat);
		
		//set text views to passed in text values
		name.setText(schoolName);
		type.setText(degreeType);
		prog.setText(program);
		enroll.setText(enrollment);
		appD.setText(appDate);
		appS.setText(appStat);
		
		
	}
	
}