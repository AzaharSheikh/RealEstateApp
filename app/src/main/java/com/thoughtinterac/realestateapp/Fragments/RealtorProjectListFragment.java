package com.thoughtinterac.realestateapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.thoughtinterac.realestateapp.Activities.RealtorMainPage;
import com.thoughtinterac.realestateapp.Activities.SearchProjectActivity;
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
public class RealtorProjectListFragment extends Fragment {
    ArrayList<String> projectID,projectName,projectDate,projectlocation;
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
    public RealtorProjectListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.realtor_project_list, container, false);
        projectID= new ArrayList();
        projectName= new ArrayList();
        projectDate= new ArrayList();
        projectlocation = new ArrayList();
        ProjectDescription = new ArrayList();
        bhk1_FloorAreaSqFt= new ArrayList<>();
        bhk1_NoofFloor= new ArrayList<>();
        bhk1_price= new ArrayList<>();
        bhk2_FloorAreaSqFt= new ArrayList<>();
        bhk2_NoofFloor= new ArrayList<>();
        bhk2_price= new ArrayList<>();
        bhk3_FloorAreaSqFt= new ArrayList<>();
        bhk3_NoofFloor= new ArrayList<>();
        bhk3_price= new ArrayList<>();

        projectID.add("1");
        projectID.add("2");
        projectID.add("3");

        projectName.add("Gemni");
        projectName.add("Gemni");
        projectName.add("Gemni");

        projectDate.add("1/2/16");
        projectDate.add("2/2/16");
        projectDate.add("3/2/16");

        projectlocation.add("Dubai, Abu dhabi city");
        projectlocation.add("Panvel, Navi Mumbai");
        projectlocation.add("Thane, Navi Mumbai");


        ProjectDescription.add("Building Icons is a standard affair for Dubai, but Mohammed Bin Rashid Al Maktoum City is truly a breath-taking world icon.");
        bhk1_FloorAreaSqFt.add("50");
        bhk1_NoofFloor.add("6");
        bhk1_price.add("1000000");
        bhk2_FloorAreaSqFt.add("100");
        bhk2_NoofFloor.add("4");
        bhk2_price.add("200000");
        bhk3_FloorAreaSqFt.add("200");
        bhk3_NoofFloor.add("6");
        bhk3_price.add("300000");

        ProjectDescription .add("Building Icons is a standard affair for Dubai, but Mohammed Bin Rashid Al Maktoum City is truly a breath-taking world icon.");
        bhk1_FloorAreaSqFt.add("50");
        bhk1_NoofFloor.add("6");
        bhk1_price.add("1000000");
        bhk2_FloorAreaSqFt.add("100");
        bhk2_NoofFloor.add("4");
        bhk2_price.add("200000");
        bhk3_FloorAreaSqFt.add("200");
        bhk3_NoofFloor.add("6");
        bhk3_price.add("300000");

        ProjectDescription .add("Building Icons is a standard affair for Dubai, but Mohammed Bin Rashid Al Maktoum City is truly a breath-taking world icon.");
        bhk1_FloorAreaSqFt.add("50");
        bhk1_NoofFloor.add("6");
        bhk1_price.add("1000000");
        bhk2_FloorAreaSqFt.add("100");
        bhk2_NoofFloor.add("4");
        bhk2_price.add("200000");
        bhk3_FloorAreaSqFt.add("200");
        bhk3_NoofFloor.add("6");
        bhk3_price.add("300000");
        List<RealtorProjectListModel> projectListMain = new ArrayList<RealtorProjectListModel>();
        for(int i =0 ; i<projectName.size();i++)
        {
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
        ListView listView = (ListView)rootView.findViewById(R.id.lv_realtor_project_list);

        adapter= new RealtorProjectListAdapter(getActivity(),projectListMain);

        listView.setAdapter(adapter);
        return rootView;
    }
}
