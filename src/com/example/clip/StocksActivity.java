package com.example.clip;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StocksActivity extends Activity {

	Button enter;
	TextView label;
	ArrayList<Stocks> stocks;
	
	String numStock;
	String stock;
	

	@Override
	protected void onCreate(Bundle nonestates) {
		// TODO Auto-generated method stub
		super.onCreate(nonestates);
		
		
		stocks = new ArrayList();
		
		
		//get information from add current education
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
				    numStock = extras.getString("num");
				    stock = extras.getString("name");
				    
				    stocks.add(new Stocks(Integer.parseInt(numStock), stock));
					
			}
			setContentView(R.layout.activity_none);

			enter = (Button) findViewById(R.id.bEnter);
			label = (TextView) findViewById(R.id.tvNone);
			enter.setText("Add");
			label.setText("Stocks");
			
			//for dynamic update of GUI
			LinearLayout ll = (LinearLayout)findViewById(R.id.NoneLayout);
			
			//dynamically add buttons
			Button[] tv = new Button[stocks.size()];
			for(int i=0;i<stocks.size();i++){          
				final int index = i;
			    tv[i] = new Button(getApplicationContext());
			    tv[i].setText(stocks.get(i).getNumStock() + " shares of " + stocks.get(i).getName());
			    tv[i].setTextSize(20);
			    tv[i].setPadding(15, 5, 15, 5);  
			    
			    //this needs to be on touch and hold and deleted from screen
			    tv[i].setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						stocks.remove(index);
					}
			    });
			    ll.addView(tv[i]);    
			    
			}
			
			//displays a text view when user hasn't entered any current education
			if(stocks.size() == 0)
			{
				TextView none;
				none = new TextView(getApplicationContext());
			    none.setText("No stocks at this time. Try entering some!");
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
		    		
		    		Intent j = new Intent(StocksActivity.this, FinanceActivity.class);
		    		startActivity(j);
		    	
		    	}
			
		    });
		    
			
			
			
			enter.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					Intent i = new Intent(StocksActivity.this, StocksInfoActivity.class );
					startActivity(i);
				}
				
			});

			}
}
