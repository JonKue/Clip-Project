package com.example.example;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StocksActivity extends Activity {

	private List<Stocks> stocks;
	
	String numStock;
	String stock;
	

	@Override
	protected void onCreate(Bundle nonestates) {
		// TODO Auto-generated method stub
		super.onCreate(nonestates);
		
		final DatabaseHelper db = new DatabaseHelper(this);

		//get stocks from database
		stocks = db.getAllStocks();
		setContentView(R.layout.activity_none);

		Button enter = (Button) findViewById(R.id.bEnter);
		TextView label = (TextView) findViewById(R.id.tvNone);
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


			tv[i].setOnLongClickListener(new View.OnLongClickListener() {
			   @Override
			   public boolean onLongClick(View v) {
			   db.deleteStock(stocks.get(index).get_id());
			   ViewGroup parentView = (ViewGroup) v.getParent();
			   parentView.removeView(v);
			   return true;
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
				Intent i = new Intent(StocksActivity.this, StocksInfoActivity.class);
				startActivity(i);
			}

		});

	}
}
