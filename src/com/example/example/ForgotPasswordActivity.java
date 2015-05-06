package com.example.example;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ForgotPasswordActivity extends Activity {
	private final Context context = this;
	Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final DatabaseHelper db = new DatabaseHelper(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        final EditText name = (EditText) this.findViewById(R.id.etUsername);
        final TextView error = (TextView) this.findViewById(R.id.wrongAnsw);
        error.setVisibility(View.INVISIBLE);
        
        submit = (Button) findViewById(R.id.bSubmitUserName);
        submit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(!db.isValidName(name.getText().toString())){

                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_security_question);
                dialog.setTitle("Security Question");
                Button submit = (Button) dialog.findViewById(R.id.bSubmitAnswer);

                TextView question = (TextView) dialog.findViewById(R.id.tvQuestion);
                final EditText answer = (EditText) dialog.findViewById(R.id.etAnswer);
          
                //get the question from the database and display it
                Cursor cursor = db.getUser();
                String ques;
                Resources res = getResources();
                String[] questions = res.getStringArray(R.array.PASSWORD_RESET_QUESTIONS);

                question.setText(questions[cursor.getInt(3)]);


                submit.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();
                        if (db.checkAnswer(answer.getText().toString())) {
                            final Dialog dialog2 = new Dialog(context);
                            dialog2.setContentView(R.layout.dialog_display_password);
                            dialog2.setTitle("Password");
                            Button dismiss = (Button) dialog2.findViewById(R.id.bDismissPassword);
                            dismiss.setText("Submit");

                            final EditText password = (EditText) dialog2.findViewById(R.id.etSetPassword);


                            dismiss.setOnClickListener(new OnClickListener() {

                                @Override
                                public void onClick(View v) {
                                    String newpass = password.getText().toString();
                                    if(newpass.equals("")){
                                        error.setText("Must use nonempty password");
                                        error.setVisibility(View.VISIBLE);
                                        dialog2.dismiss();
                                    }
                                    else {
                                        db.resetPassword(password.getText().toString());
                                        dialog2.dismiss();

                                        Intent i = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
                                        startActivity(i);
                                        finish();
                                    }
                                }
                            });
                            dialog2.show();
                        } else {
                            error.setText("Your answer was incorrect");
                            error.setVisibility(View.VISIBLE);
                        }

                    }
                });

                dialog.show();
                }
                else {
                    error.setText("Invalid Username");
                    error.setVisibility(View.VISIBLE);
                }
            }

        });
       
    }
}
