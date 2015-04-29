package com.example.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayLoanActivity extends Activity {
    TextView name;
    TextView amount;
    TextView appStatus;


    String companyName;
    String amt;
    String appStat;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_loan);

        //get information from previous activity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            companyName = extras.getString("name");
            amt = extras.getString("amt");
            appStat = extras.getString("appStat");


        }

        //connect text views to xml
        name = (TextView) findViewById(R.id.tvDisplayCompanyName);
        amount = (TextView) findViewById(R.id.tvDisplayLoanAmount);
        appStatus = (TextView) findViewById(R.id.tvDisplayLoanApplicationStatus);

        //set text views to passed in text values
        name.setText(companyName);
        amount.setText(amt);
        appStatus.setText(appStat);


    }

}
