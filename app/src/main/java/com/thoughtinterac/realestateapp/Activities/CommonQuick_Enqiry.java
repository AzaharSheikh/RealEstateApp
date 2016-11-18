package com.thoughtinterac.realestateapp.Activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;

import com.thoughtinterac.realestateapp.R;

/**
 * Created by AzaharSheikh on 18-11-2016.
 */
public class CommonQuick_Enqiry extends AppCompatActivity {
    Button btn1;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_quick_enquiry);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;

    }

}
