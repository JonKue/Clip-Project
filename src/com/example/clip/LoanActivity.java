package com.example.clip;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LoanActivity extends Activity {
	Button enter;
	TextView label;
	ArrayList<Loan> loan;
	
	String companyName;
	String amount;
	String appStat;
	
	@Override
	protected void onCreate(Bundle noneState) {
		// TODO Auto-generated method stub
		super.onCreate(noneState);
		
		
		loan = new ArrayList();
		
		
		//get information from add current education
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
				    companyName = extras.getString("name");
				    amount = extras.getString("amt");
				    appStat = extras.getString("appStat");

				    
				    //default value for application status is none
				    ApplicationStatus appStatus = ApplicationStatus.NONE;
				    if(appStat.equalsIgnoreCase("APPLIED"))
				    {
				    	appStatus = ApplicationStatus.APPLIED;
				    }
				    else if(appStat.equalsIgnoreCase("ACCEPTED"))
				    {
				    	appStatus = ApplicationStatus.ACCEPTED;
				    }
				    else if(appStat.equalsIgnoreCase("REJECTED"))
				    {
				    	appStatus = ApplicationStatus.REJECTED;
				    }
				    
				    loan.add(new Loan(companyName));
				    
				    //set information for current education at the end of the array list
				    loan.get(loan.size()-1).setCompanyName(companyName);
				    loan.get(loan.size()-1).setAmount(Integer.parseInt(amount));
				    loan.get(loan.size()-1).setApplicationStatus(appStatus);
				    

					
			}
			setContentView(R.layout.activity_none);

			enter = (Button) findViewById(R.id.bEnter);
			label = (TextView) findViewById(R.id.tvNone);
			enter.setText("Add");
			label.setText("Loans");
			
			//for dynamic update of GUI
			LinearLayout ll = (LinearLayout)findViewById(R.id.NoneLayout);
			
	
			//dynamically add buttons
			Button[] tv = new Button[loan.size()];
			for(int i=0;i<loan.size();i++){          
				final int index = i;
			    tv[i] = new Button(getApplicationContext());
			    tv[i].setText(loan.get(i).getCompanyName());
			    tv[i].setTextSize(20);
			    tv[i].setPadding(15, 5, 15, 5);     
			    tv[i].setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						Intent j = new Intent(LoanActivity.this, DisplayLoanActivity.class);
						j.putExtra("name", loan.get(index).getCompanyName());
						j.putExtra("amt", String.valueOf(loan.get(index).getAmount()));
						j.putExtra("appStat", loan.get(index).getApplicationStatus().toString());


						startActivity(j);
					}
			    });
			    ll.addView(tv[i]);    
			    
			}
			
			//displays a text view when user hasn't entered any current education
			if(loan.size() == 0)
			{
				TextView none;
				none = new TextView(getApplicationContext());
			    none.setText("No loans at this time. Try entering some!");
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
					Intent i = new Intent(LoanActivity.this, LoanInfoActivity.class );
					startActivity(i);
				}
				
			});

			}
	}
