package com.example.clip;

import java.util.List;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class DietPlanActivity extends Activity {

	private Context context = this;
	private Button add, back;
	DatabaseHealthHelper db;

	String dietType;
	String dietDescription;
	String startDate;
	String dateEnd;
	List<Diet> dpList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_diet_plan);

		db = new DatabaseHealthHelper(this);
		LinearLayout ll = (LinearLayout) findViewById(R.id.llDP);
		dpList = db.getAllDietPlan();

		// Dynamically add buttons
		Button[] b = new Button[dpList.size()];
		for (int i = 0; i < dpList.size(); i++) {
			final int index = i;
			b[i] = new Button(getApplicationContext());
			b[i].setText(dpList.get(index).getDietType());
			b[i].setTextSize(20);
			b[i].setPadding(15, 15, 15, 15);
			b[i].setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					Intent j = new Intent(DietPlanActivity.this,
							DisplayDietPlanActivity.class);
					j.putExtra("dietType", dpList.get(index).getDietType());
					j.putExtra("dietDescription", dpList.get(index)
							.getOtherInfo());
					j.putExtra("startDate", dpList.get(index).getStartDate());
					j.putExtra("endDate", dpList.get(index).getEndDate());

					startActivity(j);
				}
			});
			b[i].setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View v) {
					db.deleteMedication(dpList.get(index).get_id());
					ViewGroup parentView = (ViewGroup) v.getParent();
					parentView.removeView(v);
					return true;
				}
			});
			ll.addView(b[i]);

		}

		add = (Button) findViewById(R.id.bDPadd);

		add.setOnClickListener(new OnClickListener() {

			EditText dietTypeEntry, dietDescriptionEntry, startDateEntry,
					endDateEntry;
			Button save;

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final Dialog dialog = new Dialog(context);
				dialog.setContentView(R.layout.dialog_diet_plan_info);
				dialog.setTitle("Add Diet Plan");

				dietTypeEntry = (EditText) dialog.findViewById(R.id.etDPtype);
				dietDescriptionEntry = (EditText) dialog
						.findViewById(R.id.etDPdescription);
				startDateEntry = (EditText) dialog
						.findViewById(R.id.etDPstartDate);
				endDateEntry = (EditText) dialog.findViewById(R.id.etDPendDate);

				save = (Button) dialog.findViewById(R.id.bDPsave);

				save.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Diet dietPlan = new Diet(0);
						dietPlan.setDietType(dietTypeEntry.getText().toString());
						dietPlan.setOtherInfo(dietDescriptionEntry.getText()
								.toString());
						dietPlan.setStartDate(startDateEntry.getText()
								.toString());
						dietPlan.setEndDate(endDateEntry.getText().toString());

						db.addDietPlan(dietPlan);
						;
						dialog.dismiss();
						// need implementaion here.......
						recreate();
					}
				});
				dialog.show();
			}

		});

		back = (Button) findViewById(R.id.bDPback);

		back.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent startHealth = new Intent(DietPlanActivity.this,
						HealthActivity.class);
				startActivity(startHealth);
				finish(); // need to change of modify this
			}

		});
	}
}

/*
 * startDate.setOnClickListener(this); endDate.setOnClickListener(this);
 * monday.setOnClickListener(this); tuesday.setOnClickListener(this);
 * wednesday.setOnClickListener(this); thursday.setOnClickListener(this);
 * friday.setOnClickListener(this); saturday.setOnClickListener(this);
 * sunday.setOnClickListener(this);
 */
/*
 * @Override public void onClick(View v) { // TODO Auto-generated method stub
 * switch (v.getId()) { case R.id.bDPstartDate: chooseTime(); // May need to
 * modify to get data break; case R.id.bDPendDate: chooseTime(); // May need to
 * modify to get data break; case R.id.bDPmonday: dietPlanInfo(); break; case
 * R.id.bDPtuesday: dietPlanInfo(); break; case R.id.bDPwednesday:
 * dietPlanInfo(); break; case R.id.bDPthursday: dietPlanInfo(); break; case
 * R.id.bDPfriday: dietPlanInfo(); break; case R.id.bDPsaturday: dietPlanInfo();
 * break; case R.id.bDPsunday: dietPlanInfo(); break; }
 * 
 * }
 * 
 * public void chooseTime() { final Dialog dialog = new Dialog(context);
 * dialog.setContentView(R.layout.dialog_pick_date);
 * dialog.setTitle("Set Date"); Button set = (Button)
 * dialog.findViewById(R.id.bDPsetDate); DatePicker date = (DatePicker)
 * dialog.findViewById(R.id.dpDPselectDate);
 * 
 * set.setOnClickListener(new OnClickListener() {
 * 
 * @Override public void onClick(View v) { // TODO Auto-generated method stub
 * dialog.dismiss(); // need implementaion here....... } }); dialog.show(); }
 * 
 * public void dietPlanInfo() { final Dialog dialog = new Dialog(context);
 * dialog.setContentView(R.layout.dialog_diet_plan_info);
 * dialog.setTitle("Meal Plan"); Spinner meal = (Spinner)
 * dialog.findViewById(R.id.sDPmeal); TextView description = (TextView) dialog
 * .findViewById(R.id.tvDPdescription); EditText descriptionEntry = (EditText)
 * dialog .findViewById(R.id.etDPdescription); Button save = (Button)
 * dialog.findViewById(R.id.bDPsave); Button done = (Button)
 * dialog.findViewById(R.id.bDPdone);
 * 
 * done.setOnClickListener(new OnClickListener() {
 * 
 * @Override public void onClick(View v) { // TODO Auto-generated method stub
 * dialog.dismiss(); // need implementaion here....... } });
 */