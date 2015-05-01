package com.example.example;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.example.example.R;

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

public class LoginActivity extends Activity {

	Button menuActivity;
	EditText userIdValue;
	EditText passValue;
	Button registerActivity;
	Button forgotPassword;
	TextView wrongPass;
	
	//test data for user authentication
	String userId;
	String password;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        
        menuActivity = (Button) findViewById(R.id.buttonRegister);
        userIdValue = (EditText) findViewById(R.id.editUserName);
        passValue = (EditText) findViewById(R.id.editPassword);
        wrongPass = (TextView) findViewById(R.id.wrongPass);
        forgotPassword = (Button) findViewById(R.id.forgotPassword);

		final DatabaseHelper db = new DatabaseHelper(this);

        
        forgotPassword.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) { //TODO -- USING TO RESET DATABASE
				Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
				db.onWipe();
				startActivity(i);
				finish();
			}
		});
        
        
        menuActivity.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				String enteredUserId = userIdValue.getText().toString();
				String enteredPassword = passValue.getText().toString();
				
				boolean isValidNamePass = db.loginUser(enteredUserId, enteredPassword);
			
				//if this is registered user, allow access to CLIP
				if(isValidNamePass)
				{
					Intent i = new Intent(LoginActivity.this, LoginActivityBeta.class);
					i.putExtra("item", enteredUserId);
					wrongPass.setVisibility(View.INVISIBLE);
					startActivity(i);
					finish();
				}
				else
				{
					wrongPass.setText("Incorrect username or password. Please try again.");
					wrongPass.setVisibility(View.VISIBLE);
				}
	         }
		});

		if(db.isEmpty()) {
			Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
			startActivity(i);
			finish();
		}
        
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
        	Intent i = new Intent(LoginActivity.this, Settings.class);
        	i.putExtra("name", "Settings");
			startActivity(i);
			//finish();
            return true;
        }
        
        return super.onOptionsItemSelected(item);
    }
}