package com.thoughtinterac.realestateapp.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.thoughtinterac.realestateapp.CustomAdapter.ProjectListAdapter;
import com.thoughtinterac.realestateapp.CustomAdapter.RealtorProjectListAdapter;
import com.thoughtinterac.realestateapp.Model.ProjectModel;
import com.thoughtinterac.realestateapp.Model.RealtorProjectListModel;
import com.thoughtinterac.realestateapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AzaharSheikh on 21-10-2016.
 */
public class ProjectListActivity extends AppCompatActivity {
    ArrayList<String> projectID, projectName, projectDate, projectlocation;
    ArrayList<String> ProjectDescription;
    ArrayList<String> bhk1_FloorAreaSqFt;
    ArrayList<String> bhk1_NoofFloor;
    ArrayList<String> bhk1_price;
    ArrayList<String> bhk2_FloorAreaSqFt;
    ArrayList<String> bhk2_NoofFloor;
    ArrayList<String> bhk2_price;
    ArrayList<String> bhk3_FloorAreaSqFt;
    ArrayList<String> bhk3_NoofFloor;
    ArrayList<String> bhk3_price;
    RealtorProjectListAdapter adapter;

    public ProjectListActivity() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.realtor_project_list);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        projectID = new ArrayList();
        projectName = new ArrayList();
        projectDate = new ArrayList();
        projectlocation = new ArrayList();
        ProjectDescription = new ArrayList();
        bhk1_FloorAreaSqFt = new ArrayList<>();
        bhk1_NoofFloor = new ArrayList<>();
        bhk1_price = new ArrayList<>();
        bhk2_FloorAreaSqFt = new ArrayList<>();
        bhk2_NoofFloor = new ArrayList<>();
        bhk2_price = new ArrayList<>();
        bhk3_FloorAreaSqFt = new ArrayList<>();
        bhk3_NoofFloor = new ArrayList<>();
        bhk3_price = new ArrayList<>();

        projectID.add("1");
        projectID.add("2");
        projectID.add("3");

        projectName.add("Gemini Splendor");
        projectName.add("Gemini Solitaire");
        projectName.add("Gemini Orchids");

        projectDate.add("1/2/3 BHK");
        projectDate.add("2/3 BHK");
        projectDate.add("1/2/3 BHK");

        projectlocation.add("Dubai");
        projectlocation.add("Wadala");
        projectlocation.add("Vashi");


        ProjectDescription.add("Building Icons is a standard affair for Dubai, but Mohammed Bin Rashid Al Maktoum City is truly a breath-taking world icon.");
        bhk1_FloorAreaSqFt.add("850");
        bhk1_NoofFloor.add("6");
        bhk1_price.add("27.5Lacs");
        bhk2_FloorAreaSqFt.add("900");
        bhk2_NoofFloor.add("4");
        bhk2_price.add("48Lcas");
        bhk3_FloorAreaSqFt.add("1000");
        bhk3_NoofFloor.add("6");
        bhk3_price.add("90Lacs");

        ProjectDescription.add("Building Icons is a standard affair for Dubai, but Mohammed Bin Rashid Al Maktoum City is truly a breath-taking world icon.");
        bhk1_FloorAreaSqFt.add("700");
        bhk1_NoofFloor.add("6");
        bhk1_price.add("30Lacs");
        bhk2_FloorAreaSqFt.add("850");
        bhk2_NoofFloor.add("4");
        bhk2_price.add("36.5Lacs");
        bhk3_FloorAreaSqFt.add("1100");
        bhk3_NoofFloor.add("6");
        bhk3_price.add("90Lacs");

        ProjectDescription.add("Building Icons is a standard affair for Dubai, but Mohammed Bin Rashid Al Maktoum City is truly a breath-taking world icon.");
        bhk1_FloorAreaSqFt.add("700");
        bhk1_NoofFloor.add("6");
        bhk1_price.add("27.5Lacs");
        bhk2_FloorAreaSqFt.add("900");
        bhk2_NoofFloor.add("4");
        bhk2_price.add("36.5Lacs");
        bhk3_FloorAreaSqFt.add("1000");
        bhk3_NoofFloor.add("6");
        bhk3_price.add("90Lacs");
        List<RealtorProjectListModel> projectListMain = new ArrayList<RealtorProjectListModel>();
        for (int i = 0; i < projectName.size(); i++) {
            RealtorProjectListModel list = new RealtorProjectListModel();
            list.setProject_id(projectID.get(i).toString());
            list.setProject_Name(projectName.get(i).toString());
            list.setProject_date(projectDate.get(i).toString());
            list.setProject_Location(projectlocation.get(i).toString());
            list.setProjectDescription(ProjectDescription.get(i).toString());
            list.setBhk1_FloorAreaSqFt(bhk1_FloorAreaSqFt.get(i).toString());
            list.setBhk1_NoofFloor(bhk1_NoofFloor.get(i).toString());
            list.setBhk1_price(bhk1_price.get(i).toString());
            list.setBhk2_FloorAreaSqFt(bhk2_FloorAreaSqFt.get(i).toString());
            list.setBhk2_NoofFloor(bhk2_NoofFloor.get(i).toString());
            list.setBhk2_price(bhk2_price.get(i).toString());
            list.setBhk3_FloorAreaSqFt(bhk3_FloorAreaSqFt.get(i).toString());
            list.setBhk3_NoofFloor(bhk3_NoofFloor.get(i).toString());
            list.setBhk3_price(bhk3_price.get(i).toString());
            projectListMain.add(list);
        }
        ListView listView = (ListView) findViewById(R.id.lv_realtor_project_list);

        adapter = new RealtorProjectListAdapter(ProjectListActivity.this, projectListMain);

        listView.setAdapter(adapter);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;

    }
}


