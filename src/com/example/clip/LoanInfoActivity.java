package com.example.clip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoanInfoActivity extends Activity{
	TextView companyName, amount, applicationStatus;
	EditText enterCompanyName, enterAmount, enterApplicationStatus;
	Button submit;
	TextView error;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loan_info);

		setUpVariables();
		
		submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//get strings from text boxes
				String enteredName = enterCompanyName.getText().toString();
				String enteredAmount = enterAmount.getText().toString();
				String enteredAppStat = enterApplicationStatus.getText().toString();

				
				
				//make sure all fields are filled in 
				if(enteredName.equals("") || enteredAmount.equals("") || enteredAppStat.equals(""))
				{
					error.setVisibility(View.VISIBLE);
				}
				else
				{
					Intent j = new Intent(LoanInfoActivity.this, LoanActivity.class);
					j.putExtra("name", enteredName);
					j.putExtra("amt", enteredAmount);
					j.putExtra("appStat", enteredAppStat);
					startActivity(j);
				}
			
			}

		});
	}


	private void setUpVariables() {
		companyName = (TextView) findViewById(R.id.tvLoCompanyName);
		amount = (TextView) findViewById(R.id.tvLoAmount);
		applicationStatus = (TextView) findViewById(R.id.tvLoApplicationStatus);
		enterCompanyName = (EditText) findViewById(R.id.etLoCompanyName);
		enterAmount = (EditText) findViewById(R.id.etLoAmount);
		enterApplicationStatus = (EditText) findViewById(R.id.etLoApplicationStatus);
		submit = (Button) findViewById(R.id.bLoSubmit);
		error = (TextView) findViewById(R.id.error);
	}

}
