package com.example.clip;

import java.io.File;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CurrentEducationActivity extends Activity {
	static String filename = "CurrentEducationInfo";
	Button enter;
	public static File edInfFile = new File(filename);
	@Override
	protected void onCreate(Bundle noneState) {
		// TODO Auto-generated method stub
		super.onCreate(noneState);
		
		// File does not exist
		if (!edInfFile.exists()){
			setContentView(R.layout.activity_none);
			
			enter = (Button) findViewById(R.id.bEnter);
			enter.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					Intent startCurrentEducationInfo = new Intent(CurrentEducationActivity.this, CurrentEducationInfoActivity.class );
					startActivity(startCurrentEducationInfo);
					finish();	// need to change of modify this 
				}
				
			});
		} else {
			setContentView(R.layout.activity_main);
		}
	}
}
