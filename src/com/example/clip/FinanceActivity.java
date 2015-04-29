package com.example.clip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FinanceActivity extends Activity {

	Button state, stocks, goals, summary;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_finance);
		
		state = (Button) findViewById(R.id.bFinancialState);
		stocks = (Button) findViewById(R.id.bStocksAndSecurities);
		goals = (Button) findViewById(R.id.bFinancialGoals);
		summary = (Button) findViewById(R.id.bFinancialSummary);
		
		 state.setOnClickListener(new OnClickListener() {
		    	public void onClick(View v) {
		    		
		    		Intent j = new Intent(FinanceActivity.this, FinancialStateActivity.class);
		    		startActivity(j);
		    	
		    	}
			
		    });
		 
		 stocks.setOnClickListener(new OnClickListener() {
		    	public void onClick(View v) {
		    		
		    		Intent j = new Intent(FinanceActivity.this, StocksActivity.class);
		    		startActivity(j);
		    	
		    	}
			
		    });
		
		 goals.setOnClickListener(new OnClickListener() {
		    	public void onClick(View v) {
		    		
		    		Intent j = new Intent(FinanceActivity.this, FinancialGoalsActivity.class);
		    		startActivity(j);
		    	
		    	}
			
		    });
		
		
	}
}
