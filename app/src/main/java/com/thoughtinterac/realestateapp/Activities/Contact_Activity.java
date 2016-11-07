package com.thoughtinterac.realestateapp.Activities;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

import com.thoughtinterac.realestateapp.R;

public class Contact_Activity extends AppCompatActivity {
    Intent quickenquiry;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        Button Quick_Enquiry = (Button) findViewById(R.id.btn1);
        Quick_Enquiry.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // Intent code for open new activity through intent.

        Intent i = new Intent(Contact_Activity.this, Quick_Enqiry.class);
        startActivity(i);

    }

        });
    }
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;

    }
}