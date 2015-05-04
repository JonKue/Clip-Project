package com.example.example;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FinancialGoalsActivity extends Activity {

	private List<FinanceGoal> goals;
	
	String name;
	String description;
	String type;
	String date;

	@Override
	protected void onCreate(Bundle nonestates) {
		// TODO Auto-generated method stub
		super.onCreate(nonestates);
		
		final DatabaseHelper db = new DatabaseHelper(this);
		//get states from database
		goals = db.getAllFGoals();
		/*
		//get information from add current education
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
				    name = extras.getString("name");
				    description = extras.getString("desc");
				    type = extras.getString("type");
				    date = extras.getString("date");
	
				    
				    //goals.add(new FinanceGoal(name,description, type, date));
					
			}*/
			setContentView(R.layout.activity_none);

		Button enter = (Button) findViewById(R.id.bEnter);
		TextView label = (TextView) findViewById(R.id.tvNone);
			enter.setText("Add");
			label.setText("Goals");
			
			//for dynamic update of GUI
			LinearLayout ll = (LinearLayout)findViewById(R.id.NoneLayout);
			
			//dynamically add buttons
			Button[] tv = new Button[goals.size()];
			for(int i=0;i<goals.size();i++){          
				final int index = i;
			    tv[i] = new Button(getApplicationContext());
			    tv[i].setText(goals.get(i).getName());
			    tv[i].setTextSize(20);
			    tv[i].setPadding(15, 5, 15, 5);  
			    
			    //this needs to be on touch and hold and deleted from screen
			    tv[i].setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						Intent j = new Intent(FinancialGoalsActivity.this, DisplayFinancialGoalsActivity.class);
						j.putExtra("name", goals.get(index).getName());
						j.putExtra("desc", goals.get(index).getDescription());
						j.putExtra("type", goals.get(index).getType());
						j.putExtra("date", goals.get(index).getDate());
						startActivity(j);
					}
			    });
			    tv[i].setOnLongClickListener(new View.OnLongClickListener() { 
		               @Override 
		               public boolean onLongClick(View v) { 
				       db.deleteFGoal(goals.get(index).get_id()); 
				       ViewGroup parentView = (ViewGroup) v.getParent(); 
				       parentView.removeView(v); 
				       return true; 
				       } 
				  }); 
			    ll.addView(tv[i]);    
			    
			}
			
			//displays a text view when user hasn't entered any current education
			if(goals.size() == 0)
			{
				TextView none;
				none = new TextView(getApplicationContext());
			    none.setText("No goals at this time. Try entering some!");
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
		    		
		    		Intent j = new Intent(FinancialGoalsActivity.this, FinanceActivity.class);
		    		startActivity(j);
		    	
		    	}
			
		    });
		    
			
			
			
			enter.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					Intent i = new Intent(FinancialGoalsActivity.this, FinanceGoalsInfoActivity.class);
					startActivity(i);
				}

			});

			}
}
