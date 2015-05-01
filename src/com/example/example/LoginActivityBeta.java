package com.example.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;

public class LoginActivityBeta extends Activity {

    Button key1, key2, key3, key4, key5, key6,
            key7, key8, key9, keyD, key0, keyE;
    RadioButton digit1, digit2, digit3, digit4;

    int curr = 0;
    String pin = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_beta);

        setupVariables();
    }

    private void setupVariables(){
        key1 = (Button) findViewById(R.id.key1);
        key1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(curr<4) { selectRadio();
                pin+='1';}
            }
        });

        key2 = (Button) findViewById(R.id.key2);
        key2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(curr<4) { selectRadio();
                pin+='2';}
            }
        });

        key3 = (Button) findViewById(R.id.key3);
        key3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(curr<4) { selectRadio();
                pin+='3'; }
            }
        });

        key4 = (Button) findViewById(R.id.key4);
        key4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(curr<4) { selectRadio();
                pin+='4'; }
            }
        });

        key5 = (Button) findViewById(R.id.key5);
        key5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(curr<4) { selectRadio();
                pin+='5'; }
            }
        });

        key6 = (Button) findViewById(R.id.key6);
        key6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(curr<4) { selectRadio();
                pin+='6'; }
            }
        });

        key7 = (Button) findViewById(R.id.key7);
        key7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(curr<4) { selectRadio();
                pin+='7'; }
            }
        });

        key8 = (Button) findViewById(R.id.key8);
        key8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(curr<4) { selectRadio();
                pin+='8'; }
            }
        });

        key9 = (Button) findViewById(R.id.key9);
        key9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(curr<4) { selectRadio();
                pin+='9'; }
            }
        });

        key0 = (Button) findViewById(R.id.key0);
        key0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(curr<4) { selectRadio();
                pin+='0'; }
            }
        });

        keyD = (Button) findViewById(R.id.keyDel);
        keyD.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(curr>0) {
                    deselectRadio();
                    pin = pin.substring(0, curr);
                }
            }
        });

        keyE = (Button) findViewById(R.id.keyEnter);
        keyE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("CLIP-DEBUG:: -- ", "pin = " +pin);
                if(digit4.isChecked() && pin.equals("6024"))
                {
                    Intent i = new Intent(LoginActivityBeta.this, MenuActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        digit1 = (RadioButton) findViewById(R.id.digit1);
        digit2 = (RadioButton) findViewById(R.id.digit2);
        digit3 = (RadioButton) findViewById(R.id.digit3);
        digit4 = (RadioButton) findViewById(R.id.digit4);
    }

    private void selectRadio() {
        curr++;
        switch(curr){
            case 1: digit1.setChecked(true);
                break;
            case 2: digit2.setChecked(true);
                break;
            case 3: digit3.setChecked(true);
                break;
            case 4: digit4.setChecked(true);
                break;
            default: curr--;
        }
    }
    private void deselectRadio() {
        switch(curr){
            case 1: digit1.setChecked(false);
                break;
            case 2: digit2.setChecked(false);
                break;
            case 3: digit3.setChecked(false);
                break;
            case 4: digit4.setChecked(false);
                break;
        }
        curr--;
    }
}