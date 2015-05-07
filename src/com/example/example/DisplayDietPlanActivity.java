package com.example.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DisplayDietPlanActivity extends Activity {

    private String type;
    private String des;
    private String dstart;
    private String dend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_diet_plan);

        // get information from previous activity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            type = extras.getString("dietType");
            des = extras.getString("dietDescription");
            dstart = extras.getString("startDate");
            dend = extras.getString("endDate");

        }

        // connect text views to xml
        TextView dietType = (TextView) findViewById(R.id.tvDDPdietType);
        TextView description = (TextView) findViewById(R.id.tvDDPdescription);
        TextView date = (TextView) findViewById(R.id.tvDDPdate);

        // set text views to passed in text values
        dietType.setText("Diet Type: " + type);
        description.setText(des);
        date.setText("From " + dstart + " to " + dend);

        Button back = (Button) findViewById(R.id.bDDPback);

        back.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent startHealth = new Intent(DisplayDietPlanActivity.this,
                        DietPlanActivity.class);
                startActivity(startHealth);
                finish(); // need to change of modify this
            }

        });

    }
}
