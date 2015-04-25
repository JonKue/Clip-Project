package com.example.clip;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayScholarshipActivity extends Activity {
		TextView name;
		TextView requirements;
		TextView amount;
		TextView appStatus;

		
		String scholarshipName;
		String req;
		String amt;
		String appStat;

		
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_display_scholarship);
			
			//get information from previous activity
			Bundle extras = getIntent().getExtras();
			if (extras != null) {
			    scholarshipName = extras.getString("name");
			    req = extras.getString("req");
			    amt = extras.getString("amt");
			    appStat = extras.getString("appStat");
			    
				
			}
			
			//connect text views to xml
			name = (TextView) findViewById(R.id.tvDisplayScholarship);
			requirements = (TextView) findViewById(R.id.tvDisplayRequirements);
			amount = (TextView) findViewById(R.id.tvDisplayAmount);
			appStatus = (TextView) findViewById(R.id.tvDisplayApplicationStatus);
			
			//set text views to passed in text values
			name.setText(scholarshipName);
			requirements.setText(req);
			amount.setText(amt);
			appStatus.setText(appStat);
			
			
		}
		
	}