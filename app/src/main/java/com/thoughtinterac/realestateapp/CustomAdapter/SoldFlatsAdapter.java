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

import com.thoughtinterac.realestateapp.Activities.RealatorSingleFlatSoldActivity;
import com.thoughtinterac.realestateapp.Activities.Single_User_Details;
import com.thoughtinterac.realestateapp.Activities.Single_User_Task_Popup;
import com.thoughtinterac.realestateapp.Database.DatabaseHandler;
import com.thoughtinterac.realestateapp.Model.DocListModel;
import com.thoughtinterac.realestateapp.Model.SoldFlatsModel;
import com.thoughtinterac.realestateapp.Model.UserModel;
import com.thoughtinterac.realestateapp.R;
import com.thoughtinterac.realestateapp.Util.FontCache;

import java.util.List;

/**
 * Created by AshwiniBadgujar on 07-10-2016.
 */
public class SoldFlatsAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<SoldFlatsModel> flatListItems;
    public SoldFlatsAdapter(Activity activity , List<SoldFlatsModel> flatListItems) {
        this.activity = activity;
        this.flatListItems = flatListItems;
    }

    public SoldFlatsAdapter() {

    }

    @Override
    public int getCount() {
        return flatListItems.size();
    }

    @Override
    public Object getItem(int position) {
        return flatListItems.get(position);
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
            convertView = inflater.inflate(R.layout.realator_flat_listview, null);
        LinearLayout lv_main=(LinearLayout) convertView.findViewById(R.id.lv_main);


//        TextView txt_view_author_name1 = (TextView) convertView.findViewById(R.id.txt_view_author_name1);
        TextView txt_view_author_name2 = (TextView) convertView.findViewById(R.id.txt_view_author_name2);
        TextView flat_no1 = (TextView) convertView.findViewById(R.id.flat_no1);
        TextView flat_no2 = (TextView) convertView.findViewById(R.id.flat_no2);
        TextView flat_type2 = (TextView) convertView.findViewById(R.id.flat_type2);
        TextView date_of_purchase2 = (TextView) convertView.findViewById(R.id.date_of_purchase2);
        TextView Out_of_resale2 = (TextView) convertView.findViewById(R.id.Out_of_resale2);
        TextView txt_flat_list_number = (TextView) convertView.findViewById(R.id.txt_flat_list_number);



        final SoldFlatsModel m = flatListItems.get(position);
//        txt_view_author_name1.setText(m.getNameoftheAuthor());
        txt_view_author_name2.setText(m.getNameoftheAuthor());
//        flat_no1.setText(m.getFlatNo());
        flat_no2.setText(m.getFlatNo());
        flat_type2.setText(m.getFlatType());
        date_of_purchase2.setText(m.getDateofPurchase());
        Out_of_resale2.setText(m.getOutOfResale());
        txt_flat_list_number.setText(m.getNumber());

        lv_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(activity, RealatorSingleFlatSoldActivity.class);
                activity.startActivity(i);
            }
        });
        return convertView;
    }




}
