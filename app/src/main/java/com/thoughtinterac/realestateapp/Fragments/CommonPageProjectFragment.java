package com.thoughtinterac.realestateapp.Fragments;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.thoughtinterac.realestateapp.CustomAdapter.CommonPageProjectListAdapter;
import com.thoughtinterac.realestateapp.CustomAdapter.RealtorProjectListAdapter;
import com.thoughtinterac.realestateapp.Database.DatabaseHandler;
import com.thoughtinterac.realestateapp.Model.RealtorProjectListModel;
import com.thoughtinterac.realestateapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AzaharSheikh on 27-10-2016.
 */
public class CommonPageProjectFragment extends Fragment {
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
    CommonPageProjectListAdapter adapter;
    public CommonPageProjectFragment() {
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
        //
        DatabaseHandler handler= new DatabaseHandler(getActivity());
        SQLiteDatabase db = handler.getWritableDatabase();
        for(int i =0 ; i<projectName.size();i++)
        {
            // delete single row here------
            boolean status = db.delete(DatabaseHandler.TABLE_REALTOR_PROJECT_LIST, DatabaseHandler.KEY_Project_id + " = '" + projectID.get(i).toString() + "'", null) > 0;
            if(status)
            {
                Log.d("projectDataDelete","true");
            }
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


            ContentValues values = new ContentValues();
            values.put(DatabaseHandler.KEY_Project_id,projectID.get(i).toString());
            values.put(DatabaseHandler.KEY_Project_Name,projectName.get(i).toString());
            values.put(DatabaseHandler.KEY_Project_Location,projectlocation.get(i).toString());
            values.put(DatabaseHandler.KEY_ProjectDescription,ProjectDescription.get(i).toString());
            values.put(DatabaseHandler.KEY_bhk1_FloorAreaSqFt,bhk1_FloorAreaSqFt.get(i).toString());
            values.put(DatabaseHandler.KEY_bhk1_NoofFloor,bhk1_NoofFloor.get(i).toString());
            values.put(DatabaseHandler.KEY_bhk1_price,bhk1_price.get(i).toString());
            values.put(DatabaseHandler.KEY_bhk2_FloorAreaSqFt,bhk2_FloorAreaSqFt.get(i).toString());

            values.put(DatabaseHandler.KEY_bhk2_NoofFloor,bhk2_NoofFloor.get(i).toString());
            values.put(DatabaseHandler.KEY_bhk2_price,bhk2_price.get(i).toString());
            values.put(DatabaseHandler.KEY_bhk3_FloorAreaSqFt,bhk3_FloorAreaSqFt.get(i).toString());
            values.put(DatabaseHandler.KEY_bhk3_NoofFloor,bhk3_NoofFloor.get(i).toString());
            values.put(DatabaseHandler.KEY_bhk3_price,bhk3_price.get(i).toString());
            values.put(DatabaseHandler.KEY_SEARCH_COL,projectName.get(i).toString()+" "+ projectlocation.get(i).toString()+""+ProjectDescription.get(i).toString());

            boolean b = db.insert(DatabaseHandler.TABLE_REALTOR_PROJECT_LIST,null,values)>0;
            if(b)
            {
                Log.d("projectDataInsert","true");
            }
            values.clear();
            values.put(DatabaseHandler.KEY_Project_id,projectID.get(i).toString());
            values.put(DatabaseHandler.KEY_SEARCH_COL,projectName.get(i).toString()+" "+ projectlocation.get(i).toString()+""+ProjectDescription.get(i).toString());
            boolean status1 = db.delete(DatabaseHandler.TABLE_REALTOR_PROJECT_LIST_VERTUAL, DatabaseHandler.KEY_Project_id + " = '" + projectID.get(i).toString() + "'", null) > 0;
            if(status1)
            {
                Log.d("ver_projectDataDelete","true");
            }
            boolean b1 = db.insert(DatabaseHandler.TABLE_REALTOR_PROJECT_LIST_VERTUAL,null,values)>0;
            if(b1)
            {
                Log.d("ver_projectDataInsert","true");
            }
        }
        handler.close();
        db.close();
        ListView listView = (ListView)rootView.findViewById(R.id.lv_realtor_project_list);

        adapter= new CommonPageProjectListAdapter(getActivity(),projectListMain);

        listView.setAdapter(adapter);
        return rootView;
    }
}
