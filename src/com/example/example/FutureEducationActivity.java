package com.example.example;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class FutureEducationActivity extends Activity {
    String schoolName;
    String degreeType;
    String program;
    String enrollment;
    String appDate;
    String appStat;
    private List<School> plan;

    @Override
    protected void onCreate(Bundle noneState) {
        // TODO Auto-generated method stub
        super.onCreate(noneState);

        setContentView(R.layout.activity_none);

        Button enter = (Button) findViewById(R.id.bEnter);
        TextView label = (TextView) findViewById(R.id.tvNone);
        enter.setText("Add");
        label.setText("Future Education");
        LinearLayout ll = (LinearLayout) findViewById(R.id.NoneLayout);

        final DatabaseHelper db = new DatabaseHelper(this);

        plan = db.getAllFutureSchools();

        //dynamically add buttons
        Button[] tv = new Button[plan.size()];
        for (int i = 0; i < plan.size(); i++) {
            final int index = i;
            tv[i] = new Button(getApplicationContext());
            tv[i].setText(plan.get(index).toString());
            tv[i].setTextSize(20);
            tv[i].setPadding(15, 15, 15, 15);
            tv[i].setBackgroundColor(Color.WHITE);
            tv[i].setTextColor(Color.BLACK);
            tv[i].setOnClickListener(new OnClickListener() {

                public void onClick(View v) {
                    Intent j = new Intent(FutureEducationActivity.this, DisplayFutureEducationActivity.class);
                    j.putExtra("schoolName", plan.get(index).get_schoolName());
                    j.putExtra("degreeType", plan.get(index).get_degreeType());
                    j.putExtra("program", plan.get(index).get_program());
                    j.putExtra("enrollment", plan.get(index).get_enrollment());
                    j.putExtra("appDate", plan.get(index).get_appDate());
                    j.putExtra("appStat", plan.get(index).get_appStat());
                    startActivity(j);
                }
            });
            tv[i].setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    db.deleteSchool(plan.get(index).get_id());
                    ViewGroup parentView = (ViewGroup) v.getParent();
                    parentView.removeView(v);
                    return true;
                }
            });
            ll.addView(tv[i]);
        }

        //displays a text view when user hasn't entered any current education
        if (plan.size() == 0) {
            TextView none;
            none = new TextView(getApplicationContext());
            none.setText("No future education at this time. Try entering some!");
            none.setTextSize(20);
            none.setTextColor(Color.BLACK);
            none.setPadding(15, 5, 15, 5);
            ll.addView(none);

        }


        //add a home button at the bottom of the list
        Button back = new Button(getApplicationContext());
        back.setText("Back");
        back.setBackgroundColor(Color.BLUE);
        back.setTextColor(Color.WHITE);
        ll.addView(back);
        //action listener for home button
        back.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent j = new Intent(FutureEducationActivity.this, EducationActivity.class);
                startActivity(j);
            }

        });

        enter.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent startFutureEducationInfo = new Intent(FutureEducationActivity.this, FutureEducationInfoActivity.class);
                startActivity(startFutureEducationInfo);
                finish();    // need to change of modify this
            }

        });

    }
}


