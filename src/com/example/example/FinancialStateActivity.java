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

public class FinancialStateActivity extends Activity {
    private List<FinancialState> states;

    @Override
    protected void onCreate(Bundle nonestates) {
        // TODO Auto-generated method stub
        super.onCreate(nonestates);

        final DatabaseHelper db = new DatabaseHelper(this);
        //get states from database
        states = db.getAllStates();

        //get information from add financial state
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String cash = extras.getString("cash");
            String assets = extras.getString("assets");
            String liabilities = extras.getString("liabilities");
            String creditCards = extras.getString("creditCards");
            String other = extras.getString("other");

            states.add(new FinancialState(0));

            //set information for current education at the end of the array list
            states.get(states.size() - 1).setCash(cash);
            states.get(states.size() - 1).setAssets(assets);
            states.get(states.size() - 1).setLiabilities(liabilities);
            states.get(states.size() - 1).setCreditCards(creditCards);
            states.get(states.size() - 1).setOther(other);


        }
        setContentView(R.layout.activity_none);

        Button enter = (Button) findViewById(R.id.bEnter);
        TextView label = (TextView) findViewById(R.id.tvNone);
        enter.setText("Add");
        label.setText("Current Financial states");

        //for dynamic update of GUI
        LinearLayout ll = (LinearLayout) findViewById(R.id.NoneLayout);

        //dynamically add buttons
        Button[] tv = new Button[states.size()];
        for (int i = 0; i < states.size(); i++) {
            final int index = i;
            tv[i] = new Button(getApplicationContext());
            tv[i].setText(states.get(i).getDate());
            tv[i].setTextSize(20);
            tv[i].setPadding(15, 5, 15, 5);
            tv[i].setOnClickListener(new OnClickListener() {

                public void onClick(View v) {
                    Intent j = new Intent(FinancialStateActivity.this, DisplayFinancialStateActivity.class);
                    j.putExtra("cash", String.valueOf(states.get(index).getCash()));
                    j.putExtra("assets", states.get(index).getAssets());
                    j.putExtra("liabilities", states.get(index).getLiabilities());
                    j.putExtra("creditCards", states.get(index).getCreditCards());
                    j.putExtra("other", states.get(index).getOther());
                    startActivity(j);
                }
            });
            tv[i].setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    db.deleteState(states.get(index).get_id());
                    ViewGroup parentView = (ViewGroup) v.getParent();
                    parentView.removeView(v);
                    return true;
                }
            });
            ll.addView(tv[i]);

        }

        //displays a text view when user hasn't entered any financial states
        if (states.size() == 0) {
            TextView none;
            none = new TextView(getApplicationContext());
            none.setText("No financial states at this time. Try entering some!");
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

                Intent j = new Intent(FinancialStateActivity.this, FinanceActivity.class);
                startActivity(j);

            }

        });


        enter.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent(FinancialStateActivity.this, FinancialStateInfoActivity.class);
                startActivity(i);
                finish();    // need to change of modify this
            }

        });

    }
}

