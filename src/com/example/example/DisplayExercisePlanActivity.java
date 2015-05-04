package com.example.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DisplayExercisePlanActivity extends Activity{

    private String exercisePlan;
    private String routine;
    private String startTime;
    private String endTime;
    private String otherInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_exercise_plan);

        // get information from previous activity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {


            exercisePlan = extras.getString("exercisePlan");
            routine = extras.getString("routine");
            startTime = extras.getString("startTime");
            endTime = extras.getString("endTime");
            otherInfo = extras.getString("otherInfo");

        }

        // connect text views to xml
        TextView name = (TextView) findViewById(R.id.tvDEPplanName);
        TextView routDate = (TextView) findViewById(R.id.tvDEProutDate);
        TextView des = (TextView) findViewById(R.id.tvDEPdes);

        // set text views to passed in text values
        name.setText("Exercise Plan: Do " + exercisePlan);
        routDate.setText(routine + " from " + startTime + " to " + endTime);
        des.setText(otherInfo);

        Button back = (Button) findViewById(R.id.bDEPback);

        back.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent startHealth = new Intent(DisplayExercisePlanActivity.this,
                        ExercisePlanActivity.class);
                startActivity(startHealth);
                finish(); // need to change of modify this
            }

        });

    }
}
