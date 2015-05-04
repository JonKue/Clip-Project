package com.example.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayScholarshipActivity extends Activity {


    private String companyName;
    private String reqs;
    private String amt;
    private String appStat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_scholarship);

        //get information from previous activity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            companyName = extras.getString("scholarshipName");
            reqs = extras.getString("requirements");
            int am = extras.getInt("amount");
            amt = am + "";
            appStat = extras.getString("status");
        }

        //connect text views to xml
        TextView name = (TextView) findViewById(R.id.tvDisplayCompanyName);
        TextView requirements = (TextView) findViewById(R.id.tvDisplayRequirements);
        TextView amount = (TextView) findViewById(R.id.tvDisplayLoanAmount);
        TextView appStatus = (TextView) findViewById(R.id.tvDisplayLoanApplicationStatus);

        //set text views to passed in text values
        name.setText(companyName);
        requirements.setText(reqs);
        amount.setText(amt);
        appStatus.setText(appStat);


    }

}
