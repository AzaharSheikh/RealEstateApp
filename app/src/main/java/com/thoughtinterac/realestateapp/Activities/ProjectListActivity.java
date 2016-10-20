package com.thoughtinterac.realestateapp.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.ListView;

import com.thoughtinterac.realestateapp.CustomAdapter.MyDocListAdapter;
import com.thoughtinterac.realestateapp.CustomAdapter.ProjectListAdapter;
import com.thoughtinterac.realestateapp.CustomAdapter.UserListCustomAdapter;
import com.thoughtinterac.realestateapp.Model.DocListModel;
import com.thoughtinterac.realestateapp.Model.ProjectModel;
import com.thoughtinterac.realestateapp.Model.UserModel;
import com.thoughtinterac.realestateapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AshwiniBadgujar on 07-10-2016.
 */
public class ProjectListActivity extends AppCompatActivity {
    ArrayList<String> projectName,projectDate,projectlocation;
    private ProjectListAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_list);
        projectName= new ArrayList();
        projectDate= new ArrayList();
        projectlocation = new ArrayList();


        projectName.add("true");
        projectName.add("true");
        projectName.add("false");
        projectName.add("true");
        projectDate.add("1/2/16");
        projectDate.add("2/2/16");
        projectDate.add("3/2/16");
        projectDate.add("Noc staus ");
        projectlocation.add("abc");
        projectlocation.add("xyz");
        projectlocation.add("pqr");
        projectlocation.add("Noc staus ");

        List<ProjectModel> projectListMain = new ArrayList<ProjectModel>();
        for(int i =0 ; i<projectName.size();i++)
        {
            ProjectModel list = new ProjectModel();

            list.setProjectName(projectName.get(i).toString());
            list.setDate(projectDate.get(i).toString());
            list.setUserAddr(projectlocation.get(i).toString());
            projectListMain.add(list);
        }
        ListView listView = (ListView)findViewById(R.id.project_list);

        adapter= new ProjectListAdapter(ProjectListActivity.this,projectListMain);

        listView.setAdapter(adapter);
    }
}
