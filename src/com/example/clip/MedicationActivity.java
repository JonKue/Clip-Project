package com.example.clip;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

public class MedicationActivity extends Activity{

	private Context context = this;
	private TextView pillName, startDate, endDate;
	private EditText pillNameEntry, startDateEntry, endDateEntry;
	private Button add, save;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_medication);
		add = (Button) findViewById(R.id.bMaddPill);
		
		add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final Dialog dialog = new Dialog(context);	
				dialog.setContentView(R.layout.dialog_pill_info);
				dialog.setTitle("Add Pill");
				/*
				pillName = (TextView) dialog.findViewById(R.id.tvMpillName);
				startDate = (TextView) dialog.findViewById(R.id.tvMstartDate);
				endDate = (TextView) dialog.findViewById(R.id.tvMendDate);
				pillNameEntry = (EditText) dialog.findViewById(R.id.etMpillName);
				startDateEntry = (EditText) dialog.findViewById(R.id.etMstartDate);
				endDateEntry = (EditText) dialog.findViewById(R.id.etMendDate);*/
				
				save = (Button) findViewById(R.id.bMsave);
				
				save.setOnClickListener(new OnClickListener(){

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
		
	}

}
