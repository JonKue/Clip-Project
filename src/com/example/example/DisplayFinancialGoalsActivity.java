package com.example.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayFinancialGoalsActivity extends Activity {

	TextView name;
	TextView desc;
	TextView type;
	TextView date;
	
	
	String entName;
	String entDesc;
	String entType;
	String entDate;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_financial_goals);
		
		//get information from previous activity
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    entName = extras.getString("name");
		    entDesc = extras.getString("desc");
		    entType = extras.getString("type");
		    entDate = extras.getString("date");


		    
			
		}
		
		//connect text views to xml
		name = (TextView) findViewById(R.id.tvDisplayFGoalName);
		desc = (TextView) findViewById(R.id.tvDisplayFGoalDesc);
		type = (TextView) findViewById(R.id.tvDisplayFGoalType);
		date = (TextView) findViewById(R.id.tvDisplayFGoalDate);


		
		//set text views to passed in text values
		name.setText(entName);
		desc.setText(entDesc);
		type.setText(entType);
		date.setText(entDate);

		
		
	}
	
}