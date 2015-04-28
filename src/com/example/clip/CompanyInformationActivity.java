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

public class CompanyInformationActivity extends Activity {
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
			TextView compName, compProduct, contactInfoDis, reasonConsiderDis,
					resumeSubDateDis, intInfDis;
			EditText compNameEntry, compProductEntry, keyFacts;
			Button contactInfo, reasonConsider, resumeSubDate, interviewInfo,
					save;

			@Override
			public void onClick(View v) {
				setContentView(R.layout.activity_company_information);

				setUpVariable();
				
				contactInfo.setOnClickListener(new OnClickListener() {
					EditText phone, add1, add2, city, state, zip, country;
					Button ok;

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						final Dialog dialog = new Dialog(context);
						dialog.setContentView(R.layout.dialog_contact_info);
						dialog.setTitle("Company Contact Information");
						setUpInnerVariable(dialog);

						ok.setOnClickListener(new OnClickListener() {
							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								dialog.dismiss();
								// need implementaion here.......
								// save data in database
							}
						});
						dialog.show();
					}

					public void setUpInnerVariable(Dialog d) {
						phone = (EditText) d.findViewById(R.id.etCIFphone);
						add1 = (EditText) d.findViewById(R.id.etCIFadd1);
						add2 = (EditText) d.findViewById(R.id.etCIFadd2);
						city = (EditText) d.findViewById(R.id.etCIFcity);
						state = (EditText) d.findViewById(R.id.etCIFstate);
						zip = (EditText) d.findViewById(R.id.etCIFzip);
						country = (EditText) d.findViewById(R.id.etCIFcountry);
						ok = (Button) d.findViewById(R.id.bCIFok);
					}

				});

				reasonConsider.setOnClickListener(new OnClickListener() {

					EditText reason;
					Button ok;

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						final Dialog dialog = new Dialog(context);
						dialog.setContentView(R.layout.dialog_reason_consider_company);
						dialog.setTitle("Why this company?");
						reason = (EditText) dialog
								.findViewById(R.id.etRCCreason);
						ok = (Button) dialog.findViewById(R.id.bRCCok);

						ok.setOnClickListener(new OnClickListener() {
							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								dialog.dismiss();
								// need implementaion here.......
								// save data in database
							}
						});
						dialog.show();
					}

				});

				resumeSubDate.setOnClickListener(new OnClickListener() {

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

				interviewInfo.setOnClickListener(new OnClickListener() {
					// ScrollView
					EditText date, outcome, lessonLearned;
					Button ok;

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						final Dialog dialog = new Dialog(context);
						dialog.setContentView(R.layout.dialog_interview_info);
						dialog.setTitle("Interview Information");
						date = (EditText) dialog.findViewById(R.id.etIIdate);
						outcome = (EditText) dialog
								.findViewById(R.id.etIIoutcome);
						lessonLearned = (EditText) dialog
								.findViewById(R.id.etIIlessonLearned);
						ok = (Button) dialog.findViewById(R.id.bIIok);
						
						ok.setOnClickListener(new OnClickListener() {
							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								dialog.dismiss();
								// need implementaion here.......
								// save data in database
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
				scroll = (ScrollView) findViewById(R.id.svCI);
				compName = (TextView) findViewById(R.id.tvCIcompanyName);
				compProduct = (TextView) findViewById(R.id.tvCIcompanyProduct);
				contactInfoDis = (TextView) findViewById(R.id.tvCIcontactInfo);
				reasonConsiderDis = (TextView) findViewById(R.id.tvCIreasonConsider);
				resumeSubDateDis = (TextView) findViewById(R.id.tvCIresumeSubDate);
				intInfDis = (TextView) findViewById(R.id.tvCIinterviewInfo);
				compNameEntry = (EditText) findViewById(R.id.etCIcompanyname);
				compProductEntry = (EditText) findViewById(R.id.etCIcompanyProduct);
				keyFacts = (EditText) findViewById(R.id.etCIkeyFacts);
				contactInfo = (Button) findViewById(R.id.bCIcontactInfo);
				reasonConsider = (Button) findViewById(R.id.bCIreasonConsider);
				resumeSubDate = (Button) findViewById(R.id.bCIresumeSubDate);
				interviewInfo = (Button) findViewById(R.id.bCIinterviewInfo);
				save = (Button) findViewById(R.id.bCIsave);

			}
		});

	}
}
