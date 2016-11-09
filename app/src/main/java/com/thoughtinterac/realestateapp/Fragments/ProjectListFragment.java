package com.thoughtinterac.realestateapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.thoughtinterac.realestateapp.CustomAdapter.MyProjectListAdapter;
import com.thoughtinterac.realestateapp.Model.MyProjectListModel;
import com.thoughtinterac.realestateapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AshwiniBadgujar on 20-10-2016.
 */
public class ProjectListFragment extends Fragment {
    ArrayList<String> projectName, projectLocation,projectDate,projectType;
    private MyProjectListAdapter adapter;
    public ProjectListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.project_list, container, false);
        projectName = new ArrayList<>();
        projectLocation = new ArrayList<>();
        projectDate = new ArrayList<>();
        projectType = new ArrayList<>();

        projectName.add("Gemini Splendor");
        projectLocation.add("Dubai");
        projectDate.add("20/04/2016");
        projectType.add("1BHK");

        projectName.add("Gemini Splendor");
        projectLocation.add("Dubai");
        projectDate.add("22/04/2016");
        projectType.add("2BHK");


        List<MyProjectListModel> projectListMain = new ArrayList<MyProjectListModel>();
        for(int i =0 ; i<projectName.size();i++)
        {
            MyProjectListModel list = new MyProjectListModel();
            list.setProjectName(projectName.get(i));
            list.setProjectDate(projectDate.get(i));
            list.setProjectLocation(projectLocation.get(i));
            list.setProjectType(projectType.get(i));
            projectListMain.add(list);
        }
        ListView listView = (ListView)rootView.findViewById(R.id.project_list_view);

        adapter= new MyProjectListAdapter(getActivity(),projectListMain);

        listView.setAdapter(adapter);
        return rootView;

    }

}
