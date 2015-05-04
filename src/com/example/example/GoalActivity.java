package com.example.example;

import java.util.List;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class GoalActivity extends Activity {
	private Context context = this;
	Button add, delete, back;
	DatabaseHelper db;
	List<Goal> stgList, ltgList;
	CheckBox[] b, c;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_goal);
		db = new DatabaseHelper(this);
		// Cursor c = db.getAllGoal();

		stgList = db.getAllShortTermGoal();
		ltgList = db.getAllLongTermGoal();
		LinearLayout lls = (LinearLayout) findViewById(R.id.llGSTG);
		LinearLayout lll = (LinearLayout) findViewById(R.id.llGLTG);

		b = new CheckBox[stgList.size()];

		for (int i = 0; i < stgList.size(); i++) {
			final int index = i;
			b[i] = new CheckBox(getApplicationContext());
			String name = stgList.get(index).getName();
			b[i].setText(name);
			b[i].setTextColor(Color.BLUE);

			lls.addView(b[i]);
		}

		c = new CheckBox[ltgList.size()];

		for (int i = 0; i < ltgList.size(); i++) {
			final int index = i;
			c[i] = new CheckBox(getApplicationContext());
			String name = ltgList.get(index).getName();
			c[i].setText(name);
			c[i].setTextColor(Color.BLUE);

			lll.addView(c[i]);
		}

		

			/*
			 * if (type.matches(GoalType.SHORT_TERM.toString())){ String str =
			 * "Short-Term Goal: " + name + "\n";
			 * 
			 * tv.setText(str); tv.setTextSize(20); tv.setPadding(15, 15, 15,
			 * 15); ll.addView(tv); } if
			 * (type.matches(GoalType.LONG_TERM.toString())){ String str =
			 * "Long-Term Goal: " + name + "\n";
			 * 
			 * tv.setText(str); tv.setTextSize(20); tv.setPadding(15, 15, 15,
			 * 15); ll.addView(tv); }
			 */

		

		add = (Button) findViewById(R.id.bGadd);

		add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final Dialog dialog = new Dialog(context);
				dialog.setContentView(R.layout.dialog_goal_entry);
				dialog.setTitle("Career Goal");
				
				Button save = (Button) dialog.findViewById(R.id.bGsave);
				save.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						RadioButton stgButton, ltgButton;
						EditText stgEntry = (EditText) dialog.findViewById(R.id.etGoalEntry);
						stgButton = (RadioButton) dialog.findViewById(R.id.rbSTG);
						ltgButton = (RadioButton) dialog.findViewById(R.id.rbLTG);
						String type = null;//= "SHORT_TERM";
						if (stgButton.isChecked())
							type = "SHORT_TERM";
						if (ltgButton.isChecked())
							type = "LONG_TERM";
						Goal goal = new Goal(0);
						goal.setType(type);
						goal.setName(stgEntry.getText().toString());
						db.addGoal(goal);
						dialog.dismiss();
						recreate();
						/*
						 * String text = "Your goal is saved.";
						 * Toast.makeText(context, text, Toast.LENGTH_LONG);
						 */
					}
					
				});
				dialog.show();
			}
		});
		
		delete = (Button) findViewById(R.id.bGdelete);
		delete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				for (int i = 0; i < stgList.size(); i++) {
					final int index = i;
					if (b[index].isChecked()) {
						db.deleteCareerGoal(stgList.get(index).get_id());
						recreate();
					}

				}
				
				for (int i = 0; i < ltgList.size(); i++) {
					final int index = i;
					if (c[index].isChecked()) {
						db.deleteCareerGoal(ltgList.get(index).get_id());
						recreate();
					}

				}
			}
		});
		
		back = (Button) findViewById(R.id.bGback);

		back.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent startCareer = new Intent(GoalActivity.this,
						CareerActivity.class);
				startActivity(startCareer);
				finish(); // need to change of modify this
			}

		});

	}
}