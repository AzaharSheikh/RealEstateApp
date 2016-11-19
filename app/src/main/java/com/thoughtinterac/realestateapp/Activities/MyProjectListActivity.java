package com.thoughtinterac.realestateapp.Activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.thoughtinterac.realestateapp.CustomAdapter.PlaceCustomAdapter;
import com.thoughtinterac.realestateapp.R;

import java.util.ArrayList;

/**
 * Created by AzaharSheikh on 19-11-2016.
 */
public class MyProjectListActivity extends AppCompatActivity {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ArrayList<String> project_img,project_list, projDetails;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_project_layout);
    }
}
