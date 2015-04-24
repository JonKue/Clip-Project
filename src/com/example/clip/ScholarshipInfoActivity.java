package com.example.clip;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ScholarshipInfoActivity extends Activity{
	TextView name, requirement, amount, applicationStatus;
	EditText enterName, enterRequirement, enterAmount, enterApplicationStatus;
	Button submit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scholarship_info);

		setUpVariables();
		
		submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	private void setUpVariables() {
		name = (TextView) findViewById(R.id.tvScName);
		requirement = (TextView) findViewById(R.id.tvScRequirement);
		amount = (TextView) findViewById(R.id.tvScAmount);
		applicationStatus = (TextView) findViewById(R.id.tvScApplicationStatus);
		enterName = (EditText) findViewById(R.id.etScName);
		enterRequirement = (EditText) findViewById(R.id.etScRequirement);
		enterAmount = (EditText) findViewById(R.id.etScAmount);
		enterApplicationStatus = (EditText) findViewById(R.id.etScApplicationStatus);
		submit = (Button) findViewById(R.id.bScSubmit);
	}

}
