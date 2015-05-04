package com.example.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayCurrentEducationActivity extends Activity {

    TextView name;
    TextView type;
    TextView prog;
    TextView enroll;
    TextView sDate;
    TextView gDate;
    TextView tuit;
    TextView cour;

    String schoolName;
    String degreeType;
    String program;
    String enrollment;
    String dateStart;
    String dateGrad;
    String tuition;
    String course;


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
        name = (TextView) findViewById(R.id.tvDisplayFSchoolName);
        type = (TextView) findViewById(R.id.tvDisplayFDegree);
        prog = (TextView) findViewById(R.id.tvDisplayFProgram);
        enroll = (TextView) findViewById(R.id.tvDisplayFES);
        sDate = (TextView) findViewById(R.id.tvDisplayDateStarted);
        gDate = (TextView) findViewById(R.id.tvDisplayDateGrad);
        tuit = (TextView) findViewById(R.id.tvDisplayAppDate);
        cour = (TextView) findViewById(R.id.tvDisplayAppStat);

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
