package com.example.example;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ForgotPasswordActivity extends Activity {
	private final Context context = this;
	Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        
        submit = (Button) findViewById(R.id.bSubmitUserName);
        submit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_security_question);
                dialog.setTitle("Security Question");
                Button submit = (Button) dialog.findViewById(R.id.bSubmitAnswer);

                TextView question = (TextView) dialog.findViewById(R.id.tvQuestion);
          
                //get the question from the database and display it
                question.setText("This is the question?");


                submit.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        dialog.dismiss();
                        final Dialog dialog2 = new Dialog(context);
                        dialog2.setContentView(R.layout.dialog_display_password);
                        dialog2.setTitle("Password");
                        Button dismiss = (Button) dialog2.findViewById(R.id.bDismissPassword);

                        TextView password = (TextView) dialog2.findViewById(R.id.tvDisplayPassword);
                  
                        //get the password from the database and display is
                        password.setText("test1234");


                        dismiss.setOnClickListener(new OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                // TODO Auto-generated method stub
                                dialog2.dismiss();
                          

                            }
                        });
                        dialog2.show();
                  

                    }
                });
                dialog.show();
            }
        });
       
    }
}
