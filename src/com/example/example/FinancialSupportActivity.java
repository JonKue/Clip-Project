package com.example.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FinancialSupportActivity extends Activity{


    @Override
    protected void onCreate(Bundle financialSupportState) {
        super.onCreate(financialSupportState);
        setContentView(R.layout.activity_financial_support);

        Button scholarship = (Button) findViewById(R.id.bScholarship);
        Button loan = (Button) findViewById(R.id.bLoan);


        scholarship.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent startScholarship = new Intent(FinancialSupportActivity.this, ScholarshipActivity.class);
                startActivity(startScholarship);
                // finish();
            }
        });

        loan.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent startLoan = new Intent(FinancialSupportActivity.this, LoanActivity.class);
                startActivity(startLoan);
                // finish();
            }
        });
    }
}
