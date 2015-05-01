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

public class ContactListActivity extends Activity {
	private Context context = this;
	private Button add;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jobsearch_add);

		add = (Button) findViewById(R.id.bCareerAdd);

		add.setOnClickListener(new OnClickListener() {

			ScrollView scroll;
			EditText affiliation, establishedDate, comments;
			TextView nameDis;
			Button contactName, save;

			@Override
			public void onClick(View v) {
				setContentView(R.layout.activity_contact_list_info);

				setUpVariable();
				
				contactName.setOnClickListener(new OnClickListener() {

					// ScrollView if need to use
					EditText title, firstName, middleName, lastName, phone, email;
					Button ok;
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						final Dialog dialog = new Dialog(context);	
						dialog.setContentView(R.layout.dialog_contact_name_info);
						dialog.setTitle("Contact Name Information");
						setUpInnerVariable(dialog);
						
						ok.setOnClickListener(new OnClickListener(){

							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								dialog.dismiss();
								// need implementaion here.......save data
							}
						});
						dialog.show();
					}
				
					public void setUpInnerVariable(Dialog d){
						title = (EditText) d.findViewById(R.id.etCNtitle);
						firstName = (EditText) d.findViewById(R.id.etCNfirstname);
						middleName = (EditText) d.findViewById(R.id.etCNmiddlename);
						lastName = (EditText) d.findViewById(R.id.etCNlastname);
						phone = (EditText) d.findViewById(R.id.etCNphone);
						email = (EditText) d.findViewById(R.id.etCNemail);
						ok = (Button) d.findViewById(R.id.bCNok);
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
				scroll = (ScrollView) findViewById(R.id.svCL);
				affiliation = (EditText) findViewById(R.id.etCLaffiliation);
				establishedDate = (EditText) findViewById(R.id.etCLestablishedDate);
				comments = (EditText) findViewById(R.id.etCLcomments);
				nameDis = (TextView) findViewById(R.id.tvCLname);
				contactName = (Button) findViewById(R.id.bCLname);
				save = (Button) findViewById(R.id.bCLsave);

			}
		});

	}
}
