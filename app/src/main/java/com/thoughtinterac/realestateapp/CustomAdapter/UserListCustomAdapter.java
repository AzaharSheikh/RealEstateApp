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

import com.thoughtinterac.realestateapp.Activities.MainActivity;
import com.thoughtinterac.realestateapp.Activities.Single_User_Details;
import com.thoughtinterac.realestateapp.Activities.Single_User_Task_Popup;
import com.thoughtinterac.realestateapp.Database.DatabaseHandler;
import com.thoughtinterac.realestateapp.Model.DocListModel;
import com.thoughtinterac.realestateapp.Model.UserModel;
import com.thoughtinterac.realestateapp.R;

import java.util.List;

/**
 * Created by AshwiniBadgujar on 07-10-2016.
 */
public class UserListCustomAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<UserModel> userListItems;
    public UserListCustomAdapter(Activity activity , List<UserModel> userListItems) {
        this.activity = activity;
        this.userListItems = userListItems;
    }

    @Override
    public int getCount() {
        return userListItems.size();
    }

    @Override
    public Object getItem(int position) {
        return userListItems.get(position);
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
            convertView = inflater.inflate(R.layout.tabitem, null);

        TextView user_name = (TextView) convertView.findViewById(R.id.user_name);
        TextView project_name = (TextView) convertView.findViewById(R.id.project_name);
        TextView user_address = (TextView) convertView.findViewById(R.id.user_address);
        TextView project_date = (TextView) convertView.findViewById(R.id.project_date);
        ImageView img_user_dp= (ImageView)convertView.findViewById(R.id.img_user_dp);
        LinearLayout lv_main=(LinearLayout)convertView.findViewById(R.id.lv_main);

        final UserModel m = userListItems.get(position);
        user_name.setText(m.getUserName());
        project_name.setText(m.getProjectName());
        user_address.setText(m.getUserAddr());
        project_date.setText(m.getDate());
        if(m.getGender().equalsIgnoreCase("Female"))
        {

            img_user_dp.setImageResource(R.drawable.femaledp);
        }else
        {
            img_user_dp.setImageResource(R.drawable.user);
        }
        lv_main.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(DatabaseHandler.KEY_USER_NAME, m.getUserName());
                //Toast.makeText(activity,"Long Press "+m.getUserName(),Toast.LENGTH_SHORT).show();
                Intent i = new Intent(activity, Single_User_Task_Popup.class);
                i.putExtras(bundle);
                activity.startActivity(i);
                return true;
            }
        });
        lv_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(DatabaseHandler.KEY_USER_NAME, m.getUserName());
                //Toast.makeText(activity,"Long Press "+m.getUserName(),Toast.LENGTH_SHORT).show();
                Intent i = new Intent(activity, Single_User_Task_Popup.class);
                i.putExtras(bundle);
                activity.startActivity(i);
            }
        });
        return convertView;
    }
}
