package com.thoughtinterac.realestateapp.Fragments;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.thoughtinterac.realestateapp.Database.DatabaseHandler;
import com.thoughtinterac.realestateapp.R;

/**
 * Created by AshwiniBadgujar on 04-10-2016.
 */
public class MyBankDetailsFragment extends Fragment {
    Button btn_save;
    EditText loan_from_edt, rate_interest_edt, yr_interest_edt, loan_amt_edt, fisrt_principal_edt, fisrt_interest_edt, fisrt_lumpsum_edt, sec_principal_edt, sec_interest_edt, sec_lumpsum_edt;

    public MyBankDetailsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.mybankdetails, container, false);
        btn_save = (Button) rootView.findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                loan_from_edt = (EditText) rootView.findViewById(R.id.loan_from_edt);
                rate_interest_edt = (EditText) rootView.findViewById(R.id.rate_interest_edt);
                yr_interest_edt = (EditText) rootView.findViewById(R.id.yr_interest_edt);
                loan_amt_edt = (EditText) rootView.findViewById(R.id.loan_amt_edt);
                fisrt_principal_edt = (EditText) rootView.findViewById(R.id.fisrt_principal_edt);
                fisrt_interest_edt = (EditText) rootView.findViewById(R.id.fisrt_interest_edt);
                fisrt_lumpsum_edt = (EditText) rootView.findViewById(R.id.fisrt_lumpsum_edt);
                sec_principal_edt = (EditText) rootView.findViewById(R.id.sec_principal_edt);
                sec_interest_edt = (EditText) rootView.findViewById(R.id.sec_interest_edt);
                sec_lumpsum_edt = (EditText) rootView.findViewById(R.id.sec_lumpsum_edt);
                String str_loan_from = loan_from_edt.getText().toString().trim();
                String str_rate_interest = rate_interest_edt.getText().toString().trim();
                String str_yr_interest = yr_interest_edt.getText().toString().trim();
                String str_loan_amt = loan_amt_edt.getText().toString().trim();
                String str_fisrt_principal = fisrt_principal_edt.getText().toString().trim();
                String str_fisrt_interest = fisrt_interest_edt.getText().toString().trim();
                String str_fisrt_lumpsum = fisrt_lumpsum_edt.getText().toString().trim();
                String str_sec_principal = sec_principal_edt.getText().toString().trim();
                String str_sec_interest = sec_interest_edt.getText().toString().trim();
                String str_sec_lumpsum = sec_lumpsum_edt.getText().toString().trim();
                local_save( str_loan_from,  str_rate_interest,  str_yr_interest,  str_loan_amt,  str_fisrt_principal,  str_fisrt_interest,  str_fisrt_lumpsum,  str_sec_principal,  str_sec_interest,  str_sec_lumpsum);
            }


        });
        return rootView;

    }

    private void local_save(String str_loan_from, String str_rate_interest, String str_yr_interest, String str_loan_amt, String str_fisrt_principal, String str_fisrt_interest, String str_fisrt_lumpsum, String str_sec_principal, String str_sec_interest, String str_sec_lumpsum) {




    }

};



