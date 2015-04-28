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

public class ElectronicIdentityActivity extends Activity {
	private Context context = this;
	private Button add;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_career_add);

		add = (Button) findViewById(R.id.bCareerAdd);

		add.setOnClickListener(new OnClickListener() {

			ScrollView scroll;
			EditText name, website, username, password;
			Button save;

			@Override
			public void onClick(View v) {
				setContentView(R.layout.activity_electronic_identity_info);

				setUpVariable();
				
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
				scroll = (ScrollView) findViewById(R.id.svEI);
				name = (EditText) findViewById(R.id.etEIname);
				website = (EditText) findViewById(R.id.etEIwebsite);
				username = (EditText) findViewById(R.id.etEIusername);
				password = (EditText) findViewById(R.id.etEIpassword);
				save = (Button) findViewById(R.id.bEIsave);

			}
		});

	}
}
