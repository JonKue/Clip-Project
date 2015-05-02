package com.example.clip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DisplayDietPlanActivity extends Activity{
	TextView dietType;
	TextView description;
	TextView date;

	String type;
	String des;
	String dstart;
	String dend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_diet_plan);
		
		// get information from previous activity
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			type = extras.getString("dietType");
			des = extras.getString("dietDescription");
			dstart = extras.getString("startDate");
			dend = extras.getString("endDate");

		}

		// connect text views to xml
		dietType = (TextView) findViewById(R.id.tvDDPdietType);
		description = (TextView) findViewById(R.id.tvDDPdescription);
		date = (TextView) findViewById(R.id.tvDDPdate);

		// set text views to passed in text values
		dietType.setText("Diet Type: " + type);
		description.setText(des);
		date.setText("From " + dstart + " to " + dend);

		Button back = (Button) findViewById(R.id.bDDPback);

		back.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent startHealth = new Intent(DisplayDietPlanActivity.this,
						DietPlanActivity.class);
				startActivity(startHealth);
				finish(); // need to change of modify this
			}

		});

	}
}
