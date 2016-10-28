package com.thoughtinterac.realestateapp.Activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.thoughtinterac.realestateapp.R;

/**
 * Created by AzaharSheikh on 12-10-2016.
 */
public class SearchProjectActivity extends Activity {

   ImageView img_back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.search_project);
       // getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.custom_theme_layout);
        //img_back = (ImageView) findViewById(R.id.img_back);
//        img_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//    });


}
}