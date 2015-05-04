package com.example.example;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class GoalActivity extends Activity {
    private final Context context = this;
    EditText goalEntry;
    private RadioButton stgButton;
    private RadioButton ltgButton;
    private Button save;
    private Button done;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);
        db = new DatabaseHelper(this);
        Cursor c = db.getAllGoal();

        // for dynamic update of GUI
        TextView tv;
        LinearLayout ll = (LinearLayout) findViewById(R.id.llGoal);

        if (c.getCount() == 0) {
            tv = new TextView(getApplicationContext());
            tv.setText("None");
            tv.setTextSize(20);
            tv.setPadding(15, 15, 15, 15);
            ll.addView(tv);
        } else {
            int count = 1;
            while (c.moveToNext()) {
                tv = new TextView(getApplicationContext());
                String type = c.getString(0);
                String name = c.getString(1);

                String str = type + ": " + name;
                tv.setText(str);
                ll.addView(tv);
                /*
				if (type.matches(GoalType.SHORT_TERM.toString())){
					String str = "Short-Term Goal: " + name 
							+ "\n";
					
					tv.setText(str);
					tv.setTextSize(20);
					tv.setPadding(15, 15, 15, 15);
					ll.addView(tv);
				}
				if (type.matches(GoalType.LONG_TERM.toString())){
					String str = "Long-Term Goal: " + name 
							+ "\n";
					
					tv.setText(str);
					tv.setTextSize(20);
					tv.setPadding(15, 15, 15, 15);
					ll.addView(tv);
				}
				*/
                count++;
            }
        }

        Button add = (Button) findViewById(R.id.bGadd);

        add.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                setContentView(R.layout.activity_goal_entry);

                setUpVariables();

                save.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        EditText stgEntry = (EditText) findViewById(R.id.etGoalEntry);
                        GoalType type;
                        if (stgButton.isChecked())
                            type = GoalType.SHORT_TERM;
                        else
                            type = GoalType.LONG_TERM;
                        Goal goal = new Goal();
                        goal.setType(type);
                        goal.setName(stgEntry.getText().toString());
                        db.addGoal(goal);
                        String text = "Your goal is saved.";
                        Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
                        toast.show();
                    }
                });

                done.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub

                        recreate();
                        // need implementaion here.......
                        // save data in database
                        // Display data in Goal Activity
                    }
                });
            }

            private void setUpVariables() {
                stgButton = (RadioButton) findViewById(R.id.rbSTG);
                ltgButton = (RadioButton) findViewById(R.id.rbLTG);
                save = (Button) findViewById(R.id.bGsave);
                done = (Button) findViewById(R.id.bGdone);
            }
        });

    }

}