package com.example.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayCurrentEducationActivity extends Activity {

    private String schoolName;
    private String degreeType;
    private String program;
    private String enrollment;
    private String dateStart;
    private String dateGrad;
    private String tuition;
    private String course;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_current_education);

        //get information from previous activity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            schoolName = extras.getString("schoolName");
            degreeType = extras.getString("degreeType");
            program = extras.getString("program");
            enrollment = extras.getString("enrollment");
            dateStart = extras.getString("dateStart");
            dateGrad = extras.getString("dateGrad");
            tuition = extras.getString("tuition");
            course = extras.getString("course");

        }

        //connect text views to xml
        TextView name = (TextView) findViewById(R.id.tvDisplayFSchoolName);
        TextView type = (TextView) findViewById(R.id.tvDisplayFDegree);
        TextView prog = (TextView) findViewById(R.id.tvDisplayFProgram);
        TextView enroll = (TextView) findViewById(R.id.tvDisplayFES);
        TextView sDate = (TextView) findViewById(R.id.tvDisplayDateStarted);
        TextView gDate = (TextView) findViewById(R.id.tvDisplayDateGrad);
        TextView tuit = (TextView) findViewById(R.id.tvDisplayAppDate);
        TextView cour = (TextView) findViewById(R.id.tvDisplayAppStat);

        //set text views to passed in text values
        name.setText(schoolName);
        type.setText(degreeType);
        prog.setText(program);
        enroll.setText(enrollment);
        sDate.setText(dateStart);
        gDate.setText(dateGrad);
        tuit.setText(tuition);
        cour.setText(course);

    }

}
