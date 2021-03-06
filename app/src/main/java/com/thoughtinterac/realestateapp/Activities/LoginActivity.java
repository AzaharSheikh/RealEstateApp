package com.thoughtinterac.realestateapp.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.thoughtinterac.realestateapp.Application.AppController;
import com.thoughtinterac.realestateapp.Database.DatabaseHandler;
import com.thoughtinterac.realestateapp.R;
import com.thoughtinterac.realestateapp.Util.AppConfig;
import com.thoughtinterac.realestateapp.Util.Utility;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by AzaharSheikh on 28-09-2016.
 */
public class LoginActivity extends AppCompatActivity  implements View.OnClickListener{

    Button btn_login,btn_register;
    EditText edt_username,edt_password;
    ProgressDialog pDialog;
    private RadioGroup rg_member;
    private RadioButton rbtn_member;
    LoginButton loginButton;
    CallbackManager callbackManager;
    AccessTokenTracker accessTokenTracker;
    public static String imageurl;
    String login_name;
    TextView txt_forgot_password;
    private View view;
    CheckBox chk_remember;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.login_activity);

        btn_login=(Button)findViewById(R.id.btn_login);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        btn_register=(Button)findViewById(R.id.btn_register);
        rg_member = (RadioGroup) findViewById(R.id.rg_member);
        loginButton.setReadPermissions(Arrays.asList("public_profile, email, user_birthday, user_friends"));
        callbackManager = CallbackManager.Factory.create();
        chk_remember=(CheckBox)findViewById(R.id.chk_remember);
        txt_forgot_password=(TextView)findViewById(R.id.txt_forgot_password);
        txt_forgot_password.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LoginActivity.this, Forgot_Password_Login.class);
                startActivity(myIntent);
            }
        });
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null) {
            login_name = bundle.getString("login_name");
            if(!login_name.equalsIgnoreCase("user"))
            {
                chk_remember.setVisibility(View.GONE);
            }
        }else
        {
            login_name="user";
        }
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(LoginActivity.this,MainActivity.class);
//                startActivity(i);
//                finish();
                edt_username=(EditText)findViewById(R.id.edt_username);
                edt_password=(EditText)findViewById(R.id.edt_password);
                int selectedId = rg_member.getCheckedRadioButtonId();
                rbtn_member = (RadioButton) findViewById(selectedId);
                String member = rbtn_member.getText().toString();
                String str_username =   edt_username.getText().toString().trim();
                String str_password =   edt_password.getText().toString().trim();

                pDialog = new ProgressDialog(LoginActivity.this);
                pDialog.setCancelable(false);
                //loginAsync(str_username,str_password);
                local_login(str_username, str_password);
               /* if(login_name.equalsIgnoreCase("user")) {

                    edt_username.setText("");
                    edt_password.setText("");
                }else
                {

                }*/
            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
                b.putString("login_name",login_name);
                i.putExtras(b);
                startActivity(i);

            }
        });
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {


                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {
                                String email="",birthday="",id="",name="";

                                try {
                                   email = object.getString("email");
                                     birthday = object.getString("birthday");
                                     id = object.getString("id");
                                     name = object.getString("name");
                                    /*tv_profile_name.setText(name);


                                    String imageurl = "https://graph.facebook.com/" + id + "/picture?type=large";

                                    Picasso.with(MainActivity.this).load(imageurl).into(iv_profile_pic);*/
                                    imageurl = "https://graph.facebook.com/" + id + "/picture?type=large";
                                    Bundle bundle = new Bundle();
                                    bundle.putString(DatabaseHandler.KEY_USER_NAME, name);
                                    bundle.putString(DatabaseHandler.KEY_USER_ADDRESS,id);
                                    bundle.putString(DatabaseHandler.KEY_USER_JOB_DESC, birthday);
                                    bundle.putString(DatabaseHandler.KEY_USER_MOBILE, email);
                                    bundle.putString(DatabaseHandler.KEY_USER_EMAIL, email);
                                    bundle.putString(DatabaseHandler.KEY_PAN_NUMBER, email);
                                    bundle.putString(DatabaseHandler.KEY_BANK_DETAILS, email);

                                    Intent intent = new Intent(LoginActivity.this,
                                            MainActivity.class);
                                    intent.putExtras(bundle);
                                    startActivity(intent);
                                    finish();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    Bundle bundle = new Bundle();
                                    bundle.putString(DatabaseHandler.KEY_USER_NAME, name);
                                    bundle.putString(DatabaseHandler.KEY_USER_ADDRESS,id);
                                    bundle.putString(DatabaseHandler.KEY_USER_JOB_DESC, birthday);
                                    bundle.putString(DatabaseHandler.KEY_USER_MOBILE, email);
                                    bundle.putString(DatabaseHandler.KEY_USER_EMAIL, email);
                                    bundle.putString(DatabaseHandler.KEY_PAN_NUMBER, email);
                                    bundle.putString(DatabaseHandler.KEY_BANK_DETAILS, email);

                                    Intent intent = new Intent(LoginActivity.this,
                                            MainActivity.class);
                                    intent.putExtras(bundle);
                                    startActivity(intent);
                                    finish();
                                }

                            }
                        });
