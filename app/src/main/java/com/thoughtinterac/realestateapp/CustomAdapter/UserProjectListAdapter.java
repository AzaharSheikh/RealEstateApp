package com.thoughtinterac.realestateapp.CustomAdapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thoughtinterac.realestateapp.Activities.RealtorSingleProjectActivity;
import com.thoughtinterac.realestateapp.Activities.UserSingleProjectActivity;
import com.thoughtinterac.realestateapp.Model.RealtorProjectListModel;
import com.thoughtinterac.realestateapp.R;

import java.util.List;

/**
 * Created by AzaharSheikh on 09-11-2016.
 */
public class UserProjectListAdapter extends BaseAdapter{
    private Activity activity;
    private LayoutInflater inflater;
    private List<RealtorProjectListModel> projectListItems;
    public UserProjectListAdapter(Activity activity, List<RealtorProjectListModel> projectListItems) {
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
            convertView = inflater.inflate(R.layout.realtor_project_list_row, null);

        TextView project_name = (TextView) convertView.findViewById(R.id.project_name);
        TextView project_location = (TextView) convertView.findViewById(R.id.project_location);
        TextView project_date = (TextView) convertView.findViewById(R.id.project_date);
        TextView txt_project_no = (TextView)convertView.findViewById(R.id.txt_project_no);
        LinearLayout li_realtor_project_list_main = (LinearLayout)convertView.findViewById(R.id.li_realtor_project_list_main);


        final RealtorProjectListModel m = projectListItems.get(position);
        project_name.setText(m.getProject_Name());
        project_location.setText(m.getProject_Location());
        project_date.setText(m.getProject_date());
        txt_project_no.setText(m.getProject_id());
        ImageView img_project_icon= (ImageView)convertView.findViewById(R.id.img_project_icon);

        ImageView img_new_project_icon= (ImageView)convertView.findViewById(R.id.img_new_project_icon);
        Button btn_view = (Button)convertView.findViewById(R.id.btn_view);
        if(m.getProject_id().toString().equalsIgnoreCase("1"))
        {
            img_new_project_icon.setVisibility(View.GONE);
        }else
        {
            img_new_project_icon.setVisibility(View.VISIBLE);
        }
        li_realtor_project_list_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Toast toast = Toast.makeText(activity,m.getProject_Name(), Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();*/
                Intent i = new Intent(activity, UserSingleProjectActivity.class);
                i.putExtra("Project_id", m.getProject_id());
                i.putExtra("Project_Name", m.getProject_Name());
                i.putExtra("Project_date", m.getProject_date());
                i.putExtra("Project_Location", m.getProject_Location());
                i.putExtra("ProjectDescription", m.getProjectDescription());
                i.putExtra("bhk1_FloorAreaSqFt", m.getBhk1_FloorAreaSqFt());
                i.putExtra("bhk1_NoofFloor", m.getBhk1_NoofFloor());
                i.putExtra("bhk1_price", m.getBhk1_price());
                i.putExtra("bhk2_FloorAreaSqFt", m.getBhk2_FloorAreaSqFt());
                i.putExtra("bhk2_NoofFloor", m.getBhk2_NoofFloor());
                i.putExtra("bhk2_price", m.getBhk2_price());
                i.putExtra("bhk3_FloorAreaSqFt", m.getBhk3_FloorAreaSqFt());
                i.putExtra("bhk3_NoofFloor", m.getBhk3_NoofFloor());
                i.putExtra("bhk3_price", m.getBhk3_price());

                activity.startActivity(i);
            }
        });

        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, UserSingleProjectActivity.class);
                i.putExtra("Project_id", m.getProject_id());
                i.putExtra("Project_Name", m.getProject_Name());
                i.putExtra("Project_date", m.getProject_date());
                i.putExtra("Project_Location", m.getProject_Location());
                i.putExtra("ProjectDescription", m.getProjectDescription());
                i.putExtra("bhk1_FloorAreaSqFt", m.getBhk1_FloorAreaSqFt());
                i.putExtra("bhk1_NoofFloor", m.getBhk1_NoofFloor());
                i.putExtra("bhk1_price", m.getBhk1_price());
                i.putExtra("bhk2_FloorAreaSqFt", m.getBhk2_FloorAreaSqFt());
                i.putExtra("bhk2_NoofFloor", m.getBhk2_NoofFloor());
                i.putExtra("bhk2_price", m.getBhk2_price());
                i.putExtra("bhk3_FloorAreaSqFt", m.getBhk3_FloorAreaSqFt());
                i.putExtra("bhk3_NoofFloor", m.getBhk3_NoofFloor());
                i.putExtra("bhk3_price", m.getBhk3_price());

                activity.startActivity(i);
            }
        });
        return convertView;
    }
}

