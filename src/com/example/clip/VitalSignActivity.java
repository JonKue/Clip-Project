package com.example.clip;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class VitalSignActivity extends Activity{
	//private VitalSign myVitalSign = new VitalSign(0,0,0,0);
	private Context context = this;
	private Button bodyTemperature, pulseRate, respirationRate, bloodPressure;
	//private TextView bodyTemperatureNum, pulseRateNum, respirationRateNum, bloodPressureNum;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vital_sign);
		
		setUpVariables();
		
		bodyTemperature.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final Dialog dialog = new Dialog(context);	
				dialog.setContentView(R.layout.dialog_vital_sign_entry);
				dialog.setTitle("Body Temperature");
				Button save = (Button) dialog.findViewById(R.id.bVSsave);
				EditText bdTempReading = (EditText) dialog.findViewById(R.id.etVSentry);
				
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
		
		pulseRate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final Dialog dialog = new Dialog(context);	
				dialog.setContentView(R.layout.dialog_vital_sign_entry);
				dialog.setTitle("Pulse");
				Button save = (Button) dialog.findViewById(R.id.bVSsave);
				EditText pulseReading = (EditText) dialog.findViewById(R.id.etVSentry);
				
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
		
		respirationRate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final Dialog dialog = new Dialog(context);	
				dialog.setContentView(R.layout.dialog_vital_sign_entry);
				dialog.setTitle("Respiration Rate");
				Button save = (Button) dialog.findViewById(R.id.bVSsave);
				EditText resRateReading = (EditText) dialog.findViewById(R.id.etVSentry);
				
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
		
		bloodPressure.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final Dialog dialog = new Dialog(context);	
				dialog.setContentView(R.layout.dialog_vs_blood_pressure);
				dialog.setTitle("Blood Pressure");
				Button save = (Button) dialog.findViewById(R.id.bBPsave);
				EditText systolicReading = (EditText) dialog.findViewById(R.id.etSysentry);
				EditText diasystolicReading = (EditText) dialog.findViewById(R.id.etDSysentry);
				
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

	private void setUpVariables() {
		bodyTemperature = (Button) findViewById(R.id.bVSBodyTemperature);
		pulseRate = (Button) findViewById(R.id.bVSPulse);
		respirationRate = (Button) findViewById(R.id.bVSRespirationRate);
		bloodPressure = (Button) findViewById(R.id.bVSBloodPressure);
		/*bodyTemperatureNum = (TextView) findViewById(R.id.tvVSBodyTemperature);
		pulseRateNum = (TextView) findViewById(R.id.tvVSPulse);
		respirationRateNum = (TextView) findViewById(R.id.tvVSRespirationRate);
		bloodPressureNum = (TextView) findViewById(R.id.tvVSBloodPressure);*/
		
	}
	
}
