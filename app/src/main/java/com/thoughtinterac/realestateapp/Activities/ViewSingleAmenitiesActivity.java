package com.thoughtinterac.realestateapp.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;

import com.thoughtinterac.realestateapp.R;

/**
 * Created by AzaharSheikh on 19-11-2016.
 */
public class ViewSingleAmenitiesActivity extends AppCompatActivity {
    ImageView img_set_amenities;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_single_amenities);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        img_set_amenities=(ImageView)findViewById(R.id.img_set_amenities);
        Bundle getBundle = null;
        getBundle = this.getIntent().getExtras();
        if(getBundle!=null) {
            String id = getBundle.getString("id");
            if(id.equalsIgnoreCase("1"))
            {
                img_set_amenities.setImageDrawable(getResources().getDrawable(R.drawable.amenity11));
            }else if(id.equalsIgnoreCase("2"))
            {
                img_set_amenities.setImageDrawable(getResources().getDrawable(R.drawable.amenity8));
            }
            else if(id.equalsIgnoreCase("3"))
            {
                img_set_amenities.setImageDrawable(getResources().getDrawable(R.drawable.amenity61));
            }
            else if(id.equalsIgnoreCase("4"))
            {
                img_set_amenities.setImageDrawable(getResources().getDrawable(R.drawable.amenity71));
            }
        }
    }
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;

    }
}
