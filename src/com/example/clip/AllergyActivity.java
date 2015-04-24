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

public class AllergyActivity extends Activity{

	private Context context = this;
	private Button add;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_medication_allergy);
		add = (Button) findViewById(R.id.bMAadd);
		
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
				description = (TextView) dialog.findViewById(R.id.tvAdescription);
				nameEntry = (EditText) dialog.findViewById(R.id.etAname);
				description = (EditText) dialog.findViewById(R.id.etAdescription);
				
				save = (Button) dialog.findViewById(R.id.bAsave);
				
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
