package com.example.clip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button education, health;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		education = (Button) findViewById(R.id.bEducation);
		health = (Button) findViewById(R.id.bHealth);

		education.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent startEducation = new Intent(MainActivity.this,
						EducationActivity.class);
				startActivity(startEducation);
				// finish();
			}
		});

		health.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent startHealth = new Intent(MainActivity.this,
						HealthActivity.class);
				startActivity(startHealth);
				// finish();
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
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
