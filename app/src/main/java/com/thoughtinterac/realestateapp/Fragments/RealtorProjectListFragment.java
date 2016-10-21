package com.thoughtinterac.realestateapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
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
public class RealtorProjectListFragment extends Fragment {
    ArrayList<String> projectID,projectName,projectDate,projectlocation;
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

        projectID.add("1");
        projectID.add("2");
        projectID.add("3");
        projectID.add("4");
        projectName.add("Gemni");
        projectName.add("Arihant");
        projectName.add("MaDoc");
        projectName.add("Asian");
        projectDate.add("1/2/16");
        projectDate.add("2/2/16");
        projectDate.add("3/2/16");
        projectDate.add("3/2/16 ");
        projectlocation.add("Dubai, Abu dhabi city");
        projectlocation.add("Panvel, Navi Mumbai");
        projectlocation.add("Thane, Navi Mumbai");
        projectlocation.add("Chembur, Mumbai");
        List<RealtorProjectListModel> projectListMain = new ArrayList<RealtorProjectListModel>();
        for(int i =0 ; i<projectName.size();i++)
        {
            RealtorProjectListModel list = new RealtorProjectListModel();
            list.setProject_id(projectID.get(i).toString());
            list.setProject_Name(projectName.get(i).toString());
            list.setProject_date(projectDate.get(i).toString());
            list.setProject_Location(projectlocation.get(i).toString());
            projectListMain.add(list);
        }
        ListView listView = (ListView)rootView.findViewById(R.id.lv_realtor_project_list);

        adapter= new RealtorProjectListAdapter(getActivity(),projectListMain);

        listView.setAdapter(adapter);
        return rootView;
    }
}
