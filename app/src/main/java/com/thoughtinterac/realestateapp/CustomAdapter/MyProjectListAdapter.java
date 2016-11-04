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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.thoughtinterac.realestateapp.Activities.MapActivity;
import com.thoughtinterac.realestateapp.Activities.UserMyProject;
import com.thoughtinterac.realestateapp.Model.DocListModel;
import com.thoughtinterac.realestateapp.Model.MyProjectListModel;
import com.thoughtinterac.realestateapp.Model.PlaceModel;
import com.thoughtinterac.realestateapp.R;

import java.util.List;

/**
 * Created by AzaharSheikh on 03-10-2016.
 */
public class MyProjectListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<MyProjectListModel> projectListItems;
    public MyProjectListAdapter(Activity activity, List<MyProjectListModel> projectListItems) {
        this.activity = activity;
        this.projectListItems = projectListItems;
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
            convertView = inflater.inflate(R.layout.user_myproject_list, null);

        TextView txt_project_name = (TextView) convertView.findViewById(R.id.txt_project_name);
        TextView txt_project_type = (TextView) convertView.findViewById(R.id.txt_project_type);
        TextView txt_project_location = (TextView) convertView.findViewById(R.id.txt_project_location);
        TextView txt_project_id = (TextView) convertView.findViewById(R.id.txt_project_id);
        Button btn_view = (Button)convertView.findViewById(R.id.btn_view);
        txt_project_id.setText((position+1)+".");
        final MyProjectListModel m = projectListItems.get(position);
        txt_project_name.setText(m.getProjectName());
        txt_project_type.setText(m.getProjectType());
        txt_project_location.setText(m.getProjectLocation());

        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, UserMyProject.class);
                i.putExtra("projectType",m.getProjectType());
                activity.startActivity(i);
                Toast toast = Toast.makeText(activity,m.getProjectName(), Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
               // toast.show();
            }
        });


        return convertView;
    }
}
