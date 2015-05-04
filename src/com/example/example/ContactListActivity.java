package com.example.example;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class ContactListActivity extends Activity {
    private Context context = this;
    private Button add;
    private List<ContactList> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobsearch_add);

        add = (Button) findViewById(R.id.bCareerAdd);
        LinearLayout ll = (LinearLayout)findViewById(R.id.llJobSearch);

        final DatabaseHelper db = new DatabaseHelper(this);

        contacts = db.getAllContacts();

        //dynamically add buttons
        Button[] tv = new Button[contacts.size()];
        for(int i=0;i<contacts.size();i++){
            final int index = i;
            final String n = contacts.get(i).getName();
            final String aff = contacts.get(i).getAffiliation();
            final String date = contacts.get(i).getEstablishedDate();
            final String times = contacts.get(i).getTimesUsed();
            final String comm = contacts.get(i).getComments();

            tv[i] = new Button(getApplicationContext());
            tv[i].setText(n);
            tv[i].setTextSize(20);
            tv[i].setPadding(15, 15, 15, 15);


            tv[i].setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.display_contact);
                    dialog.setTitle("Contact");
                    Button dismiss = (Button) dialog.findViewById(R.id.bDismiss);

                    TextView name = (TextView) dialog.findViewById(R.id.tvDisplayContactName);
                    TextView affiliation = (TextView) dialog.findViewById(R.id.tvDisplayContactAffiliation);
                    TextView estDate = (TextView) dialog.findViewById(R.id.tvDisplayContactDate);
                    TextView timesUsed = (TextView) dialog.findViewById(R.id.tvDisplayContactUse);
                    TextView comments = (TextView) dialog.findViewById(R.id.tvDisplayContactComments);

                    name.setText(n);
                    affiliation.setText(aff);
                    estDate.setText(date);
                    timesUsed.setText(times);
                    comments.setText(comm);

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
                    db.deleteContact(contacts.get(index).get_id());
                    ViewGroup parentView = (ViewGroup) v.getParent();
                    parentView.removeView(v);
                    return true;
                }
            });

            ll.addView(tv[i]);
        }



        add.setOnClickListener(new OnClickListener() {

            ScrollView scroll;
            EditText affiliation, establishedDate, comments, name, timesUsed;
            TextView nameDis;
            Button contactName, save;

            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_contact_list_info);

                setUpVariable();

                save.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // need to save the data and display on contact list activity
                        String entName = name.getText().toString();
                        String entAffil = affiliation.getText().toString();
                        String entDate = establishedDate.getText().toString();
                        String entTimes = timesUsed.getText().toString();
                        String entComments = comments.getText().toString();


                        ContactList contact = new ContactList(0);
                        contact.setName(entName);
                        contact.setAffiliation(entAffil);
                        ;
                        contact.setEstablishedDate(entDate);
                        contact.setTimesUsed(entTimes);
                        contact.setComments(entComments);

                        db.addContact(contact);


                        recreate();
                    }

                });
            }


            public void setUpVariable() {
//                scroll = (ScrollView) findViewById(R.id.svCL);
                affiliation = (EditText) findViewById(R.id.etCLaffiliation);
                name = (EditText) findViewById(R.id.etCLname);
                timesUsed = (EditText) findViewById(R.id.etCLNumTimes);
                establishedDate = (EditText) findViewById(R.id.etCLestablishedDate);
                comments = (EditText) findViewById(R.id.etCLcomments);
                save = (Button) findViewById(R.id.bCLsave);

            }
        });

    }
}