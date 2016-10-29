package com.thoughtinterac.realestateapp.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.thoughtinterac.realestateapp.Activities.LoginActivity;
import com.thoughtinterac.realestateapp.Activities.MainActivity;
import com.thoughtinterac.realestateapp.Database.DatabaseHandler;
import com.thoughtinterac.realestateapp.R;
import com.thoughtinterac.realestateapp.Util.Utility;

/**
 * Created by AzaharSheikh on 27-10-2016.
 */
public class CommonPageHomeFragment extends Fragment {
    WebView  webHome;
    ImageView img_user_login, img_realtor_login;
    public CommonPageHomeFragment() {
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.common_page_home_page, container, false);

        webHome = (WebView)rootView.findViewById(R.id.webHome);

        webHome.getSettings().setJavaScriptEnabled(true);
        webHome.getSettings().setLoadWithOverviewMode(true);
        webHome.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webHome.getSettings().setUseWideViewPort(true);
        webHome.getSettings().setBuiltInZoomControls(true);
        webHome.getSettings().setPluginState(WebSettings.PluginState.ON);
        webHome.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        //webHome.getSettings().setPluginsEnabled(true);
        webHome.setWebViewClient(new HelloWebViewClient());
        webHome.loadUrl("file:///android_asset/www/index.html");
        img_user_login = (ImageView)rootView.findViewById(R.id.img_user_login);
        img_realtor_login = (ImageView) rootView.findViewById(R.id.img_realtor_login);

        img_user_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkRememberMe();

            }
        });
        img_realtor_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                Intent i = new Intent(getActivity(), LoginActivity.class);
                b.putString("login_name", "realtor");
                i.putExtras(b);
                startActivity(i);
                //checkRememberMe();
            }
        });
        return rootView;
    }

    private void checkRememberMe() {
        SharedPreferences sharedPref = getActivity().getSharedPreferences(
                Utility.remember_me_share_pref, Context.MODE_PRIVATE);
        String remember_me_flag = sharedPref.getString(Utility.remember_me_flag, "false");
        String remember_me_email = sharedPref.getString(Utility.remember_me_email, "");
        if (remember_me_flag.equalsIgnoreCase("true")) {

            DatabaseHandler handler = new DatabaseHandler(getActivity());
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


                    Intent intent = new Intent(getActivity(),
                            MainActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    getActivity().finish();


                }
            }
        }else
        {
            Bundle b = new Bundle();
            Intent i = new Intent(getActivity(), LoginActivity.class);
            b.putString("login_name", "user");
            i.putExtras(b);
            startActivity(i);
        }
    }

    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }

}

