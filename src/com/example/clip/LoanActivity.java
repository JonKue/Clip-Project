package com.example.clip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoanActivity extends Activity {
	Button enter;

	@Override
	protected void onCreate(Bundle noneState) {
		// TODO Auto-generated method stub
		super.onCreate(noneState);
		setContentView(R.layout.activity_none);
		
		enter = (Button) findViewById(R.id.bEnter);

		enter.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent startLoanInfo = new Intent(LoanActivity.this,LoanInfoActivity.class);
				startActivity(startLoanInfo);
				// finish();
			}
		});

	}
}
