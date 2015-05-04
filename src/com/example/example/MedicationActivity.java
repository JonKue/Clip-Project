package com.example.example;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MedicationActivity extends Activity {

    private final Context context = this;
    String pillName;
    String noDosage;
    String startDate;
    String dateEnd;
    private DatabaseHelper db;
    private List<Medication> mdList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication);
        db = new DatabaseHelper(this);

        LinearLayout ll = (LinearLayout) findViewById(R.id.llsvM);

        mdList = db.getAllMedication();

        // Dynamically add buttons
        Button[] b = new Button[mdList.size()];
        for (int i = 0; i < mdList.size(); i++) {
            final int index = i;
            b[i] = new Button(getApplicationContext());
            b[i].setText(mdList.get(index).getPillName());
            b[i].setTextSize(20);
            b[i].setPadding(15, 15, 15, 15);
            b[i].setOnClickListener(new OnClickListener() {

                public void onClick(View v) {
                    Intent j = new Intent(MedicationActivity.this,
                            DisplayMedicationActivity.class);
                    j.putExtra("pillName", mdList.get(index).getPillName());
                    j.putExtra("noDosage", mdList.get(index).getNoOfDosage());
                    j.putExtra("startDate", mdList.get(index).getDateStarted());
                    j.putExtra("endDate", mdList.get(index).getDateEnded());

                    startActivity(j);
                }
            });
            b[i].setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    db.deleteMedication(mdList.get(index).get_id());
                    ViewGroup parentView = (ViewGroup) v.getParent();
                    parentView.removeView(v);
                    return true;
                }
            });
            ll.addView(b[i]);

        }

        Button add = (Button) findViewById(R.id.bMadd);

        add.setOnClickListener(new OnClickListener() {
            TextView pillName, startDate, endDate;
            EditText pillNameEntry, noDosage, startDateEntry, endDateEntry;
            Button save;

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_pill_info);
                dialog.setTitle("Add Pill");

                pillName = (TextView) dialog.findViewById(R.id.tvMpillName);
                startDate = (TextView) dialog.findViewById(R.id.tvMstartDate);
                endDate = (TextView) dialog.findViewById(R.id.tvMendDate);
                pillNameEntry = (EditText) dialog
                        .findViewById(R.id.etMpillName);
                noDosage = (EditText) dialog.findViewById(R.id.etMnoDosage);

                startDateEntry = (EditText) dialog
                        .findViewById(R.id.etMstartDate);
                endDateEntry = (EditText) dialog.findViewById(R.id.etMendDate);

                save = (Button) dialog.findViewById(R.id.bMsave);

                save.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        Medication medication = new Medication(0);
                        medication.setPillName(pillNameEntry.getText()
                                .toString());
                        medication.setNoOfDosage(noDosage.getText().toString());
                        medication.setDateStarted(startDateEntry.getText()
                                .toString());
                        medication.setDateEnded(endDateEntry.getText()
                                .toString());

                        db.addMedication(medication);
                        dialog.dismiss();
                        // need implementaion here.......
                        recreate();
                    }
                });
                dialog.show();
            }

        });

        Button back = (Button) findViewById(R.id.bMback);

        back.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent startHealth = new Intent(MedicationActivity.this,
                        HealthActivity.class);
                startActivity(startHealth);
                finish(); // need to change of modify this
            }

        });

    }

}

// for dynamic update of GUI
/*
 * if (c.getCount() == 0) { TextView tv; tv = new
 * TextView(getApplicationContext()); tv.setText("None"); tv.setTextSize(20);
 * tv.setPadding(15, 15, 15, 15); ll.addView(tv); } else { int count =
 * c.getCount(); b = new Button[count]; i = 0; while (c.moveToNext()) { b[i] =
 * new Button(getApplicationContext()); b[i].setText(c.getString(0));
 * b[i].setTextSize(20);
 * 
 * b[i].setOnClickListener(new OnClickListener() { TextView pillName, startDate,
 * endDate; Button back;
 * 
 * @Override public void onClick(View v) { // TODO Auto-generated method stub
 * setContentView(R.layout.activity_medication_display); setUpButtonVariables();
 * String pn = b[i - 1].getText().toString(); pillName.append(pn);
 * 
 * Medication md = db.getMedication(pn); startDate.append(md.getDateStarted());
 * endDate.append(md.getDateEnded());
 * 
 * back.setOnClickListener(new OnClickListener() {
 * 
 * @Override public void onClick(View v) { // TODO Auto-generated method stub
 * recreate(); }
 * 
 * }); }
 * 
 * public void setUpButtonVariables() { pillName = (TextView)
 * findViewById(R.id.tvMDpillName); startDate = (TextView)
 * findViewById(R.id.tvMDstartDate); endDate = (TextView)
 * findViewById(R.id.tvMDendDate); back = (Button) findViewById(R.id.bMDbace); }
 * });
 * 
 * ll.addView(b[i]); i++; } }
 * 
 * //add a home button at the bottom of the list Button back = new
 * Button(getApplicationContext()); back.setText("Back");
 * back.setBackgroundColor(Color.BLUE); back.setTextColor(Color.WHITE);
 * ll.addView(back); //action listener for home button
 * back.setOnClickListener(new OnClickListener() { public void onClick(View v) {
 * 
 * Intent j = new Intent(CurrentEducationActivity.this,
 * EducationActivity.class); startActivity(j);
 * 
 * }
 * 
 * });
 * 
 * enter.setOnClickListener(new OnClickListener() {
 * 
 * public void onClick(View v) { Intent startCurrentEducationInfo = new
 * Intent(CurrentEducationActivity.this, CurrentEducationInfoActivity.class );
 * startActivity(startCurrentEducationInfo); finish(); // need to change of
 * modify this }
 * 
 * });
 */

