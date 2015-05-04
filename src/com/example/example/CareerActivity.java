package com.example.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CareerActivity extends Activity{
    private Button goal, jobSearch, comInfo, elecIdentity, contactList;

    @Override
    protected void onCreate(Bundle careerState) {
        super.onCreate(careerState);
        setContentView(R.layout.activity_career);

        setUpVariables();

        goal.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent startGoal = new Intent(CareerActivity.this, GoalActivity.class);
                startActivity(startGoal);
            }
        });

        jobSearch.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent startJobSearch = new Intent(CareerActivity.this, JobSearchActivity.class);
                startActivity(startJobSearch);
            }
        });

        comInfo.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent startCompanyInfo = new Intent(CareerActivity.this, CompanyInfoActivity.class);
                startActivity(startCompanyInfo);
            }
        });

        elecIdentity.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent startElectronicIdentity = new Intent(CareerActivity.this, ElectronicIdentityActivity.class);
                startActivity(startElectronicIdentity);
            }
        });

        contactList.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent startContactList = new Intent(CareerActivity.this, ContactListActivity.class);
                startActivity(startContactList);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        //inflate.inflate(R.menu.health, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setUpVariables(){
        goal = (Button) findViewById(R.id.bGoal);
        jobSearch = (Button) findViewById(R.id.bJobSearch);
        comInfo = (Button) findViewById(R.id.bCompanyInfo);
        elecIdentity = (Button) findViewById(R.id.bElectronicIdentity);
        contactList = (Button) findViewById(R.id.bContactList);
    }
}
