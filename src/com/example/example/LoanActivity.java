package com.example.example;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class LoanActivity extends Activity {
    String companyName;
    String amount;
    String appStat;
    private List<Loan> loans;

    @Override
    protected void onCreate(Bundle noneState) {
        // TODO Auto-generated method stub
        super.onCreate(noneState);
        setContentView(R.layout.activity_none);

        Button enter = (Button) findViewById(R.id.bEnter);
        TextView label = (TextView) findViewById(R.id.tvNone);
        enter.setText("Add");
        label.setText("Loans");

        LinearLayout ll = (LinearLayout) findViewById(R.id.NoneLayout);

        final DatabaseHelper db = new DatabaseHelper(this);

        loans = db.getAllLoans();

        //dynamically add buttons
        Button[] tv = new Button[loans.size()];
        for (int i = 0; i < loans.size(); i++) {
            final int index = i;
            tv[i] = new Button(getApplicationContext());
            tv[i].setText(loans.get(index).getCompanyName());
            tv[i].setTextSize(20);
            tv[i].setPadding(15, 15, 15, 15);
            tv[i].setOnClickListener(new OnClickListener() {

                public void onClick(View v) {
                    Intent j = new Intent(LoanActivity.this, DisplayLoanActivity.class);
                    j.putExtra("lenderName", "" + loans.get(index).getCompanyName());
                    Log.d("CLIP_DEBUG:: -- ", "" + loans.get(index).getAmount());
                    j.putExtra("amount", loans.get(index).getAmount());
                    j.putExtra("status", loans.get(index).getApplicationStatus().toString());
                    startActivity(j);
                }
            });
            tv[i].setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    db.deleteLoan(loans.get(index).getId());
                    ViewGroup parentView = (ViewGroup) v.getParent();
                    parentView.removeView(v);
                    return true;
                }
            });
            ll.addView(tv[i]);
        }

        //displays a text view when user hasn't entered any current education
        if (loans.size() == 0) {
            TextView none;
            none = new TextView(getApplicationContext());
            none.setText("You're all paid off!");
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

                Intent j = new Intent(LoanActivity.this, EducationActivity.class);
                startActivity(j);

            }

        });

        enter.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent(LoanActivity.this, LoanInfoActivity.class);
                startActivity(i);
            }

        });

    }
}
