package com.thoughtinterac.realestateapp.Activities;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.Button;
import android.view.View.OnClickListener;

import com.thoughtinterac.realestateapp.R;

public class Contact_Activity extends Activity {
    Intent quickenquiry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);
        Button Quick_Enquiry=(Button)findViewById(R.id.btn_login);
    }

    public void mondayintent()
    {
        quickenquiry= new Intent(this,Quick_Enqiry.class);
        startActivity(quickenquiry);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
