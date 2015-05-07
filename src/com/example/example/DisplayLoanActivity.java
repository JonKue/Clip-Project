package com.example.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayLoanActivity extends Activity {


    private String companyName;
    private String amt;
    private String appStat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_loan);

        //get information from previous activity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            companyName = extras.getString("lenderName");
            int am = extras.getInt("amount");
            amt = am + "";
            appStat = extras.getString("status");
        }

        //connect text views to xml
        TextView name = (TextView) findViewById(R.id.tvDisplayCompanyName);
        TextView amount = (TextView) findViewById(R.id.tvDisplayLoanAmount);
        TextView appStatus = (TextView) findViewById(R.id.tvDisplayLoanApplicationStatus);

        //set text views to passed in text values
        name.setText(companyName);
        amount.setText(amt);
        appStatus.setText(appStat);


    }

}
