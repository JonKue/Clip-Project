package com.example.example;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by blaw on 5/1/15.
 */
public class CompanyInfoActivity extends Activity {
    private Context context = this;
    private Button add;
    DatabaseHelper db;
    Button[] b;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_add);

        db = new DatabaseHelper(this);
        final Cursor c = db.getAllCompany();

        // for dynamic update of GUI
        LinearLayout ll = (LinearLayout) findViewById(R.id.llCompany);

        if (c.getCount() == 0) {
            TextView tv;
            tv = new TextView(getApplicationContext());
            tv.setText("None");
            tv.setTextSize(20);
            tv.setPadding(15, 15, 15, 15);
            ll.addView(tv);
        } else {
            int count = c.getCount();
            b = new Button[count];
            i = 0;
            while (c.moveToNext()) {
                b[i] = new Button(getApplicationContext());
                final int id = Integer.parseInt(c.getString(0));
                final String comName = c.getString(1);
                final String comProduct = c.getString(2);
                final String phoneNum = c.getString(2);
                final String location = c.getString(3);
                final String keyFacts = c.getString(4);
                final String reasons = c.getString(5);
                final String resumeSubDate = c.getString(6);
                final String interviewDate = c.getString(7);
                final String interviewResult  = c.getString(8);
                final String notes = c.getString(9);

                b[i].setText(comName);

                b[i].setTextSize(20);

                b[i].setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        final Dialog dialog = new Dialog(context);
                        dialog.setContentView(R.layout.dialog_display_company);
                        dialog.setTitle("Company Information");
                        Button dismiss = (Button) dialog.findViewById(R.id.company_dismiss);


                        TextView company_name = (TextView) dialog.findViewById(R.id.company_name);
                        TextView company_product = (TextView) dialog.findViewById(R.id.company_product);
                        TextView company_address = (TextView) dialog.findViewById(R.id.company_address);
                        TextView company_phone = (TextView) dialog.findViewById(R.id.company_phone);
                        TextView company_facts = (TextView) dialog.findViewById(R.id.company_facts);
                        TextView company_reasons = (TextView) dialog.findViewById(R.id.company_reasons);
                        TextView company_subDate = (TextView) dialog.findViewById(R.id.company_subDate);
                        TextView company_intvwDate = (TextView) dialog.findViewById(R.id.company_intvwDate);
                        TextView company_intvwType = (TextView) dialog.findViewById(R.id.company_intvwType);
                        TextView company_notes = (TextView) dialog.findViewById(R.id.company_notes);

                        company_name.setText(comName);
                        company_product.setText(comProduct);
                        company_address.setText(location);
                        company_phone.setText(phoneNum);
                        company_facts.setText(keyFacts);
                        company_reasons.setText(reasons);
                        company_subDate.setText(resumeSubDate);
                        company_intvwDate.setText(interviewDate);
                        company_intvwType.setText(interviewResult);
                        company_notes.setText(notes);

                        dismiss.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });

                        dialog.show();
                    }


                });

                b[i].setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        db.deleteCompany(id);
                        ViewGroup parentView = (ViewGroup) v.getParent();
                        parentView.removeView(v);
                        return true;
                    }
                });

                ll.addView(b[i]);
                i++;
            }
        }

        add = (Button) findViewById(R.id.bCompanyAdd);

        add.setOnClickListener(new View.OnClickListener() {

            CompanyInformation companyInformation = new CompanyInformation(0);

            @Override
            public void onClick(View v) {

                setContentView(R.layout.activity_company_info);

                final EditText company_name = (EditText) findViewById(R.id.companyNameEdit);
                final EditText company_product = (EditText) findViewById(R.id.companyProductEdit);
                final EditText company_address = (EditText) findViewById(R.id.companyAddressEdit);
                final EditText company_phone = (EditText) findViewById(R.id.companyPhoneEdit);
                final EditText company_facts = (EditText) findViewById(R.id.companyFactsEdit);
                final EditText company_reasons = (EditText) findViewById(R.id.companyReasonsEdit);
                final EditText company_subDate = (EditText) findViewById(R.id.companySubmissionEdit);
                final EditText company_intvwDate = (EditText) findViewById(R.id.companyInterviewEdit);
                final Spinner company_intvwType = (Spinner) findViewById(R.id.companyResultEdit);
                final Button submit = (Button) findViewById(R.id.company_submit);
                final EditText company_notes = (EditText) findViewById(R.id.companyNotesEdit);

                ArrayAdapter<CharSequence> spinnerMenuList = ArrayAdapter.createFromResource(context, R.array.APP_STATUS, android.R.layout.simple_spinner_item);
                spinnerMenuList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                company_intvwType.setAdapter(spinnerMenuList);

                submit.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        companyInformation.setComName(company_name.getText().toString());
                        companyInformation.setComProduct(company_product.getText().toString());
                        companyInformation.setLocation(company_address.getText().toString());
                        companyInformation.setPhoneNum(company_phone.getText().toString());
                        companyInformation.setKeyFacts(company_facts.getText().toString());
                        companyInformation.setReasons(company_reasons.getText().toString());
                        companyInformation.setResumeSubDate(company_subDate.getText().toString());
                        companyInformation.setInterviewDate(company_intvwDate.getText().toString());
                        companyInformation.setInterviewResult(company_intvwType.getSelectedItem().toString());
                        companyInformation.setNotes(company_notes.getText().toString());

                        db.addCompany(companyInformation);
                        recreate();
                    }

                });

            }
        });

    }
}