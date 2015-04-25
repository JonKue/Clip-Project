package com.example.clip;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FutureEducationInfoActivity extends Activity {
	public FileOutputStream fFuEdInfo = null;

	TextView schoolName;
	EditText enterSchoolName;
	TextView degree;
	EditText enterDegree;
	TextView program;
	EditText enterProgram;
	TextView enrollmentStatus;
	EditText enterEnrollmentStatus;
	TextView applicationDate;
	EditText enterApplicationDate;
	TextView applicationStatus;
	EditText enterApplicationStatus;
	Button submit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_future_education_info);

		setUpVariables();
		
		submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
			
			}
		});
	}

	private void setUpVariables() {
		schoolName = (TextView) findViewById(R.id.tvFSchoolName);
		enterSchoolName = (EditText) findViewById(R.id.etFSchoolName);
		degree = (TextView) findViewById(R.id.tvFDegree);
		enterDegree = (EditText) findViewById(R.id.etFDegree);
		program = (TextView) findViewById(R.id.tvFProgram);
		enterProgram = (EditText) findViewById(R.id.etFProgram);
		enrollmentStatus = (TextView) findViewById(R.id.tvFEnrollmentStatus);
		enterEnrollmentStatus = (EditText) findViewById(R.id.etFEnrollmentStatus);
		applicationDate = (TextView) findViewById(R.id.tvApplicationDate);
		enterApplicationDate = (EditText) findViewById(R.id.etApplicationDate);
		applicationStatus = (TextView) findViewById(R.id.tvApplicationStatus);
		enterApplicationStatus = (EditText) findViewById(R.id.etApplicationStatus);
		submit = (Button) findViewById(R.id.bFuEdSubmit);
				
	}

}
