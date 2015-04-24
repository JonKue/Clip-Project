package com.example.clip;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

public class ExercisePlanActivity extends Activity{

	private Button add;
	private Context context = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercise_plan);
		
		add = (Button) findViewById(R.id.bEPadd);
		
		add.setOnClickListener(new OnClickListener() {
			TextView name, otherInfo;
			EditText nameEntry, otherInfoEntry;
			Spinner routine;
			Button startTime, endTime, save;
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setContentView(R.layout.activity_exercise_plan_info);
				setUpVariable();
				
				startTime.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						final Dialog dialog = new Dialog(context);	
						dialog.setContentView(R.layout.dialog_ep_time);
						dialog.setTitle("Set Time");
						Button done = (Button) dialog.findViewById(R.id.bEPtimeDone);
						TimePicker startTime = (TimePicker) dialog.findViewById(R.id.tpEPtime);
						
						done.setOnClickListener(new OnClickListener(){

							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								dialog.dismiss();
								// need implementaion here.......
							}
						});
						dialog.show();
					}
				});
				
				endTime.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						final Dialog dialog = new Dialog(context);	
						dialog.setContentView(R.layout.dialog_ep_time);
						dialog.setTitle("Set Time");
						Button done = (Button) dialog.findViewById(R.id.bEPtimeDone);
						TimePicker endTime = (TimePicker) dialog.findViewById(R.id.tpEPtime);
						
						done.setOnClickListener(new OnClickListener(){

							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								dialog.dismiss();
								// need implementaion here.......
							}
						});
						dialog.show();
					}
				});
				
				save.setOnClickListener(new OnClickListener(){

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
						// need implementaion here.......
						finish();
					}
				});
			}
			
			public void setUpVariable(){
				name = (TextView) findViewById(R.id.tvEPname);
				otherInfo = (TextView) findViewById(R.id.tvEPotherInfo);
				nameEntry = (EditText) findViewById(R.id.etEPname);
				otherInfoEntry = (EditText) findViewById(R.id.etEPotherInfo);
				routine = (Spinner) findViewById(R.id.sEProutine);
				startTime = (Button) findViewById(R.id.bEPStartTime);
				endTime = (Button) findViewById(R.id.bEPEndTime);
				save = (Button) findViewById(R.id.bEPsave);
			}
			
		});
		
	}

}
