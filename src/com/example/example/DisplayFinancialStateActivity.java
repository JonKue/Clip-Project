package com.example.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayFinancialStateActivity extends Activity {

	TextView cash;
	TextView assets;
	TextView liabilities;
	TextView creditCards;
	TextView other;
	
	String entCash;
	String entAssets;
	String entLiabilities;
	String entCreditCards;
	String entOther;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_financial_state);
		
		//get information from previous activity
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    entCash = extras.getString("cash");
		    entAssets = extras.getString("assets");
		    entLiabilities = extras.getString("liabilities");
		    entCreditCards = extras.getString("creditCards");
		    entOther = extras.getString("other");

		    
			
		}
		
		//connect text views to xml
		cash = (TextView) findViewById(R.id.tvDisplayEntCash);
		assets = (TextView) findViewById(R.id.tvDisplayEntAssets);
		liabilities = (TextView) findViewById(R.id.tvDisplayEntLiabilities);
		creditCards = (TextView) findViewById(R.id.tvDisplayEntCreditCards);
		other = (TextView) findViewById(R.id.tvDisplayEntOther);

		
		//set text views to passed in text values
		cash.setText(entCash);
		assets.setText(entAssets);
		liabilities.setText(entLiabilities);
		creditCards.setText(entCreditCards);
		other.setText(entOther);
		
		
	}
	
}