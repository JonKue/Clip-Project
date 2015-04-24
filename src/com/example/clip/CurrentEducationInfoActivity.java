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

public class CurrentEducationInfoActivity extends Activity {
	public FileOutputStream fCuEdInfo = null;

	TextView schoolName, degree, program, enrollmentStatus, tuition, course, dateStart, dateGraduate;
	EditText enterSchoolName, enterDegree, enterProgram, enterEnrollmentStatus, enterTuition, enterCourse, enterDateStart, enterDateGraduate;
	Button submit;
	
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
				try {
					CurrentEducationActivity.edInfFile.createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					fCuEdInfo = new FileOutputStream(
					CurrentEducationActivity.edInfFile);

					setContentView(R.layout.activity_main);

					fCuEdInfo.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
		tuition = (TextView) findViewById(R.id.tvTuition);
		enterTuition = (EditText) findViewById(R.id.etTuition);
		course = (TextView) findViewById(R.id.tvCoursesPlan);
		enterCourse = (EditText) findViewById(R.id.etCourse);
		dateStart = (TextView) findViewById(R.id.tvDateStart);
		enterDateStart = (EditText) findViewById(R.id.etDateStart);
		dateGraduate = (TextView) findViewById(R.id.tvDateGraduate);
		enterDateGraduate = (EditText) findViewById(R.id.etDateGraduate);
		submit = (Button) findViewById(R.id.bCuEdSubmit);
				
	}

}
