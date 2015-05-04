package com.example.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ScholarshipInfoActivity extends Activity{
    private EditText enterName;
    private EditText enterRequirement;
    private EditText enterAmount;
    private EditText enterApplicationStatus;
    private Button submit;
    private TextView error;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scholarship_info);

        setUpVariables();
        final DatabaseHelper db = new DatabaseHelper(this);

        submit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //get strings from text boxes
                String enteredName = enterName.getText().toString();
                String enteredRequirement = enterRequirement.getText().toString();
                String enteredAmount = enterAmount.getText().toString();
                String enteredAppStat = enterApplicationStatus.getText().toString();



                //make sure all fields are filled in
                if(enteredName.equals("") || enteredAmount.equals("") || enteredAppStat.equals("") || enteredRequirement.equals(""))
                {
                    error.setVisibility(View.VISIBLE);
                }
                else
                {
                    error.setVisibility(View.INVISIBLE);
                    Scholarship scholarship = new Scholarship(0);
                    scholarship.setName(enteredName);
                    scholarship.setRequirement(enteredRequirement);
                    scholarship.setAmount(Integer.parseInt(enteredAmount));
                    scholarship.setApplicationStatus(enteredAppStat);
                    db.addScholarship(scholarship);

                    Intent j = new Intent(ScholarshipInfoActivity.this, ScholarshipActivity.class);
                    j.putExtra("scholarshipName", enteredName);
                    j.putExtra("requirements", enteredRequirement);
                    j.putExtra("amount", enteredAmount);
                    j.putExtra("status", enteredAppStat);
                    startActivity(j);
                    finish();
                }

            }
        });
    }

    private void setUpVariables() {
        enterName = (EditText) findViewById(R.id.etScName);
        enterRequirement = (EditText) findViewById(R.id.etScRequirement);
        enterAmount = (EditText) findViewById(R.id.etScAmount);
        enterApplicationStatus = (EditText) findViewById(R.id.etScApplicationStatus);
        submit = (Button) findViewById(R.id.bScSubmit);
        error = (TextView) findViewById(R.id.error);
    }

}
