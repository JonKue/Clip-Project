package com.example.example;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class ElectronicIdentityActivity extends Activity {
    private Context context = this;
    private Button add;
    private List<ElectronicIdentity> id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobsearch_add);
        LinearLayout ll = (LinearLayout)findViewById(R.id.llJobSearch);
        final DatabaseHelper db = new DatabaseHelper(this);

        id = db.getAllIdentities();

        //dynamically add buttons
        Button[] tv = new Button[id.size()];
        for(int i=0;i<id.size();i++){
            final int index = i;
            final String n = id.get(i).getName();
            final String site = id.get(i).getWebsite();
            final String uName = id.get(i).getUserName();
            final String pWord = id.get(i).getPassWord();

            tv[i] = new Button(getApplicationContext());
            tv[i].setText(n);
            tv[i].setTextSize(20);
            tv[i].setPadding(15, 15, 15, 15);


            tv[i].setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.display_electronic_identity);
                    dialog.setTitle("Electronic Identity");
                    Button dismiss = (Button) dialog.findViewById(R.id.bDismiss);

                    TextView name = (TextView) dialog.findViewById(R.id.tvDisplayEIName);
                    TextView website = (TextView) dialog.findViewById(R.id.tvDisplayEIWebsite);
                    TextView userName = (TextView) dialog.findViewById(R.id.tvDisplayEIUName);
                    TextView password = (TextView) dialog.findViewById(R.id.tvDisplayEIPword);

                    name.setText(n);
                    website.setText(site);
                    userName.setText(uName);
                    password.setText(pWord);

                    dismiss.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            dialog.dismiss();

                        }
                    });
                    dialog.show();
                }
            });
            tv[i].setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    db.deleteIdentity(id.get(index).get_id());
                    ViewGroup parentView = (ViewGroup) v.getParent();
                    parentView.removeView(v);
                    return true;
                }
            });

            ll.addView(tv[i]);
        }

        add = (Button) findViewById(R.id.bCareerAdd);

        add.setOnClickListener(new OnClickListener() {

            ScrollView scroll;
            EditText name, website, username, password;
            Button save;

            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_electronic_identity_info);

                setUpVariable();

                save.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        // need to save the data and display on electronic identity activity
                        String entName = name.getText().toString();
                        String entSite = website.getText().toString();
                        String entUName = username.getText().toString();
                        String entPWord = password.getText().toString();


                        ElectronicIdentity id = new ElectronicIdentity(0);
                        id.setName(entName);
                        id.setWebsite(entSite);
                        id.setUserName(entUName);
                        id.setPassWord(entPWord);
                        db.addIdentity(id);


                        recreate();
                    }

                });
            }

            public void setUpVariable() {
                scroll = (ScrollView) findViewById(R.id.svEI);
                name = (EditText) findViewById(R.id.etEIname);
                website = (EditText) findViewById(R.id.etEIwebsite);
                username = (EditText) findViewById(R.id.etEIusername);
                password = (EditText) findViewById(R.id.etEIpassword);
                save = (Button) findViewById(R.id.bEIsave);

            }
        });

    }
}
