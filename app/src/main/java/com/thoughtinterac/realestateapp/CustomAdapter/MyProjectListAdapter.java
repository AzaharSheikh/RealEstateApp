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

import com.thoughtinterac.realestateapp.Activities.MapActivity;
import com.thoughtinterac.realestateapp.Model.DocListModel;
import com.thoughtinterac.realestateapp.Model.PlaceModel;
import com.thoughtinterac.realestateapp.R;

import java.util.List;

/**
 * Created by AzaharSheikh on 03-10-2016.
 */
public class MyProjectListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<DocListModel> projectListItems;
    public MyProjectListAdapter(Activity activity, List<DocListModel> docListItems) {
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
            convertView = inflater.inflate(R.layout.my_project_list, null);

        TextView doc_name = (TextView) convertView.findViewById(R.id.doc_name);
        ImageView img_status = (ImageView) convertView.findViewById(R.id.img_status);

        final DocListModel m = projectListItems.get(position);
        doc_name.setText(m.getDoc_name());
        if(m.getDoc_status().equalsIgnoreCase("true")){
            img_status.setImageResource(R.mipmap.verified);
        }else
        {
            img_status.setImageResource(R.mipmap.question);
        }
        doc_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(activity,m.getDoc_deatils(), Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });


        return convertView;
    }
}
