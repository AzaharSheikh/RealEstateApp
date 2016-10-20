package com.thoughtinterac.realestateapp.CustomAdapter;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.thoughtinterac.realestateapp.Activities.Single_User_Task_Popup;
import com.thoughtinterac.realestateapp.Database.DatabaseHandler;
import com.thoughtinterac.realestateapp.Model.DocListModel;
import com.thoughtinterac.realestateapp.Model.ProjectModel;
import com.thoughtinterac.realestateapp.Model.UserModel;
import com.thoughtinterac.realestateapp.R;

import java.util.List;

/**
 * Created by AshwiniBadgujar on 07-10-2016.
 */
public class ProjectListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<ProjectModel> projectListItems;
    public ProjectListAdapter(Activity activity , List<ProjectModel> userListItems) {
        this.activity = activity;
        this.projectListItems = userListItems;
    }

    @Override
    public int getCount() {
        return projectListItems.size();
    }

    @Override
    public Object getItem(int position) {
        return projectListItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.single_project_list, null);


        TextView project_name = (TextView) convertView.findViewById(R.id.project_name);
        TextView project_location = (TextView) convertView.findViewById(R.id.project_location);
        TextView project_date = (TextView) convertView.findViewById(R.id.project_date);
        LinearLayout lv_main=(LinearLayout)convertView.findViewById(R.id.lv_main);

        final ProjectModel m = projectListItems.get(position);

        project_name.setText(m.getProjectName());
        project_location.setText(m.getUserAddr());
        project_date.setText(m.getDate());
        return convertView;
    }
}
