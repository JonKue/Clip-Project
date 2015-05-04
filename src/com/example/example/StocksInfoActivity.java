package com.example.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StocksInfoActivity extends Activity {
    private EditText enterNum;
    private EditText enterName;
    private Button submit;
    private TextView error;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stocks_info);

        setUpVariables();

        final DatabaseHelper db = new DatabaseHelper(this);

        submit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                //get strings from text boxes
                String enteredNum = enterNum.getText().toString();
                String enteredName = enterName.getText().toString();


                //make sure all fields are filled in
                if (enteredNum.equals("") || enteredName.equals("")) {
                    error.setVisibility(View.VISIBLE);

                } else {

                    Intent j = new Intent(StocksInfoActivity.this, StocksActivity.class);
                    Stocks stock = new Stocks(0);
                    stock.setNumStock(enteredNum);
                    stock.setName(enteredName);

                    //put new stock into the database
                    db.addStock(stock);

                    startActivity(j);

                }


            }

        });
    }

    private void setUpVariables() {
        enterNum = (EditText) findViewById(R.id.etNumStocks);
        enterName = (EditText) findViewById(R.id.etNameStocks);
        submit = (Button) findViewById(R.id.bStocksSubmit);
        error = (TextView) findViewById(R.id.error);

    }

}