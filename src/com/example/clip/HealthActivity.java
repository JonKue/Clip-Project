package com.example.clip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HealthActivity extends Activity {
	private Button vitalSign, exercisePlan, dietPlan, medication, allergy;
	
	@Override
	protected void onCreate(Bundle healthState) {
		super.onCreate(healthState);
		setContentView(R.layout.activity_health);
		
		setUpVariables();
		
		vitalSign.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent startVitalSign = new Intent(HealthActivity.this, VitalSignActivity.class);
				startActivity(startVitalSign);
			}
		});
		
		exercisePlan.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent startExercisePlan = new Intent(HealthActivity.this, ExercisePlanActivity.class);
				startActivity(startExercisePlan);
			}
		});
		
		dietPlan.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent startDietPlan = new Intent(HealthActivity.this, DietPlanActivity.class);
				startActivity(startDietPlan);
			}
		});
		
		medication.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent startMedication = new Intent(HealthActivity.this, MedicationActivity.class);
				startActivity(startMedication);
			}
		});
		
		allergy.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent startAllergy = new Intent(HealthActivity.this, AllergyActivity.class);
				startActivity(startAllergy);
			}
		});
		
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		
		//inflate.inflate(R.menu.health, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void setUpVariables(){
		vitalSign = (Button) findViewById(R.id.bVitalSign);
		exercisePlan = (Button) findViewById(R.id.bExercisPlan);
		dietPlan = (Button) findViewById(R.id.bDietPlan);
		medication = (Button) findViewById(R.id.bMedication);
		allergy = (Button) findViewById(R.id.bAllergy);
	}
}

