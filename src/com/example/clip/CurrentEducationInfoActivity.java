package com.example.clip;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CurrentEducationInfoActivity extends Activity {
	public FileOutputStream fCuEdInfo = null;

	TextView schoolName, degree, program, enrollmentStatus, tuition, course, dateStart, dateGraduate;
	EditText enterSchoolName, enterDegree, enterProgram, enterEnrollmentStatus, enterTuition, enterCourse, enterDateStart, enterDateGraduate;
	Button submit;
	TextView error;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_current_education_info);

		setUpVariables();
		
		submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//get strings from text boxes
				String enteredSchool = enterSchoolName.getText().toString();
				String enteredDegree = enterDegree.getText().toString();
				String enteredProgram = enterProgram.getText().toString();
				String enteredEnroll = enterEnrollmentStatus.getText().toString();
				String enteredTuition = enterTuition.getText().toString();
				String enteredCourse= enterCourse.getText().toString();
				String enteredDateStart = enterDateStart.getText().toString();
				String enteredDateGrad = enterDateGraduate.getText().toString();
				
				//make sure all fields are filled in 
				if(enteredSchool.equals("") || enteredDegree.equals("") || enteredProgram.equals("") || enteredEnroll.equals("") ||
						enteredTuition.equals("") || enteredCourse.equals("") || enteredDateStart.equals("") || enteredDateGrad.equals(""))
				{
					error.setVisibility(View.VISIBLE);
					
				}
				else
				{
					
					Intent j = new Intent(CurrentEducationInfoActivity.this, CurrentEducationActivity.class);
					j.putExtra("schoolName", enteredSchool);
					j.putExtra("degreeType", enteredDegree);
					j.putExtra("program", enteredProgram);
					j.putExtra("enrollment", enteredEnroll);
					j.putExtra("tuition", enteredTuition);
					j.putExtra("course", enteredCourse);
					j.putExtra("dateStart", enteredDateStart);
					j.putExtra("dateGrad", enteredDateGrad);
					startActivity(j);
					
				}
					
				
			}

		});
	}

	private void setUpVariables() {
		schoolName = (TextView) findViewById(R.id.tvSchoolName);
		enterSchoolName = (EditText) findViewById(R.id.etSchoolName);
		degree = (TextView) findViewById(R.id.tvDegree);
		enterDegree = (EditText) findViewById(R.id.etDegree);
		program = (TextView) findViewById(R.id.tvProgram);
		enterProgram = (EditText) findViewById(R.id.etProgram);
		enrollmentStatus = (TextView) findViewById(R.id.tvEnrollmentStatus);
		enterEnrollmentStatus = (EditText) findViewById(R.id.etEnrollmentStatus);
		tuition = (TextView) findViewById(R.id.tvAppDate);
		enterTuition = (EditText) findViewById(R.id.etTuition);
		course = (TextView) findViewById(R.id.tvAppStat);
		enterCourse = (EditText) findViewById(R.id.etCourse);
		dateStart = (TextView) findViewById(R.id.tvDateStart);
		enterDateStart = (EditText) findViewById(R.id.etDateStart);
		dateGraduate = (TextView) findViewById(R.id.tvDateGraduate);
		enterDateGraduate = (EditText) findViewById(R.id.etDateGraduate);
		submit = (Button) findViewById(R.id.bCuEdSubmit);
		error = (TextView) findViewById(R.id.error);
				
	}

}
