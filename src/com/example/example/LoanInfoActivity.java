package com.example.example;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class LoanInfoActivity extends Activity {
    private final Context context = this;

    private EditText enterCompanyName;
    private EditText enterAmount;
    private Spinner enterApplicationStatus;
    private Button submit;
    private TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_info);

        setUpVariables();

        final DatabaseHelper db = new DatabaseHelper(this);

        submit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                //get strings from text boxes
                String enteredName = enterCompanyName.getText().toString();
                String enteredAmount = enterAmount.getText().toString();
                String enteredAppStat = enterApplicationStatus.getSelectedItem().toString();


                //make sure all fields are filled in
                if (enteredName.equals("") || enteredAmount.equals("")) {
                    error.setVisibility(View.VISIBLE);
                } else {
                    error.setVisibility(View.INVISIBLE);
                    Loan loan = new Loan(0);
                    loan.setCompanyName(enteredName);
                    loan.setAmount(Integer.parseInt(enteredAmount));
                    loan.setApplicationStatus(enteredAppStat);
                    db.addLoan(loan);

                    Intent j = new Intent(LoanInfoActivity.this, LoanActivity.class);
                    j.putExtra("lenderName", enteredName);
                    j.putExtra("amount", enteredAmount);
                    j.putExtra("status", enteredAppStat);
                    startActivity(j);
                    finish();
                }

            }

        });
    }


    private void setUpVariables() {
        enterCompanyName = (EditText) findViewById(R.id.etLoCompanyName);
        enterAmount = (EditText) findViewById(R.id.etLoAmount);
        enterApplicationStatus = (Spinner) findViewById(R.id.spLoApplicationStatus);
        ArrayAdapter<CharSequence> spinnerMenuList3 = ArrayAdapter.createFromResource(context, R.array.APP_STATUS, android.R.layout.simple_spinner_item);
        spinnerMenuList3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        enterApplicationStatus.setAdapter(spinnerMenuList3);
        submit = (Button) findViewById(R.id.bLoSubmit);
        error = (TextView) findViewById(R.id.error);
    }

}
