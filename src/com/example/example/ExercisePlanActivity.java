package com.example.example;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

//import android.widget.TextView;

public class ExercisePlanActivity extends Activity {

	private final Context context = this;
	String exercisePlan;
	String routine;
	String startTime;
	String endTime;
	String otherInfo;
	private DatabaseHelper db;
	private List<ExercisePlan> epList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercise_plan);

		db = new DatabaseHelper(this);
		LinearLayout ll = (LinearLayout) findViewById(R.id.llEP);
		epList = db.getAllExercisePlan();

		// Dynamically add buttons

		TextView tv;

		if (epList.size() == 0) {
			tv = new TextView(getApplicationContext());
			tv.setText("None");
			tv.setTextSize(20);
			tv.setPadding(15, 15, 15, 15);
			ll.addView(tv);
		} else {
			Button[] b = new Button[epList.size()];
			for (int i = 0; i < epList.size(); i++) {
				final int index = i;
				b[i] = new Button(getApplicationContext());
				b[i].setText(epList.get(index).getExerciseName());
				b[i].setTextSize(20);
				b[i].setPadding(15, 15, 15, 15);
				b[i].setOnClickListener(new OnClickListener() {

					public void onClick(View v) {
						Intent j = new Intent(ExercisePlanActivity.this,
								DisplayExercisePlanActivity.class);
						j.putExtra("exercisePlan", epList.get(index)
								.getExerciseName());
						j.putExtra("routine", epList.get(index).getRoutine());
						j.putExtra("startTime", epList.get(index)
								.getStartTime());
						j.putExtra("endTime", epList.get(index).getEndTime());
						j.putExtra("otherInfo", epList.get(index)
								.getOtherInfo());

						startActivity(j);
					}
				});
				b[i].setOnLongClickListener(new View.OnLongClickListener() {
					@Override
					public boolean onLongClick(View v) {
						db.deleteMedication(epList.get(index).get_id());
						ViewGroup parentView = (ViewGroup) v.getParent();
						parentView.removeView(v);
						return true;
					}
				});
				ll.addView(b[i]);
			}
		}

		Button add = (Button) findViewById(R.id.bEPadd);

		add.setOnClickListener(new OnClickListener() {
			// TextView name, otherInfo;
			EditText nameEntry, startTime, endTime, otherInfoEntry;

			/*
			 * Spinner routine; TimePicker st, et;
			 */
			Button save;

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setContentView(R.layout.activity_exercise_plan_info);
				setUpVariable();
				final Spinner routine = (Spinner) findViewById(R.id.sEProutine);

				ArrayAdapter<CharSequence> spinnerMenuList = ArrayAdapter
						.createFromResource(context, R.array.ROUTINE,
								android.R.layout.simple_spinner_item);
				spinnerMenuList
						.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				routine.setAdapter(spinnerMenuList);

				save.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						ExercisePlan ep = new ExercisePlan(0);
						ep.setExerciseName(nameEntry.getText().toString());
						ep.setRoutine(routine.getSelectedItem().toString());
						ep.setStartTime(startTime.getText().toString());
						ep.setEndTime(endTime.getText().toString());
						ep.setOtherInfo(otherInfoEntry.getText().toString());
						db.addExercisePlan(ep);
						recreate();
					}
				});
			}

			public void setUpVariable() {
				// name = (TextView) findViewById(R.id.tvEPname);
				// otherInfo = (TextView) findViewById(R.id.tvEPotherInfo);
				nameEntry = (EditText) findViewById(R.id.etEPname);

				startTime = (EditText) findViewById(R.id.etEPstarttime);
				endTime = (EditText) findViewById(R.id.etEPendtime);
				otherInfoEntry = (EditText) findViewById(R.id.etEPotherInfo);
				save = (Button) findViewById(R.id.bEPsave);

			}

		});

		Button back = (Button) findViewById(R.id.bEPback);

		back.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent startHealth = new Intent(ExercisePlanActivity.this,
						HealthActivity.class);
				startActivity(startHealth);
				finish(); // need to change of modify this
			}

		});

	}

}

/*
 * String[] items = new String[]{"NONE","DAILY","WEEKLY","MONTHLY"};
 * ArrayAdapter<String> adapter = new
 * ArrayAdapter<String>(ExercisePlanActivity,android
 * .R.layout.simple_spinner_item, items);
 * adapter.setDropDownViewResource(android
 * .R.layout.simple_spinner_dropdown_item); routine.setAdapter(adapter);
 * 
 * 
 * 
 * startTime.setOnClickListener(new OnClickListener() {
 * 
 * @Override public void onClick(View v) { // TODO Auto-generated method stub
 * final Dialog dialog = new Dialog(context);
 * dialog.setContentView(R.layout.dialog_pick_time);
 * dialog.setTitle("Set Time"); Button done = (Button) dialog
 * .findViewById(R.id.bEPtimeDone);
 * 
 * 
 * done.setOnClickListener(new OnClickListener() {
 * 
 * @Override public void onClick(View v) { // TODO Auto-generated method stub st
 * = (TimePicker) dialog .findViewById(R.id.tpEPtime);
 * 
 * dialog.dismiss(); // need implementaion here....... } }); dialog.show(); }
 * });
 * 
 * endTime.setOnClickListener(new OnClickListener() {
 * 
 * @Override public void onClick(View v) { // TODO Auto-generated method stub
 * final Dialog dialog = new Dialog(context);
 * dialog.setContentView(R.layout.dialog_pick_time);
 * dialog.setTitle("Set Time"); Button done = (Button) dialog
 * .findViewById(R.id.bEPtimeDone);
 * 
 * 
 * done.setOnClickListener(new OnClickListener() {
 * 
 * @Override public void onClick(View v) { // TODO Auto-generated method stub et
 * = (TimePicker) dialog .findViewById(R.id.tpEPtime);
 * 
 * dialog.dismiss(); // need implementaion here....... } }); dialog.show(); }
 * });
 */