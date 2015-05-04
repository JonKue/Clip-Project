package com.example.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FinanceGoalsInfoActivity extends Activity {
    private EditText enterName;
    private EditText enterDesc;
    private EditText enterType;
    private EditText enterDate;
    private Button submit;
    private TextView error;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance_goals_info);

        setUpVariables();
        final DatabaseHelper db = new DatabaseHelper(this);

        submit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                //get strings from text boxes
                String enteredName = enterName.getText().toString();
                String enteredDesc = enterDesc.getText().toString();
                String enteredType = enterType.getText().toString();
                String enteredDate = enterDate.getText().toString();


                //make sure all fields are filled in
                if (enteredName.equals("") || enteredDesc.equals("") || enteredType.equals("") || enteredDate.equals("")) {
                    error.setVisibility(View.VISIBLE);

                } else {

                    Intent j = new Intent(FinanceGoalsInfoActivity.this, FinancialGoalsActivity.class);
                    /*j.putExtra("name", enteredName);
					j.putExtra("desc", enteredDesc);
					j.putExtra("type", enteredType);
					j.putExtra("date", enteredDate);*/

                    //add financial goal to the database
                    FinanceGoal goal = new FinanceGoal(0);
                    goal.setName(enteredName);
                    goal.setDescription(enteredName);
                    goal.setType(enteredType);
                    goal.setDate(enteredDate);


                    db.addFGoal(goal);


                    startActivity(j);
                    finish();

                }


            }

        });
    }

    private void setUpVariables() {
        enterName = (EditText) findViewById(R.id.etFGoalName);
        enterDesc = (EditText) findViewById(R.id.etFGoalDesc);
        enterType = (EditText) findViewById(R.id.etFGoalType);
        enterDate = (EditText) findViewById(R.id.etFGoalDate);
        submit = (Button) findViewById(R.id.bFGoalsSubmit);
        error = (TextView) findViewById(R.id.error);

    }

}