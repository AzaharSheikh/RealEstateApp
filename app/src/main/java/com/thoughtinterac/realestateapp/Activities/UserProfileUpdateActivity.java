package com.thoughtinterac.realestateapp.Activities;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.thoughtinterac.realestateapp.Database.DatabaseHandler;
import com.thoughtinterac.realestateapp.R;

/**
 * Created by AzaharSheikh on 15-10-2016.
 */
public class UserProfileUpdateActivity extends AppCompatActivity {
    Button btn_update_submit_submit;
    EditText edt_username, edt_user_address, edt_job_dec, edt_mobile, edt_email, edt_password, edt_comfirm_pass, edt_pan, edt_bank_details;
    private ProgressDialog pDialog;
    String login_name;
    Bundle bundle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile_update);
        btn_update_submit_submit=(Button)findViewById(R.id.btn_update_submit_submit);
        edt_username=(EditText)findViewById(R.id.edt_username);
        edt_user_address=(EditText)findViewById(R.id.edt_user_address);
        edt_mobile=(EditText)findViewById(R.id.edt_mobile);
        edt_email=(EditText)findViewById(R.id.edt_email);
        edt_comfirm_pass=(EditText)findViewById(R.id.edt_comfirm_pass);
        edt_password=(EditText)findViewById(R.id.edt_password);
        edt_pan=(EditText)findViewById(R.id.edt_pan);
        edt_bank_details=(EditText)findViewById(R.id.edt_bank_details);
        edt_job_dec=(EditText)findViewById(R.id.edt_job_dec);
        bundle = getIntent().getExtras();
        setData();

        btn_update_submit_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(RegisterActivity.this,"clicked",Toast.LENGTH_SHORT).show();
                String str_edt_username = edt_username.getText().toString().trim();
                String str_user_address = edt_user_address.getText().toString().trim();
                String str_job_dec = edt_job_dec.getText().toString().trim();
                String str_mobile = edt_mobile.getText().toString().trim();
                String str__email = edt_email.getText().toString().trim();
                String str_password = edt_password.getText().toString().trim();
                String str_confirm_password = edt_comfirm_pass.getText().toString().trim();
                String str_pan = edt_pan.getText().toString().trim();
                String str_bank = edt_bank_details.getText().toString().trim();
                if (str_edt_username.equalsIgnoreCase("") || str_user_address.equalsIgnoreCase("") || str_job_dec.equalsIgnoreCase("") || str_mobile.equalsIgnoreCase("") || str__email.equalsIgnoreCase("") || str_password.equalsIgnoreCase("") || str_confirm_password.equalsIgnoreCase("")) {
                    Toast.makeText(UserProfileUpdateActivity.this, "some field missing", Toast.LENGTH_SHORT).show();
                }

                }
            private void LocalRegisterDb(final String str_edt_username, final String str_user_address, final String str_job_dec, final String str_mobile, final String str__email, final String str_password, String str_pan, String str_bank) {

                DatabaseHandler handler = new DatabaseHandler(UserProfileUpdateActivity.this);
                SQLiteDatabase db = handler.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(DatabaseHandler.KEY_USER_NAME, str_edt_username);
                values.put(DatabaseHandler.KEY_USER_ADDRESS, str_user_address);
                values.put(DatabaseHandler.KEY_USER_JOB_DESC, str_job_dec);
                values.put(DatabaseHandler.KEY_USER_MOBILE, str_mobile);
                values.put(DatabaseHandler.KEY_USER_EMAIL, str__email);
                values.put(DatabaseHandler.KEY_USER_PASSWORD, str_password);
                values.put(DatabaseHandler.KEY_PAN_NUMBER, str_pan);
                values.put(DatabaseHandler.KEY_BANK_DETAILS, str_bank);
            }
            });

        }

    private void setData() {
       if(bundle!=null) {
           String name = bundle.getString(DatabaseHandler.KEY_USER_NAME);
           edt_username.setText(name);
           String str_user_address  = bundle.getString(DatabaseHandler.KEY_USER_ADDRESS);
           edt_user_address.setText(name);
           String str_job_dec  = bundle.getString(DatabaseHandler.KEY_USER_JOB_DESC);
           edt_mobile.setText(name);
           String str__email  = bundle.getString(DatabaseHandler.KEY_USER_EMAIL);
           edt_email.setText(name);
       }

    }

}

