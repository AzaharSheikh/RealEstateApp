package com.thoughtinterac.realestateapp.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.thoughtinterac.realestateapp.Database.DatabaseHandler;
import com.thoughtinterac.realestateapp.R;
import com.thoughtinterac.realestateapp.Util.Utility;

/**
 * Created by AshwiniBadgujar on 04-10-2016.
 */
public class PreLogin extends AppCompatActivity {
    ImageView img_user, img_realeter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pre_login);
        img_user = (ImageView) findViewById(R.id.img_user);
        img_realeter = (ImageView) findViewById(R.id.img_realeter);

        img_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkRememberMe();

            }
        });
        img_realeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                Intent i = new Intent(PreLogin.this, LoginActivity.class);
                b.putString("login_name", "realtor");
                i.putExtras(b);
                startActivity(i);
                //checkRememberMe();
            }
        });
    }

    private void checkRememberMe() {
        SharedPreferences sharedPref = getSharedPreferences(
                Utility.remember_me_share_pref, Context.MODE_PRIVATE);
        String remember_me_flag = sharedPref.getString(Utility.remember_me_flag, "false");
        String remember_me_email = sharedPref.getString(Utility.remember_me_email, "");
        if (remember_me_flag.equalsIgnoreCase("true")) {

                DatabaseHandler handler = new DatabaseHandler(PreLogin.this);
                SQLiteDatabase db = handler.getWritableDatabase();
                String[] colmn = new String[]{DatabaseHandler.KEY_USER_NAME, DatabaseHandler.KEY_USER_ADDRESS, DatabaseHandler.KEY_USER_JOB_DESC, DatabaseHandler.KEY_USER_MOBILE, DatabaseHandler.KEY_USER_EMAIL, DatabaseHandler.KEY_USER_PASSWORD, DatabaseHandler.KEY_PAN_NUMBER, DatabaseHandler.KEY_BANK_DETAILS};
                Cursor cursor = db.query(DatabaseHandler.TABLE_REGISTER, colmn, DatabaseHandler.KEY_USER_EMAIL + " = '" + remember_me_email+"'" , null, null, null, null);
                if (cursor != null) {
                    String str_user_name = "", str_user_address = "", str_user_job = "", str_user_mobile = "", str_user_email = "", str_user_pan = "", str_user_bank = "";
                    if (cursor.getCount() > 0) {
                        while (cursor.moveToNext()) {
                            str_user_name = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_USER_NAME));
                            str_user_address = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_USER_ADDRESS));
                            str_user_job = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_USER_JOB_DESC));
                            str_user_mobile = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_USER_MOBILE));
                            str_user_email = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_USER_EMAIL));
                            str_user_pan = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_PAN_NUMBER));
                            str_user_bank = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_BANK_DETAILS));
                        }

                        Bundle bundle = new Bundle();
                        bundle.putString(DatabaseHandler.KEY_USER_NAME, str_user_name);
                        bundle.putString(DatabaseHandler.KEY_USER_ADDRESS, str_user_address);
                        bundle.putString(DatabaseHandler.KEY_USER_JOB_DESC, str_user_job);
                        bundle.putString(DatabaseHandler.KEY_USER_MOBILE, str_user_mobile);
                        bundle.putString(DatabaseHandler.KEY_USER_EMAIL, str_user_email);
                        bundle.putString(DatabaseHandler.KEY_PAN_NUMBER, str_user_pan);
                        bundle.putString(DatabaseHandler.KEY_BANK_DETAILS, str_user_bank);


                        Intent intent = new Intent(PreLogin.this,
                                MainActivity.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        finish();


                    }
                }
            }else
        {
            Bundle b = new Bundle();
            Intent i = new Intent(PreLogin.this, LoginActivity.class);
            b.putString("login_name", "user");
            i.putExtras(b);
            startActivity(i);
        }
        }
    }

