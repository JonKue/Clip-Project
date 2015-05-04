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

public class FinanceGoalsInfoActivity extends Activity {
    private final Context context = this;

    private EditText enterName;
    private EditText enterDesc;
    private Spinner enterType;
    private EditText enterDate;
    private Button submit;
    private TextView error;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance_goals_info);

        setUpVariables();
        final DatabaseHelper db = new DatabaseHelper(this);

        submit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
            //get strings from text boxes
            String enteredName = enterName.getText().toString();
            String enteredDesc = enterDesc.getText().toString();
            String enteredType = enterType.getSelectedItem().toString();
            String enteredDate = enterDate.getText().toString();


            //make sure all fields are filled in
            if (enteredName.equals("") || enteredDesc.equals("") || enteredType.equals("") || enteredDate.equals("")) {
                error.setVisibility(View.VISIBLE);

            } else {

                Intent j = new Intent(FinanceGoalsInfoActivity.this, FinancialGoalsActivity.class);

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
        enterType = (Spinner) findViewById(R.id.spFGoalType);
        ArrayAdapter<CharSequence> spinnerMenuList3 = ArrayAdapter.createFromResource(context, R.array.GOAL_TYPE, android.R.layout.simple_spinner_item);
        spinnerMenuList3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        enterType.setAdapter(spinnerMenuList3);
        enterDate = (EditText) findViewById(R.id.etFGoalDate);
        submit = (Button) findViewById(R.id.bFGoalsSubmit);
        error = (TextView) findViewById(R.id.error);
    }

}