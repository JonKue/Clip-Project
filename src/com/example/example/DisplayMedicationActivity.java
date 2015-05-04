package com.example.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DisplayMedicationActivity extends Activity {
    TextView pillName;
    TextView num;
    TextView date;

    String pill;
    String numDose;
    String dstart;
    String dend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_pill_info);

        // get information from previous activity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            pill = extras.getString("pillName");
            numDose = extras.getString("noDosage");
            dstart = extras.getString("startDate");
            dend = extras.getString("endDate");

        }

        // connect text views to xml
        pillName = (TextView) findViewById(R.id.tvDMpillName);
        num = (TextView) findViewById(R.id.tvDMnumDosage);
        date = (TextView) findViewById(R.id.tvDMdate);

        // set text views to passed in text values
        pillName.setText("Pill Name: " + pill);
        num.setText(numDose + " times a day.");
        date.setText("From " + dstart + " to " + dend);

        Button back = (Button) findViewById(R.id.bDMback);

        back.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent startHealth = new Intent(DisplayMedicationActivity.this,
                        MedicationActivity.class);
                startActivity(startHealth);
                finish(); // need to change of modify this
            }

        });

    }

}
