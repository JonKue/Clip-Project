package com.example.example;

import com.example.example.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Button;

public class MenuActivity extends Activity{

//	private Button EducationButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_activity);
		//text = (TextView) findViewById(R.id.textViewActivity2);
		
//		Bundle b = getIntent().getExtras();
//		String importedText = b.getString("item");
		//text.setText(importedText);

		Button EducationButton = (Button) findViewById(R.id.bEducation);
		Button FinanceButton = (Button) findViewById(R.id.bFinance);

		EducationButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent startCurrentEducation = new Intent(MenuActivity.this, EducationActivity.class);
				startActivity(startCurrentEducation);
				//finish();
			}
		});
		
		FinanceButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent j = new Intent(MenuActivity.this, FinanceActivity.class);
				startActivity(j);
				//finish();
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
