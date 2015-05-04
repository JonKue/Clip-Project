package com.example.example;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.FileOutputStream;

public class FutureEducationInfoActivity extends Activity {
    private final Context context = this;

    private EditText enterSchoolName;
    private Spinner enterDegree;
    private EditText enterProgram;
    private Spinner enterEnrollmentStatus;
    private EditText enterApplicationDate;
    private Spinner enterApplicationStatus;
    private Button submit;
    private TextView error;

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
                String enteredSchool = enterSchoolName.getText().toString();
                String enteredDegree = enterDegree.getSelectedItem().toString();
                String enteredProgram = enterProgram.getText().toString();
                String enteredEnroll = enterEnrollmentStatus.getSelectedItem().toString();
                String enteredAppDate = enterApplicationDate.getText().toString();
                String enteredAppStat = enterApplicationStatus.getSelectedItem().toString();

                //make sure all fields are filled in
                if (enteredSchool.equals("") || enteredProgram.equals("")) {
                    error.setVisibility(View.VISIBLE);
                } else {
                    error.setVisibility(View.INVISIBLE);

                    School school = new School(0); //Databse sets id automatically
                    school.set_schoolName(enteredSchool);
                    school.set_degreeType(enteredDegree);
                    school.set_program(enteredProgram);
                    school.set_enrollment(enteredEnroll);
                    school.set_appDate(enteredAppDate);
                    school.set_appStat(enteredAppStat);
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
        enterSchoolName = (EditText) findViewById(R.id.etFSchoolName);
        enterDegree = (Spinner) findViewById(R.id.spFDegree);
        ArrayAdapter<CharSequence> spinnerMenuList = ArrayAdapter.createFromResource(context, R.array.DEGREE_TYPE, android.R.layout.simple_spinner_item);
        spinnerMenuList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        enterDegree.setAdapter(spinnerMenuList);

        enterProgram = (EditText) findViewById(R.id.etFProgram);

        enterEnrollmentStatus = (Spinner) findViewById(R.id.spFEnrollment);
        ArrayAdapter<CharSequence> spinnerMenuList2 = ArrayAdapter.createFromResource(context, R.array.ENROLLMENT_STATUS, android.R.layout.simple_spinner_item);
        spinnerMenuList2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        enterEnrollmentStatus.setAdapter(spinnerMenuList2);

        enterApplicationDate = (EditText) findViewById(R.id.etApplicationDate);
        enterApplicationStatus = (Spinner) findViewById(R.id.spAppStatus);
        ArrayAdapter<CharSequence> spinnerMenuList3 = ArrayAdapter.createFromResource(context, R.array.APP_STATUS, android.R.layout.simple_spinner_item);
        spinnerMenuList3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        enterApplicationStatus.setAdapter(spinnerMenuList3);

        error = (TextView) findViewById(R.id.error);
        submit = (Button) findViewById(R.id.bFuEdSubmit);

    }

}
