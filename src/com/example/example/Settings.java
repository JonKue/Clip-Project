package com.example.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Settings extends Activity {

	TextView newValue;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		
		newValue = (TextView) findViewById(R.id.textViewSettings);
		
		Bundle b = getIntent().getExtras();
		String importedText = b.getString("name");
		
		newValue.setText(importedText);
		
	}
	
}
