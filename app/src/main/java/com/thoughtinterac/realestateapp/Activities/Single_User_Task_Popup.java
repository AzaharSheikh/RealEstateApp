package com.thoughtinterac.realestateapp.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.thoughtinterac.realestateapp.Database.DatabaseHandler;
import com.thoughtinterac.realestateapp.R;

/**
 * Created by AzaharSheikh on 10-10-2016.
 */
public class Single_User_Task_Popup extends AppCompatActivity {
    TextView txt_user_name;
    String str_user_name;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_user_task_popup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        txt_user_name=(TextView)findViewById(R.id.txt_user_name);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            str_user_name = bundle.getString(DatabaseHandler.KEY_USER_NAME);
            txt_user_name.setText(str_user_name);
        }
    }
}
