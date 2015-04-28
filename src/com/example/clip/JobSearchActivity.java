package com.example.clip;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

public class JobSearchActivity extends Activity {
	private Context context = this;
	private Button add;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_career_add);

		add = (Button) findViewById(R.id.bCareerAdd);

		add.setOnClickListener(new OnClickListener() {

			TextView appFor, status, dateDisplay, note;
			EditText appForEntry, statusEntry, noteEntry;
			Button date, save;

			@Override
			public void onClick(View v) {

				// TODO Auto-generated method stub
				
				setContentView(R.layout.activity_job_search_info);

				setUpVariable();

				date.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						final Dialog dialog = new Dialog(context);	
						dialog.setContentView(R.layout.dialog_pick_date);
						dialog.setTitle("Select Date");
						Button select = (Button) dialog.findViewById(R.id.bDPsetDate);
						DatePicker date = (DatePicker) dialog.findViewById(R.id.dpDPselectDate);
						
						select.setText("Select");
						
						select.setOnClickListener(new OnClickListener(){

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
						// need to save the data and display on job search activity
						recreate();
					}
					
				});
				 
				

			}

			public void setUpVariable() {
				appFor = (TextView) findViewById(R.id.tvJSappliedFor);
				status = (TextView) findViewById(R.id.tvJSstatus);
				dateDisplay = (TextView) findViewById(R.id.tvJSdate);
				note = (TextView) findViewById(R.id.tvJSnote);
				appForEntry = (EditText) findViewById(R.id.etJSappliedFor);
				statusEntry = (EditText) findViewById(R.id.etJSstatus);
				noteEntry = (EditText) findViewById(R.id.etJSnote);
				date = (Button) findViewById(R.id.bJSdate);
				save = (Button) findViewById(R.id.bJSsave);
			}
		});

	}
}
