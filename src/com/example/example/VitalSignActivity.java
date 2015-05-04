package com.example.example;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class VitalSignActivity extends Activity {
    // private VitalSign myVitalSign = new VitalSign(0,0,0,0);
    private final Context context = this;
    private Button bodyTemperature, pulseRate, respirationRate, bloodPressure;
    private TextView bodyTempDisplay, pulseDisplay, respRateDisplay,
            bldPressDisplay;
    // private TextView bodyTemperatureNum, pulseRateNum, respirationRateNum,
    // bloodPressureNum;

    // id ???? // Check for id check
    // not sure....
    private DatabaseHelper db;
    private VitalSign myVitalSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vital_sign);

        int[] bp = {0,0};
        myVitalSign = new VitalSign(0,0,0,bp);

        setUpVariables();
        db = new DatabaseHelper(this);

        try {
            myVitalSign = db.getVitalSign();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        bodyTempDisplay.setText(myVitalSign.getBodyTemperature());
        pulseDisplay.setText(myVitalSign.getPulse());
        respRateDisplay.setText(myVitalSign.getRespirationRate());
        String sysBP = myVitalSign.getBloodPressure()[0];
        String diasBP = myVitalSign.getBloodPressure()[1];
        bldPressDisplay.setText(sysBP + "/" + diasBP);
		
		/*
		 * db = new DatabaseHelper(this); db.openDatabase();
		 * 
		 * try { myVitalSign = db.getVitalSign(0); } catch (Exception e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */

        bodyTemperature.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_vital_sign_entry);
                dialog.setTitle("Body Temperature");
                Button save = (Button) dialog.findViewById(R.id.bVSsave);

                // myVitalSign.setBodyTemperature(Integer.parseInt(bodyTempReading.getText().toString()));

                save.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        EditText bodyTempReading = (EditText) dialog
                                .findViewById(R.id.etVSentry);
                        myVitalSign.setBodyTemperature(bodyTempReading
                                .getText().toString());
                        db.addVitalSign(myVitalSign);
                        dialog.dismiss();
                        recreate();
                        // need implementaion here.......
                    }
                });
                dialog.show();
            }
        });

        pulseRate.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_vital_sign_entry);
                dialog.setTitle("Pulse");
                Button save = (Button) dialog.findViewById(R.id.bVSsave);

                save.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        EditText pulseReading = (EditText) dialog
                                .findViewById(R.id.etVSentry);
                        myVitalSign.setPulse(pulseReading.getText().toString());
                        db.addVitalSign(myVitalSign);
                        dialog.dismiss();
                        recreate();
                        // need implementaion here.......
                    }
                });
                dialog.show();
            }
        });

        respirationRate.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_vital_sign_entry);
                dialog.setTitle("Respiration Rate");
                Button save = (Button) dialog.findViewById(R.id.bVSsave);

                save.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        EditText resRateReading = (EditText) dialog
                                .findViewById(R.id.etVSentry);
                        myVitalSign.setRespirationRate(resRateReading.getText()
                                .toString());
                        db.addVitalSign(myVitalSign);
                        dialog.dismiss();
                        recreate();
                        // need implementaion here.......
                    }
                });
                dialog.show();
            }
        });

        bloodPressure.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_vs_blood_pressure);
                dialog.setTitle("Blood Pressure");
                Button save = (Button) dialog.findViewById(R.id.bBPsave);

                save.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        EditText systolicReading = (EditText) dialog
                                .findViewById(R.id.etSysentry);
                        EditText diasystolicReading = (EditText) dialog
                                .findViewById(R.id.etDSysentry);
                        String sbp = systolicReading.getText().toString();
                        String dbp = diasystolicReading.getText().toString();
                        String[] bp = { sbp, dbp };
                        myVitalSign.setBloodPressure(bp);
                        db.addVitalSign(myVitalSign);
                        dialog.dismiss();
                        recreate();
                        // need implementaion here.......
                    }
                });
                dialog.show();
            }
        });

    }

    private void setUpVariables() {
        bodyTemperature = (Button) findViewById(R.id.bVSBodyTemperature);
        pulseRate = (Button) findViewById(R.id.bVSPulse);
        respirationRate = (Button) findViewById(R.id.bVSRespirationRate);
        bloodPressure = (Button) findViewById(R.id.bVSBloodPressure);
        bodyTempDisplay = (TextView) findViewById(R.id.tvVSbodyTemp);
        pulseDisplay = (TextView) findViewById(R.id.tvVSpulse);
        respRateDisplay = (TextView) findViewById(R.id.tvVSrespirationRate);
        bldPressDisplay = (TextView) findViewById(R.id.tvVSbloodPressure);
		/*
		 * bodyTemperatureNum = (TextView)
		 * findViewById(R.id.tvVSBodyTemperature); pulseRateNum = (TextView)
		 * findViewById(R.id.tvVSPulse); respirationRateNum = (TextView)
		 * findViewById(R.id.tvVSRespirationRate); bloodPressureNum = (TextView)
		 * findViewById(R.id.tvVSBloodPressure);
		 */

    }

}
