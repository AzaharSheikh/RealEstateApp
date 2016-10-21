package com.thoughtinterac.realestateapp.CustomAdapter;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.thoughtinterac.realestateapp.Model.RealtorProjectListModel;
import com.thoughtinterac.realestateapp.R;

import java.util.List;

/**
 * Created by AzaharSheikh on 21-10-2016.
 */
public class RealtorProjectListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<RealtorProjectListModel> projectListItems;
    public RealtorProjectListAdapter(Activity activity, List<RealtorProjectListModel> projectListItems) {
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

        li_realtor_project_list_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(activity,m.getProject_Name(), Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });


        return convertView;
    }
}
