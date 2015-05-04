package com.example.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {

    Button registerActivity;
    //test data for user authentication
    String userId;
    String password;
    private EditText userIdValue;
    private EditText passValue;
    private TextView wrongPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        Button menuActivity = (Button) findViewById(R.id.buttonRegister);
        userIdValue = (EditText) findViewById(R.id.editUserName);
        passValue = (EditText) findViewById(R.id.editPassword);
        wrongPass = (TextView) findViewById(R.id.wrongPass);
        Button forgotPassword = (Button) findViewById(R.id.forgotPassword);

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
                if (isValidNamePass) {
                    Intent i = new Intent(LoginActivity.this, MenuActivity.class);
                    i.putExtra("item", enteredUserId);
                    wrongPass.setVisibility(View.INVISIBLE);
                    startActivity(i);
                    finish();
                } else {
                    wrongPass.setText("Incorrect username or password. Please try again.");
                    wrongPass.setVisibility(View.VISIBLE);
                }
            }
        });

        if (db.isEmpty()) {
            Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(i);
            finish();
        }

    }
}