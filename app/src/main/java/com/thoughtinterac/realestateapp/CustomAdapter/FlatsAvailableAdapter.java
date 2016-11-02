package com.thoughtinterac.realestateapp.CustomAdapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.thoughtinterac.realestateapp.Model.FlatsAvailableModel;
import com.thoughtinterac.realestateapp.Model.InstallMentStatusModel;
import com.thoughtinterac.realestateapp.R;

import java.util.List;

/**
 * Created by AzaharSheikh on 02-11-2016.
 */
public class FlatsAvailableAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<FlatsAvailableModel> flatsListItems;
    public FlatsAvailableAdapter(Activity activity, List<FlatsAvailableModel> flatsListItems) {
        this.activity = activity;
        this.flatsListItems = flatsListItems;
    }

    @Override
    public int getCount() {
        return flatsListItems.size();
    }

    @Override
    public Object getItem(int position) {
        return flatsListItems.get(position);
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
            convertView = inflater.inflate(R.layout.realtor_flats_available_listview_single_row, null);

        TextView txt_flts_available_msg_id = (TextView) convertView.findViewById(R.id.txt_flts_available_msg_id);
        TextView txt_flts_available_msg_details = (TextView) convertView.findViewById(R.id.txt_flts_available_msg_details);
        TextView txt_flts_available_msg_date = (TextView) convertView.findViewById(R.id.txt_flts_available_msg_date);


        final FlatsAvailableModel m = flatsListItems.get(position);
        txt_flts_available_msg_id.setText(m.getMsgId());
        txt_flts_available_msg_details.setText(m.getMsgDetails());
        txt_flts_available_msg_date.setText(m.getMsgDate());



        return convertView;
    }
}
