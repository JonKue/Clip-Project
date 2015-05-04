package com.example.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import com.example.example.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity{

	EditText username, password, confirm, answer;
	Button register;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_activity);

		username = (EditText) findViewById(R.id.UsernameInput);
		password = (EditText) findViewById(R.id.passwordInput);
		confirm = (EditText) findViewById(R.id.passwordInputConfirmed);
		answer = (EditText) findViewById(R.id.answer);
		register = (Button) findViewById(R.id.buttonRegister);
		final Spinner dropdown = (Spinner)findViewById(R.id.spinner1);
		String[] items = new String[]{"Select security question", "What is your first pet's name?", "What is your hometown?"};
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
		dropdown.setAdapter(adapter);

		final DatabaseHelper db = new DatabaseHelper(this);
		
		register.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {

				String user = username.getText().toString();
				String pass = password.getText().toString();
				String conf = confirm.getText().toString();
				String answ = answer.getText().toString();
				int question = dropdown.getSelectedItemPosition();

				if(question!=0 && conf.equals(pass) && !user.equals("") && !pass.equals("") && !answ.equals(""))
				{
					Log.d("CLIP-DEGUG:: ", user + " " + pass);
					db.registerUser(user, pass, question, answ); //TODO -- Hash passwords/answer???
					Intent i = new Intent(RegisterActivity.this,MenuActivity.class);
					i.putExtra("item", user);
					startActivity(i);
					finish();
				}
				else {
					username.setHintTextColor(Color.RED);
					password.setHintTextColor(Color.RED);
					confirm.setHintTextColor(Color.RED);
					answer.setHintTextColor(Color.RED);
				}
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
