package com.example.example;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class AllergyActivity extends Activity {

    private final Context context = this;
    private DatabaseHelper db;
    private List<Allergy> agList;
    private CheckBox[] b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergy);
        db = new DatabaseHelper(this);

        agList = db.getAllAllergy();
        b = new CheckBox[agList.size()];

        // for dynamic update of GUI
        LinearLayout ll = (LinearLayout) findViewById(R.id.llsvA);
        TextView tv;

        if (agList.size() == 0) {
            tv = new TextView(getApplicationContext());
            tv.setText("None");
            tv.setTextSize(20);
            tv.setPadding(15, 15, 15, 15);
            ll.addView(tv);
        } else {
            for (int i = 0; i < agList.size(); i++) {
                b[i] = new CheckBox(getApplicationContext());
                String name = agList.get(i).getAllergyName();
                String description = agList.get(i).getAllergyDescription();
                if (description.matches(""))
                    description = "None";
                String str = name + "\n" + "\t\tDescription: " + description;
                b[i].setText(str);
                b[i].setTextColor(Color.BLUE);

                ll.addView(b[i]);
            }
        }

        Button add = (Button) findViewById(R.id.bAadd);

        add.setOnClickListener(new OnClickListener() {
            TextView name, description;
            EditText nameEntry, descriptionEntry;
            Button save;

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_allergy_info);
                dialog.setTitle("Add Allergy");

                name = (TextView) dialog.findViewById(R.id.tvAname);
                description = (TextView) dialog
                        .findViewById(R.id.tvAdescription);
                nameEntry = (EditText) dialog.findViewById(R.id.etAname);
                descriptionEntry = (EditText) dialog
                        .findViewById(R.id.etAdescription);

                save = (Button) dialog.findViewById(R.id.bAsave);

                save.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        Allergy allergy = new Allergy(0);
                        allergy.setAllergyName(nameEntry.getText().toString());
                        allergy.setAllergyDescription(descriptionEntry
                                .getText().toString());
                        db.addAllergy(allergy);
                        dialog.dismiss();
                        recreate();

                    }
                });
                dialog.show();
            }
        });

        Button delete = (Button) findViewById(R.id.bAdelete);
        delete.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                for (int i = 0; i < agList.size(); i++) {
                    if (b[i].isChecked()) {
                        db.deleteAllergy(agList.get(i).get_id());
                        recreate();
                    }

                }
            }
        });

    }

}
