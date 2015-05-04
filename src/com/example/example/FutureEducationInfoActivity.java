package com.example.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FutureEducationInfoActivity extends Activity {
    public FileOutputStream fFuEdInfo = null;

    TextView schoolName;
    EditText enterSchoolName;
    TextView degree;
    EditText enterDegree;
    TextView program;
    EditText enterProgram;
    TextView enrollmentStatus;
    EditText enterEnrollmentStatus;
    TextView applicationDate;
    EditText enterApplicationDate;
    TextView applicationStatus;
    EditText enterApplicationStatus;
    Button submit;
    TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future_education_info);

        setUpVariables();
        final DatabaseHelper db = new DatabaseHelper(this);

        submit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                //get strings from text boxes
                String enteredSchool = enterSchoolName.getText().toString();
                String enteredDegree = enterDegree.getText().toString();
                String enteredProgram = enterProgram.getText().toString();
                String enteredEnroll = enterEnrollmentStatus.getText().toString();
                String enteredAppDate = enterApplicationDate.getText().toString();
                String enteredAppStat = enterApplicationStatus.getText().toString();


                //make sure all fields are filled in
                if(enteredSchool.equals("") || enteredDegree.equals("") || enteredProgram.equals("") || enteredEnroll.equals(""))
                {
                    error.setVisibility(View.VISIBLE);
                }
                else
                {
                    error.setVisibility(View.INVISIBLE);

                    School school = new School(0); //Databse sets id automatically
                    school.set_schoolName(enteredSchool);
                    school.set_degreeType(enteredDegree);
                    school.set_program(enteredProgram);
                    school.set_enrollment(enteredEnroll);
                    school.set_appDate(enteredAppDate);
                    school.set_appStat(enteredAppStat);
//                    school.set_type("FUTURE");  -- Type set by addSchool
                    db.addSchool_Future(school);


                    Intent j = new Intent(FutureEducationInfoActivity.this, FutureEducationActivity.class);
                    j.putExtra("schoolName", enteredSchool);
                    j.putExtra("degreeType", enteredDegree);
                    j.putExtra("program", enteredProgram);
                    j.putExtra("enrollment", enteredEnroll);
                    j.putExtra("appDate", enteredAppDate);
                    j.putExtra("appStat", enteredAppStat);
                    startActivity(j);
                    finish();
                }

            }

        });
    }

    private void setUpVariables() {
        schoolName = (TextView) findViewById(R.id.tvFSchoolName);
        enterSchoolName = (EditText) findViewById(R.id.etFSchoolName);
        degree = (TextView) findViewById(R.id.tvFDegree);
        enterDegree = (EditText) findViewById(R.id.etFDegree);
        program = (TextView) findViewById(R.id.tvFProgram);
        enterProgram = (EditText) findViewById(R.id.etFProgram);
        enrollmentStatus = (TextView) findViewById(R.id.tvFEnrollmentStatus);
        enterEnrollmentStatus = (EditText) findViewById(R.id.etFEnrollmentStatus);
        applicationDate = (TextView) findViewById(R.id.tvApplicationDate);
        enterApplicationDate = (EditText) findViewById(R.id.etApplicationDate);
        applicationStatus = (TextView) findViewById(R.id.tvApplicationStatus);
        enterApplicationStatus = (EditText) findViewById(R.id.etApplicationStatus);
        error = (TextView) findViewById(R.id.error);
        submit = (Button) findViewById(R.id.bFuEdSubmit);

    }

}
