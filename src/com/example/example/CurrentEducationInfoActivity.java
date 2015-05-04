package com.example.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CurrentEducationInfoActivity extends Activity {
//    public FileOutputStream fCuEdInfo = null;

    private EditText enterSchoolName;
    private EditText enterDegree;
    private EditText enterProgram;
    private EditText enterEnrollmentStatus;
    private EditText enterTuition;
    private EditText enterCourse;
    private EditText enterDateStart;
    private EditText enterDateGraduate;
    private Button submit;
    private TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_education_info);

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
                String enteredTuition = enterTuition.getText().toString();
                String enteredCourse= enterCourse.getText().toString();
                String enteredDateStart = enterDateStart.getText().toString();
                String enteredDateGrad = enterDateGraduate.getText().toString();

                //make sure all fields are filled in
                if(enteredSchool.equals("") || enteredDegree.equals("") || enteredProgram.equals("") || enteredEnroll.equals("") ||
                        enteredTuition.equals("") || enteredCourse.equals("") || enteredDateStart.equals("") || enteredDateGrad.equals(""))
                {
                    error.setText("Please fill all fields...");
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
                    school.set_dateStart(enteredDateStart);
                    school.set_dateGrad(enteredDateGrad);
                    school.set_tuition(enteredTuition);
                    school.set_course(enteredCourse);
//                    school.set_type("CURRENT");  -- Type set by addSchool
                    db.addSchool_Current(school);

                    Intent j = new Intent(CurrentEducationInfoActivity.this, CurrentEducationActivity.class);
                    j.putExtra("schoolName", enteredSchool);
                    j.putExtra("degreeType", enteredDegree);
                    j.putExtra("program", enteredProgram);
                    j.putExtra("enrollment", enteredEnroll);
                    j.putExtra("tuition", enteredTuition);
                    j.putExtra("course", enteredCourse);
                    j.putExtra("dateStart", enteredDateStart);
                    j.putExtra("dateGrad", enteredDateGrad);
                    startActivity(j);
                    finish();
                }


            }

        });
    }

    private void setUpVariables() {
        enterSchoolName = (EditText) findViewById(R.id.etSchoolName);
        enterDegree = (EditText) findViewById(R.id.etDegree);
        enterProgram = (EditText) findViewById(R.id.etProgram);
        enterEnrollmentStatus = (EditText) findViewById(R.id.etEnrollmentStatus);
        enterCourse = (EditText) findViewById(R.id.etCourse);
        enterDateStart = (EditText) findViewById(R.id.etDateStart);
        enterDateGraduate = (EditText) findViewById(R.id.etDateGraduate);
        submit = (Button) findViewById(R.id.bCuEdSubmit);
        error = (TextView) findViewById(R.id.error);

    }

}
