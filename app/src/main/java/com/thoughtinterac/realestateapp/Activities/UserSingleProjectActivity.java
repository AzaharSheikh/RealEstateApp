package com.thoughtinterac.realestateapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.thoughtinterac.realestateapp.R;

/**
 * Created by AzaharSheikh on 09-11-2016.
 */
public class UserSingleProjectActivity  extends AppCompatActivity {
    String Project_id;
    String Project_Name;
    String Project_date;
    String Project_Location;
    String ProjectDescription;
    String bhk1_FloorAreaSqFt;
    String bhk1_NoofFloor;
    String bhk1_price;
    String bhk2_FloorAreaSqFt;
    String bhk2_NoofFloor;
    String bhk2_price;
    String bhk3_FloorAreaSqFt;
    String bhk3_NoofFloor;
    String bhk3_price;
    TextView edt_project_name,edt_project_location,edt_Project_Description;
    TextView edt_1bhk_floor_area,edt_1bhk_flat_available,edt_1bhk_price;
    TextView edt_2bhk_floor_area,edt_2bhk_flat_available,edt_2bhk_price;
    TextView edt_3bhk_floor_area,edt_3bhk_flat_available,edt_3bhk_price;
    RadioGroup rg_flat_type,rg_myproject;
    LinearLayout li_one_bhk,li_two_bhk,li_three_bhk;
    LinearLayout li_main_photo_list,li_main_project_status;
    ScrollView sc_new_project_details;
    TextView txt_set_value_no_of_flats_view_details;
    TextView txt_no_of_flats_sold_view_detail;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_single_project_list_detail);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        edt_project_name = (TextView)findViewById(R.id.edt_project_name) ;
        edt_project_location= (TextView)findViewById(R.id.edt_project_location) ;
        edt_Project_Description= (TextView)findViewById(R.id.edt_Project_Description) ;
        edt_1bhk_floor_area= (TextView)findViewById(R.id.edt_1bhk_floor_area) ;
        edt_1bhk_flat_available= (TextView)findViewById(R.id.edt_1bhk_flat_available) ;
        edt_1bhk_price= (TextView)findViewById(R.id.edt_1bhk_price) ;
        edt_2bhk_floor_area= (TextView)findViewById(R.id.edt_2bhk_floor_area) ;
        edt_2bhk_flat_available= (TextView)findViewById(R.id.edt_2bhk_flat_available) ;
        edt_2bhk_price= (TextView)findViewById(R.id.edt_2bhk_price) ;
        edt_3bhk_floor_area= (TextView)findViewById(R.id.edt_3bhk_floor_area) ;
        edt_3bhk_flat_available= (TextView)findViewById(R.id.edt_3bhk_flat_available) ;
        edt_3bhk_price= (TextView)findViewById(R.id.edt_3bhk_price) ;
        rg_flat_type=(RadioGroup) findViewById(R.id.rg_flat_type);
        rg_myproject=(RadioGroup) findViewById(R.id.rg_myproject);
        li_one_bhk=(LinearLayout)findViewById(R.id.li_one_bhk);
        li_two_bhk=(LinearLayout)findViewById(R.id.li_two_bhk);
        li_three_bhk=(LinearLayout)findViewById(R.id.li_three_bhk);
        li_main_photo_list=(LinearLayout)findViewById(R.id.li_main_photo_list);
        li_main_project_status=(LinearLayout)findViewById(R.id.li_main_project_status);
        sc_new_project_details=(ScrollView)findViewById(R.id.sc_new_project_details);
        txt_set_value_no_of_flats_view_details=(TextView)findViewById(R.id.txt_set_value_no_of_flats_view_details);
        txt_no_of_flats_sold_view_detail=(TextView) findViewById(R.id.txt_no_of_flats_sold_view_detail);
        //checkUserFlag();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Project_id = extras.getString("Project_id");
            Project_Name = extras.getString("Project_Name");
            Project_date = extras.getString("Project_date");
            Project_Location = extras.getString("Project_Location");
            ProjectDescription = extras.getString("ProjectDescription");
            bhk1_FloorAreaSqFt = extras.getString("bhk1_FloorAreaSqFt");
            bhk1_NoofFloor = extras.getString("bhk1_NoofFloor");
            bhk1_price = extras.getString("bhk1_price");
            bhk2_FloorAreaSqFt = extras.getString("bhk2_FloorAreaSqFt");
            bhk2_NoofFloor = extras.getString("bhk2_NoofFloor");
            bhk2_price = extras.getString("bhk2_price");
            bhk3_FloorAreaSqFt = extras.getString("bhk3_FloorAreaSqFt");
            bhk3_NoofFloor = extras.getString("bhk3_NoofFloor");
            bhk3_price = extras.getString("bhk3_price");
            setData();


        }else
        {
            return;
        }
        txt_set_value_no_of_flats_view_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserSingleProjectActivity.this,UserFlatsAvailableListActivity.class);
                startActivity(i);


            }

        });
        txt_no_of_flats_sold_view_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserSingleProjectActivity.this,RealtorSoldFlatsListActivity.class);
                startActivity(i);


            }

        });


        rg_myproject.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.rbt_project_details:
                        sc_new_project_details.setVisibility(View.VISIBLE);
                        li_main_photo_list.setVisibility(View.GONE);
                        li_main_project_status.setVisibility(View.GONE);

                        break;
                    case R.id.rbt_project_status:
                        li_main_project_status.setVisibility(View.VISIBLE);
                        sc_new_project_details.setVisibility(View.GONE);
                        li_main_photo_list.setVisibility(View.GONE);
                        break;
                    case R.id.rbt_photos_list:
                        sc_new_project_details.setVisibility(View.GONE);
                        li_main_photo_list.setVisibility(View.VISIBLE);
                        li_main_project_status.setVisibility(View.GONE);
                        break;

                }
            }
        });
        rg_flat_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.rbt_one_bhk_details:
                        li_two_bhk.setVisibility(View.GONE);
                        li_three_bhk.setVisibility(View.GONE);
                        li_one_bhk.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rbt_two_bhk_list:
                        li_three_bhk.setVisibility(View.GONE);
                        li_one_bhk.setVisibility(View.GONE);
                        li_two_bhk.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rbt_three_bhk:
                        li_two_bhk.setVisibility(View.GONE);
                        li_one_bhk.setVisibility(View.GONE);
                        li_three_bhk.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
    }

    private void checkUserFlag() {
        String userFlag=MainActivity.userFlag;
        if(userFlag.equalsIgnoreCase("true"))
        {
            edt_project_name.setEnabled(false);
            edt_project_name.setFocusable(false);
            edt_project_location.setEnabled(false);
            edt_project_location.setFocusable(false);
            edt_Project_Description.setEnabled(false);
            edt_Project_Description.setFocusable(false);
            edt_1bhk_floor_area.setEnabled(false);
            edt_1bhk_floor_area.setFocusable(false);
            edt_1bhk_flat_available.setEnabled(false);
            edt_1bhk_flat_available.setFocusable(false);
            edt_1bhk_price.setEnabled(false);
            edt_1bhk_price.setFocusable(false);
            edt_2bhk_floor_area.setEnabled(false);
            edt_2bhk_floor_area.setFocusable(false);
            edt_2bhk_flat_available.setEnabled(false);
            edt_2bhk_flat_available.setFocusable(false);
            edt_2bhk_price.setEnabled(false);
            edt_3bhk_floor_area.setEnabled(false);
            edt_3bhk_flat_available.setEnabled(false);
            edt_3bhk_price.setEnabled(false);


            edt_2bhk_price.setFocusable(false);
            edt_3bhk_floor_area.setFocusable(false);
            edt_3bhk_flat_available.setFocusable(false);
            edt_3bhk_price.setFocusable(false);
        }
    }

    private void setData() {
        edt_project_name.setText(Project_Name);
        edt_project_location.setText(Project_Location);
        edt_Project_Description.setText(ProjectDescription);
        edt_1bhk_floor_area.setText(bhk1_FloorAreaSqFt);
        edt_1bhk_flat_available.setText(bhk1_NoofFloor);
        edt_1bhk_price.setText(bhk1_price);
        edt_2bhk_floor_area.setText(bhk2_FloorAreaSqFt);
        edt_2bhk_flat_available.setText(bhk2_NoofFloor);
        edt_2bhk_price.setText(bhk2_price);
        edt_3bhk_floor_area.setText(bhk3_FloorAreaSqFt);
        edt_3bhk_flat_available.setText(bhk3_NoofFloor);
        edt_3bhk_price.setText(bhk3_price);

    }
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;

    }
}
