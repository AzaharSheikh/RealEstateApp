package com.thoughtinterac.realestateapp.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.thoughtinterac.realestateapp.R;

/**
 * Created by AzaharSheikh on 21-10-2016.
 */
public class RealtorSingleProjectActivity extends AppCompatActivity {
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
    EditText edt_project_name,edt_project_location,edt_Project_Description;
    EditText edt_1bhk_floor_area,edt_1bhk_flat_available,edt_1bhk_price;
    EditText edt_2bhk_floor_area,edt_2bhk_flat_available,edt_2bhk_price;
    EditText edt_3bhk_floor_area,edt_3bhk_flat_available,edt_3bhk_price;
    RadioGroup rg_flat_type;
    LinearLayout li_one_bhk,li_two_bhk,li_three_bhk;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.builder_new_project);
        edt_project_name = (EditText)findViewById(R.id.edt_project_name) ;
        edt_project_location= (EditText)findViewById(R.id.edt_project_location) ;
        edt_Project_Description= (EditText)findViewById(R.id.edt_Project_Description) ;
        edt_1bhk_floor_area= (EditText)findViewById(R.id.edt_1bhk_floor_area) ;
        edt_1bhk_flat_available= (EditText)findViewById(R.id.edt_1bhk_flat_available) ;
        edt_1bhk_price= (EditText)findViewById(R.id.edt_1bhk_price) ;
        edt_2bhk_floor_area= (EditText)findViewById(R.id.edt_2bhk_floor_area) ;
        edt_2bhk_flat_available= (EditText)findViewById(R.id.edt_2bhk_flat_available) ;
        edt_2bhk_price= (EditText)findViewById(R.id.edt_2bhk_price) ;
        edt_3bhk_floor_area= (EditText)findViewById(R.id.edt_3bhk_floor_area) ;
        edt_3bhk_flat_available= (EditText)findViewById(R.id.edt_3bhk_flat_available) ;
        edt_3bhk_price= (EditText)findViewById(R.id.edt_3bhk_price) ;
        rg_flat_type=(RadioGroup) findViewById(R.id.rg_flat_type);
        li_one_bhk=(LinearLayout)findViewById(R.id.li_one_bhk);
        li_two_bhk=(LinearLayout)findViewById(R.id.li_two_bhk);
        li_three_bhk=(LinearLayout)findViewById(R.id.li_three_bhk);
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
}