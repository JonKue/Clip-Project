package com.example.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayFutureEducationActivity extends Activity {

    private String schoolName;
    private String degreeType;
    private String program;
    private String enrollment;
    private String appDate;
    private String appStat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_future_education);

//        final DatabaseHelper db = new DatabaseHelper(this);
////        List<School> plan = db.getAllFutureSchools();

        //get information from previous activity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            schoolName = extras.getString("schoolName");
            degreeType = extras.getString("degreeType");
            program = extras.getString("program");
            enrollment = extras.getString("enrollment");
            appDate = extras.getString("appDate");
            appStat = extras.getString("appStat");
        }

        //connect text views to xml
        TextView name = (TextView) findViewById(R.id.tvDisplayFSchoolName);
        TextView type = (TextView) findViewById(R.id.tvDisplayFDegree);
        TextView prog = (TextView) findViewById(R.id.tvDisplayFProgram);
        TextView enroll = (TextView) findViewById(R.id.tvDisplayFES);
        TextView aDate = (TextView) findViewById(R.id.tvDisplayAppDate);
        TextView aStat = (TextView) findViewById(R.id.tvDisplayAppStat);

        //set text views to passed in text values
        name.setText(schoolName);
        type.setText(degreeType);
        prog.setText(program);
        enroll.setText(enrollment);
        aDate.setText(appDate);
        aStat.setText(appStat);

    }

}
