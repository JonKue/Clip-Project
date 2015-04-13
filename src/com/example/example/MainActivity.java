package com.example.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button newActivity;
	EditText textBoxValue;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        newActivity = (Button) findViewById(R.id.buttonNavigateSecondActivity);
        textBoxValue = (EditText) findViewById(R.id.editText1);
        
        newActivity.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				String enteredValue = textBoxValue.getText().toString();
				Intent i = new Intent(MainActivity.this, SecondActivity.class);
				i.putExtra("item", enteredValue);
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
        	Intent i = new Intent(MainActivity.this, Settings.class);
        	i.putExtra("name", "Settings");
			startActivity(i);
			//finish();
            return true;
        }
        
        return super.onOptionsItemSelected(item);
    }
}