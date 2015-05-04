package com.example.example;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FinancialStateInfoActivity extends Activity {

	TextView cash, assets, liabilities, creditCards, other;
	EditText enterCash, enterAssets, enterLiabilities, enterCreditCards, enterOther;
	Button submit;
	TextView error;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_financial_state_info);

		setUpVariables();
		final DatabaseHelper db = new DatabaseHelper(this);
		
		submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//get strings from text boxes
				String enteredCash = enterCash.getText().toString();
				String enteredAssets = enterAssets.getText().toString();
				String enteredLiabilities = enterLiabilities.getText().toString();
				String enteredCreditCards = enterCreditCards.getText().toString();
				String enteredOther = enterOther.getText().toString();

				//make sure all fields are filled in 
				if(enteredCash.equals("") || enteredAssets.equals("") || enteredLiabilities.equals("") || enteredCreditCards.equals("") ||
						enteredOther.equals(""))
				{
					error.setVisibility(View.VISIBLE);
					
				}
				else
				{
					
					Intent j = new Intent(FinancialStateInfoActivity.this, FinancialStateActivity.class);
					/*
					j.putExtra("cash", enteredCash.toString());
					j.putExtra("assets", enteredAssets);
					j.putExtra("liabilities", enteredLiabilities);
					j.putExtra("creditCards", enteredCreditCards);
					j.putExtra("other", enteredOther);
					*/
					
					
					SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
				    Date date = new Date();
				    String d = dateFormat.format(date);
				    
				    
				    //add financial state to the database
					FinancialState state = new FinancialState(0);
					state.setDate(d);
					state.setCash(enteredCash);
					state.setAssets(enteredAssets);
					state.setLiabilities(enteredLiabilities);
					state.setCreditCards(enteredCreditCards);
					state.setOther(enteredOther);
					
					
					db.addState(state);
					startActivity(j);
					finish();
					
				}
					
				
			}

		});
	}

	private void setUpVariables() {
		cash = (TextView) findViewById(R.id.tvCash);
		enterCash = (EditText) findViewById(R.id.etCash);
		assets = (TextView) findViewById(R.id.tvAssets);
		enterAssets = (EditText) findViewById(R.id.etAssets);
		liabilities = (TextView) findViewById(R.id.tvLiabilities);
		enterLiabilities = (EditText) findViewById(R.id.etLiabilities);
		creditCards = (TextView) findViewById(R.id.tvCreditCards);
		enterCreditCards = (EditText) findViewById(R.id.etCreditCards);
		other = (TextView) findViewById(R.id.tvOther);
		enterOther = (EditText) findViewById(R.id.etOther);
		submit = (Button) findViewById(R.id.bFSSubmit);
		error = (TextView) findViewById(R.id.error);
				
	}

}