package com.thoughtinterac.realestateapp.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.thoughtinterac.realestateapp.Application.AppController;
import com.thoughtinterac.realestateapp.R;
import com.thoughtinterac.realestateapp.Util.AppConfig;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AshwiniBadgujar on 29-09-2016.
 */
public class RegisterActivity extends AppCompatActivity{
    Button btn_register_submit;
    EditText edt_username,edt_user_address,edt_job_dec,edt_mobile,edt_email,edt_password,edt_comfirm_pass;
    private ProgressDialog pDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        init();
        btn_register_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(RegisterActivity.this,"clicked",Toast.LENGTH_SHORT).show();
                String str_edt_username = edt_username.getText().toString().trim();
                String str_user_address= edt_user_address.getText().toString().trim();
                String str_job_dec = edt_job_dec.getText().toString().trim();
                String str_mobile= edt_mobile.getText().toString().trim();
                String str__email = edt_email.getText().toString().trim();
                String str_password = edt_password.getText().toString().trim();
                String str_confirm_password = edt_comfirm_pass.getText().toString().trim();
                if(str_edt_username.equalsIgnoreCase("") || str_user_address.equalsIgnoreCase("")|| str_job_dec.equalsIgnoreCase("")|| str_mobile.equalsIgnoreCase("")|| str__email.equalsIgnoreCase("") || str_password.equalsIgnoreCase("") || str_confirm_password.equalsIgnoreCase(""))
                {
                    Toast.makeText(RegisterActivity.this,"some field missing",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(!str_password.equalsIgnoreCase(str_confirm_password))
                    {
                        Toast.makeText(RegisterActivity.this,"password Not matched",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        pDialog = new ProgressDialog(RegisterActivity.this);
                        pDialog.setCancelable(false);
                        RegisterAsync(str_edt_username,str_user_address,str_job_dec,str_mobile,str__email,str_password);
                    }
                }
            }
        });

    }

    private void RegisterAsync(final String str_edt_username, final String str_user_address, final String str_job_dec, final String str_mobile, final String str__email, final String str_password)
    {
        String tag_string_req = "req_register";

        pDialog.setMessage("Registering ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_REGISTER, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d("response", "Register Response: " + response.toString());
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");
                    if (!error) {
                        // User successfully stored in MySQL
                        // Now store the user in sqlite
                        String uid = jObj.getString("uid");

                        JSONObject user = jObj.getJSONObject("user");
                        String name = user.getString("name");
                        String email = user.getString("email");
                        String created_at = user
                                .getString("created_at");

                        // Inserting row in users table


                        Toast.makeText(getApplicationContext(), "User successfully registered. Try login now!", Toast.LENGTH_LONG).show();

                        // Launch login activity
                        Intent intent = new Intent(
                                RegisterActivity.this,
                                MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {

                        // Error occurred in registration. Get the error
                        // message
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", "Registration Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", str_edt_username);
                params.put("email", str__email);
                params.put("password", str_password);
                params.put("job_discription", str_job_dec);
                params.put("user_mobile", str_mobile);
                params.put("user_address", str_user_address);

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }
    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    private void init() {
        btn_register_submit=(Button)findViewById(R.id.btn_register_submit);
        edt_username=(EditText)findViewById(R.id.edt_username);
        edt_user_address=(EditText)findViewById(R.id.edt_user_address);
        edt_job_dec=(EditText)findViewById(R.id.edt_job_dec);
        edt_mobile=(EditText)findViewById(R.id.edt_mobile);
        edt_email=(EditText)findViewById(R.id.edt_email);
        edt_password=(EditText)findViewById(R.id.edt_password);
        edt_comfirm_pass=(EditText)findViewById(R.id.edt_comfirm_pass);

    }
}
