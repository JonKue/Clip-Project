package com.example.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class EducationActivity extends Activity {

    private Button currentEducation, futureEducation, financialSupport;

    @Override
    protected void onCreate(Bundle educationState) {
        super.onCreate(educationState);
        setContentView(R.layout.education_activity);

        Button currentEducation = (Button) findViewById(R.id.bCurrentEducation),
                futureEducation = (Button) findViewById(R.id.bFutureEducation),
                financialSupport = (Button) findViewById(R.id.bFinancialSupport);

        currentEducation.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent startCurrentEducation = new Intent(EducationActivity.this, CurrentEducationActivity.class);
                startActivity(startCurrentEducation);
                finish();
            }
        });

        futureEducation.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent startFutureEducation = new Intent(EducationActivity.this, FutureEducationActivity.class);
                startActivity(startFutureEducation);
                finish();
            }
        });

        financialSupport.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent startFinancialSupport = new Intent(EducationActivity.this, FinancialSupportActivity.class);
                startActivity(startFinancialSupport);
                finish();
            }
        });
    }

}
