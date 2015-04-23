package com.example.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import com.example.example.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends Activity{

	Button register;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_activity);
		register = (Button) findViewById(R.id.buttonRegister);
		Spinner dropdown = (Spinner)findViewById(R.id.spinner1);
		String[] items = new String[]{"Select security question", "What is your first dog's name?", "What is your hometown?"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
		dropdown.setAdapter(adapter);
		
		register.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				FileOutputStream outputStream;
				String filename = "user.txt";
				String yea = "yea";

				try {
				  outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
				  outputStream.write(yea.getBytes());
				  outputStream.close();
				  Toast.makeText(getBaseContext(),
							"Done writing 'user.txt'",
							Toast.LENGTH_SHORT).show();
				} 
				catch (Exception e) {
				  Toast.makeText(getBaseContext(), e.getMessage(),
							Toast.LENGTH_SHORT).show();
				  
				}

				
				Intent i = new Intent(RegisterActivity.this,LoginActivity.class);
				startActivity(i);
			//	finish();
	         }
		});
        
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
        	Intent i = new Intent(this, Settings.class);
        	i.putExtra("name", "string2");
			startActivity(i);
			//finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
}
