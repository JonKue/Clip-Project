package com.example.clip;

import java.util.Date;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class JobSearchActivity extends Activity {
	private Context context = this;
	private Button add;
	DatabaseCareerHelper db;
	Button[] b;
	int i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jobsearch_add);

		db = new DatabaseCareerHelper(this);
		Cursor c = db.getAllJobSearch();

		// for dynamic update of GUI
		LinearLayout ll = (LinearLayout) findViewById(R.id.llJobSearch);

		if (c.getCount() == 0) {
			TextView tv;
			tv = new TextView(getApplicationContext());
			tv.setText("None");
			tv.setTextSize(20);
			tv.setPadding(15, 15, 15, 15);
			ll.addView(tv);
		} else {
			int count = c.getCount();
			b = new Button[count];
			i = 0;
			while (c.moveToNext()) {
				b[i] = new Button(getApplicationContext());
				b[i].setText(c.getString(0));
				b[i].setTextSize(20);

				b[i].setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub

						recreate();

					}
				});

				ll.addView(b[i]);
				i++;
			}
		}

		add = (Button) findViewById(R.id.bCareerAdd);

		add.setOnClickListener(new OnClickListener() {

			TextView appFor, status, dateDisplay, note;
			EditText appForEntry, statusEntry, noteEntry;
			Button date, save;
			JobSearch jobSearch = new JobSearch();
			
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
						Button select = (Button) dialog
								.findViewById(R.id.bDPsetDate);
						DatePicker date = (DatePicker) dialog
								.findViewById(R.id.dpDPselectDate);

						select.setText("Select");

						select.setOnClickListener(new OnClickListener() {

							@SuppressWarnings("deprecation")
							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								DatePicker date = (DatePicker) dialog
										.findViewById(R.id.dpDPselectDate);
								int day = date.getDayOfMonth();
								int month = date.getMonth() + 1;
								int year = date.getYear();
								Date d = new Date();
								d.setDate(day);
								d.setMonth(month);
								d.setYear(year);
								
								dateDisplay.setText(d.toString());
								dialog.dismiss();
								// need implementaion here.......
							}
						});
						dialog.show();
					}
				});

				save.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						jobSearch.setJobName(appForEntry.getText().toString());
						jobSearch.setDate(dateDisplay.getText().toString());
						jobSearch.setStatus(statusEntry.getText().toString());
						jobSearch.setNote(noteEntry.getText().toString());
						db.addJobSearch(jobSearch);
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
