package com.example.clip;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

public class GoalActivity extends Activity{
	private Context context = this;
	private TextView stg, ltg, stg_text, ltg_text;
	private Button stg_add, ltg_add;
	private ScrollView stg_scroll, ltg_scroll;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_goal);
		
		setUpVariables();
		
		stg_add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final Dialog dialog = new Dialog(context);	
				dialog.setContentView(R.layout.dialog_goal_entry);
				dialog.setTitle("Short Term Goal");
				Button save = (Button) dialog.findViewById(R.id.bGsave);
				Button done = (Button) dialog.findViewById(R.id.bGdone);
				final EditText stgEntry = (EditText) dialog.findViewById(R.id.etGoalEntry);
				
				save.setOnClickListener(new OnClickListener(){
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						//dialog.dismiss();
						// need implementaion here.......
						// save data in database
					}
				});
				
				done.setOnClickListener(new OnClickListener(){
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						dialog.dismiss();
						// need implementaion here.......
						// save data in database
						// Display data in Goal Activity
					}
				});
				
				dialog.show();	
				
			}	
		});
		
		ltg_add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final Dialog dialog = new Dialog(context);	
				dialog.setContentView(R.layout.dialog_goal_entry);
				dialog.setTitle("Long Term Goal");
				Button save = (Button) dialog.findViewById(R.id.bGsave);
				Button done = (Button) dialog.findViewById(R.id.bGdone);
				final EditText stgEntry = (EditText) dialog.findViewById(R.id.etGoalEntry);
				
				save.setOnClickListener(new OnClickListener(){
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						//dialog.dismiss();
						// need implementaion here.......
						// save data in database
					}
				});
				
				done.setOnClickListener(new OnClickListener(){
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						dialog.dismiss();
						// need implementaion here.......
						// save data in database
						// Display data in Goal Activity
					}
				});
				
				dialog.show();	
				
			}	
		});
		
	}

	private void setUpVariables() {
		stg = (TextView) findViewById(R.id.tvSTG);
		ltg = (TextView) findViewById(R.id.tvLTG);
		stg_add = (Button) findViewById(R.id.bSTGadd);
		ltg_add = (Button) findViewById(R.id.bLTGadd);
		stg_scroll = (ScrollView) findViewById(R.id.svSTG);
		ltg_scroll = (ScrollView) findViewById(R.id.svLTG);
		stg_text = (TextView) findViewById(R.id.tvSTGentry);
		ltg_text = (TextView) findViewById(R.id.tvLTGentry);
	}
}
