package com.example.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FinanceActivity extends Activity {

	Button summary;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_finance);

		Button state = (Button) findViewById(R.id.bFinancialState);
		Button stocks = (Button) findViewById(R.id.bStocksAndSecurities);
		Button goals = (Button) findViewById(R.id.bFinancialGoals);
		
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