//
//                public void onCheckboxClicked(View view) {
//                    // Is the view now checked?
//                    boolean checked = ((CheckBox) view).isChecked();
//
//                    // Check which checkbox was clicked
//                    switch(view.getId()) {
//                        case R.layout.login_activity:
//                            if (checked)
//                            // Put some meat on the sandwich
//                            else
//
//                            break;
//                        // TODO: Veggie sandwich
//                    }
//                }


                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender, birthday");
                request.setParameters(parameters);
                request.executeAsync();


/**
 * AccessTokenTracker to manage logout
 */
                accessTokenTracker = new AccessTokenTracker() {
                    @Override
                    protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken,
                                                               AccessToken currentAccessToken) {
                        if (currentAccessToken == null) {
                            /*tv_profile_name.setText("");
                            iv_profile_pic.setImageResource(R.drawable.maleicon);*/
                        }
                    }
                };
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

    }

    private void local_login(String str_username, String str_password) {
        DatabaseHandler handler= new DatabaseHandler(LoginActivity.this);
        SQLiteDatabase db = handler.getWritableDatabase();
        String[] colmn = new String[] { DatabaseHandler.KEY_USER_NAME,DatabaseHandler.KEY_USER_ADDRESS,DatabaseHandler.KEY_USER_JOB_DESC,DatabaseHandler.KEY_USER_MOBILE,DatabaseHandler.KEY_USER_EMAIL,DatabaseHandler.KEY_USER_PASSWORD,DatabaseHandler.KEY_PAN_NUMBER,DatabaseHandler.KEY_BANK_DETAILS,DatabaseHandler.KEY_MALE_OR_FEMALE};
        Cursor cursor = db.query(DatabaseHandler.TABLE_REGISTER, colmn,DatabaseHandler.KEY_USER_EMAIL + " = '"+str_username+"'"+" AND "+DatabaseHandler.KEY_USER_PASSWORD+" = '"+str_password+"'"+" AND "+DatabaseHandler.KEY_USER_OR_REALTOR+" = '"+login_name+"'", null, null, null, null);
        if(cursor!=null) {
            String str_user_name="",str_user_address="",str_user_job="",str_user_mobile="",str_user_email="",str_user_pan="",str_user_bank="",str_male_female="";
        if(cursor.getCount() >0)
        {
            while(cursor.moveToNext())
            {
                str_user_name= cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_USER_NAME));
                str_user_address= cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_USER_ADDRESS));
                str_user_job= cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_USER_JOB_DESC));
                str_user_mobile= cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_USER_MOBILE));
                str_user_email= cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_USER_EMAIL));
                str_user_pan= cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_PAN_NUMBER));
                str_user_bank= cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_BANK_DETAILS));
                str_male_female= cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_MALE_OR_FEMALE));
            }
            cursor.close();
            db.close();
            Bundle bundle = new Bundle();
            bundle.putString(DatabaseHandler.KEY_USER_NAME, str_user_name);
            bundle.putString(DatabaseHandler.KEY_USER_ADDRESS,str_user_address);
            bundle.putString(DatabaseHandler.KEY_USER_JOB_DESC, str_user_job);
            bundle.putString(DatabaseHandler.KEY_USER_MOBILE, str_user_mobile);
            bundle.putString(DatabaseHandler.KEY_USER_EMAIL, str_user_email);
            bundle.putString(DatabaseHandler.KEY_PAN_NUMBER, str_user_pan);
            bundle.putString(DatabaseHandler.KEY_BANK_DETAILS, str_user_bank);
            bundle.putString(DatabaseHandler.KEY_MALE_OR_FEMALE, str_male_female);

            if(login_name.equalsIgnoreCase("user")) {
                Intent intent = new Intent(LoginActivity.this,
                        MainActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
            else
            {
                Intent i = new Intent(LoginActivity.this,RealtorMainPage.class);
                i.putExtras(bundle);
                startActivity(i);
                finish();
            }
            if(chk_remember.isChecked())
            {
                SharedPreferences sharedPref = getSharedPreferences(
                        Utility.remember_me_share_pref, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString(Utility.remember_me_flag, "true");
                editor.putString(Utility.remember_me_email, str_user_email);

                editor.commit();
            }else
            {
                SharedPreferences sharedPref = getSharedPreferences(
                        Utility.remember_me_share_pref, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString(Utility.remember_me_flag, "false");
                editor.putString(Utility.remember_me_email, "");

                editor.commit();
            }
        }else
        {
            Toast.makeText(LoginActivity.this,"Plsease try again, email or password wrong",Toast.LENGTH_SHORT).show();
        }
        }
    }

    private void loginAsync(final String str_username, final String str_password) {
        String tag_string_req = "req_login";

        pDialog.setMessage("Logging in ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_LOGIN, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d("response", "Login Response: " + response.toString());
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");

                    // Check for error node in json
                    if (!error) {
                        // user successfully logged in
                        // Create login session


                        // Now store the user in SQLite
                        String uid = jObj.getString("uid");

                        JSONObject user = jObj.getJSONObject("user");
                        String name = user.getString("name");
                        String email = user.getString("email");
                        String created_at = user
                                .getString("created_at");



                        // Launch main activity
                        Intent intent = new Intent(LoginActivity.this,
                                MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // Error in login. Get the error message
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }

            private void hideDialog() {

            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("email", str_username);
                params.put("password", str_password);

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

    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onClick(View v) {
        userLogin();
    }

    private void userLogin() {

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       // callbackManager.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);


    }
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;

    }
}

