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

public class AllergyActivity extends Activity {

	private Context context = this;
	private Button add;
	DatabaseHealthHelper db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_allergy);
		db = new DatabaseHealthHelper(this);
		Cursor c = db.getAllAllergy();

		// for dynamic update of GUI
		LinearLayout ll = (LinearLayout) findViewById(R.id.llsvA);
		TextView tv;

		if (c.getCount() == 0) {
			tv = new TextView(getApplicationContext());
			tv.setText("None");
			tv.setTextSize(20);
			tv.setPadding(15, 15, 15, 15);
			ll.addView(tv);
		} else {
			int count = 1;
			while (c.moveToNext()){
				tv = new TextView(getApplicationContext());
				String name = c.getString(0);
				String description = c.getString(1);
				if (description.matches(""))
					description = "None";
				String str = String.valueOf(count) + ") " + name 
						+ "\n" + "\t\tDescription: " + description;
				tv.setText(str);
				tv.setTextSize(20);
				tv.setPadding(15, 15, 15, 15);
				ll.addView(tv);
				count++;
			}
		}
		
		add = (Button) findViewById(R.id.bAadd);

		add.setOnClickListener(new OnClickListener() {
			TextView name, description;
			EditText nameEntry, descriptionEntry;
			Button save;

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final Dialog dialog = new Dialog(context);
				dialog.setContentView(R.layout.dialog_allergy_info);
				dialog.setTitle("Add Allergy");

				name = (TextView) dialog.findViewById(R.id.tvAname);
				description = (TextView) dialog
						.findViewById(R.id.tvAdescription);
				nameEntry = (EditText) dialog.findViewById(R.id.etAname);
				descriptionEntry = (EditText) dialog
						.findViewById(R.id.etAdescription);
				

				save = (Button) dialog.findViewById(R.id.bAsave);

				save.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Allergy allergy = new Allergy();
						allergy.setAllergyName(nameEntry.getText().toString());
						allergy.setAllergyDescription(descriptionEntry.getText().toString());
						db.addAllergy(allergy);
						dialog.dismiss();
						recreate();
						
					}
				});
				dialog.show();
			}
		});

	}

}
