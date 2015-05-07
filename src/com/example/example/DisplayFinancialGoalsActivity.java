package com.example.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayFinancialGoalsActivity extends Activity {


    private String entName;
    private String entDesc;
    private String entType;
    private String entDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_financial_goals);

        //get information from previous activity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            entName = extras.getString("name");
            entDesc = extras.getString("desc");
            entType = extras.getString("type");
            entDate = extras.getString("date");


        }

        //connect text views to xml
        TextView name = (TextView) findViewById(R.id.tvDisplayFGoalName);
        TextView desc = (TextView) findViewById(R.id.tvDisplayFGoalDesc);
        TextView type = (TextView) findViewById(R.id.tvDisplayFGoalType);
        TextView date = (TextView) findViewById(R.id.tvDisplayFGoalDate);


        //set text views to passed in text values
        name.setText(entName);
        desc.setText(entDesc);
        type.setText(entType);
        date.setText(entDate);


    }

}