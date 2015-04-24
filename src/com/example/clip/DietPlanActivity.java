package com.example.clip;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

public class DietPlanActivity extends Activity implements View.OnClickListener{

	private Button startDate, endDate, monday, tuesday, wednesday, thursday, friday, saturday, sunday;
	private Context context = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_diet_plan);
		setUpVariable();
		
		startDate.setOnClickListener(this);
		endDate.setOnClickListener(this);
		monday.setOnClickListener(this);
		tuesday.setOnClickListener(this);
		wednesday.setOnClickListener(this);
		thursday.setOnClickListener(this);
		friday.setOnClickListener(this);
		saturday.setOnClickListener(this);
		sunday.setOnClickListener(this);
		
	}
			
	public void setUpVariable() {
		startDate = (Button) findViewById(R.id.bDPstartDate);
		endDate = (Button) findViewById(R.id.bDPendDate);
		monday = (Button) findViewById(R.id.bDPmonday);
		tuesday = (Button) findViewById(R.id.bDPtuesday);
		wednesday = (Button) findViewById(R.id.bDPwednesday);
		thursday = (Button) findViewById(R.id.bDPthursday);
		friday = (Button) findViewById(R.id.bDPfriday);
		saturday = (Button) findViewById(R.id.bDPsaturday);
		sunday = (Button) findViewById(R.id.bDPsunday);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bDPstartDate:
			chooseTime();	// May need to modify to get data
			break;
		case R.id.bDPendDate:
			chooseTime();	// May need to modify to get data
			break;
		case R.id.bDPmonday:
			dietPlanInfo();
			break;
		case R.id.bDPtuesday:
			dietPlanInfo();
			break;
		case R.id.bDPwednesday:
			dietPlanInfo();
			break;
		case R.id.bDPthursday:
			dietPlanInfo();
			break;
		case R.id.bDPfriday:
			dietPlanInfo();
			break;
		case R.id.bDPsaturday:
			dietPlanInfo();
			break;
		case R.id.bDPsunday:
			dietPlanInfo();
			break;
		}
	}
	
	public void chooseTime(){
		final Dialog dialog = new Dialog(context);	
		dialog.setContentView(R.layout.dialog_dp_date);
		dialog.setTitle("Set Date");
		Button set = (Button) dialog.findViewById(R.id.bDPsetDate);
		DatePicker date = (DatePicker) dialog.findViewById(R.id.dpDPselectDate);
		
		set.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dialog.dismiss();
				// need implementaion here.......
			}
		});
		dialog.show();
	}
	
	public void dietPlanInfo(){
		final Dialog dialog = new Dialog(context);	
		dialog.setContentView(R.layout.dialog_diet_plan_info);
		dialog.setTitle("Meal Plan");
		Spinner meal = (Spinner) dialog.findViewById(R.id.sDPmeal);
		TextView description = (TextView) dialog.findViewById(R.id.tvDPdescription);
		EditText descriptionEntry = (EditText) dialog.findViewById(R.id.etDPdescription);
		Button save = (Button) dialog.findViewById(R.id.bDPsave);
		Button done = (Button) dialog.findViewById(R.id.bDPdone);
		
		done.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dialog.dismiss();
				// need implementaion here.......
			}
		});
		
		save.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//dialog.dismiss();
				// need implementaion here.......
			}
		});
		dialog.show();
	}
			
	
}
