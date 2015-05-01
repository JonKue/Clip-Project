package com.example.clip;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

public class MedicationActivity extends Activity {

	private Context context = this;
	private Button add;
	DatabaseHealthHelper db;
	Button[] b;
	int i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_medication);
		db = new DatabaseHealthHelper(this);
		Cursor c = db.getAllMedication();

		// for dynamic update of GUI
		LinearLayout ll = (LinearLayout) findViewById(R.id.llsvM);

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
					TextView pillName, startDate, endDate;
					Button back;

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						setContentView(R.layout.activity_medication_display);
						setUpButtonVariables();
						String pn = b[i-1].getText().toString();
						pillName.append(pn);
						
						Medication md = db.getMedication(pn);
						startDate.append(md.getDateStarted());
						endDate.append(md.getDateEnded());

						back.setOnClickListener(new OnClickListener() {

							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								recreate();
							}

						});
					}

					public void setUpButtonVariables() {
						pillName = (TextView) findViewById(R.id.tvMDpillName);
						startDate = (TextView) findViewById(R.id.tvMDstartDate);
						endDate = (TextView) findViewById(R.id.tvMDendDate);
						back = (Button) findViewById(R.id.bMDbace);
					}
				});

				ll.addView(b[i]);
				i++;
			}
		}

		add = (Button) findViewById(R.id.bMadd);

		add.setOnClickListener(new OnClickListener() {
			TextView pillName, startDate, endDate;
			EditText pillNameEntry, startDateEntry, endDateEntry;
			Button save;

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final Dialog dialog = new Dialog(context);
				dialog.setContentView(R.layout.dialog_pill_info);
				dialog.setTitle("Add Pill");

				pillName = (TextView) dialog.findViewById(R.id.tvMpillName);
				startDate = (TextView) dialog.findViewById(R.id.tvMstartDate);
				endDate = (TextView) dialog.findViewById(R.id.tvMendDate);
				pillNameEntry = (EditText) dialog
						.findViewById(R.id.etMpillName);
				startDateEntry = (EditText) dialog
						.findViewById(R.id.etMstartDate);
				endDateEntry = (EditText) dialog.findViewById(R.id.etMendDate);

				save = (Button) dialog.findViewById(R.id.bMsave);

				save.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Medication medication = new Medication(pillNameEntry
								.getText().toString());
						medication.setDateStarted(startDateEntry.getText()
								.toString());
						medication.setDateEnded(endDateEntry.getText()
								.toString());

						db.addMedication(medication);
						dialog.dismiss();
						// need implementaion here.......
						recreate();
					}
				});
				dialog.show();
			}
		});

	}

}
