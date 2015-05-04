package com.example.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoanInfoActivity extends Activity{
    private EditText enterCompanyName;
    private EditText enterAmount;
    private EditText enterApplicationStatus;
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
                String enteredAppStat = enterApplicationStatus.getText().toString();



                //make sure all fields are filled in
                if(enteredName.equals("") || enteredAmount.equals("") || enteredAppStat.equals(""))
                {
                    error.setVisibility(View.VISIBLE);
                }
                else
                {
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
        enterApplicationStatus = (EditText) findViewById(R.id.etLoApplicationStatus);
        submit = (Button) findViewById(R.id.bLoSubmit);
        error = (TextView) findViewById(R.id.error);
    }

}
