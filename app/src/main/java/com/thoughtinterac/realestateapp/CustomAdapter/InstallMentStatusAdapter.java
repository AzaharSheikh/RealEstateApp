package com.thoughtinterac.realestateapp.CustomAdapter;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.thoughtinterac.realestateapp.Model.InstallMentStatusModel;
import com.thoughtinterac.realestateapp.R;

import java.util.List;

/**
 * Created by AzaharSheikh on 29-10-2016.
 */
public class InstallMentStatusAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<InstallMentStatusModel> statusListItems;
    public InstallMentStatusAdapter(Activity activity, List<InstallMentStatusModel> statusListItems) {
        this.activity = activity;
        this.statusListItems = statusListItems;
    }

    @Override
    public int getCount() {
        return statusListItems.size();
    }

    @Override
    public Object getItem(int position) {
        return statusListItems.get(position);
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
            convertView = inflater.inflate(R.layout.installment_status_single_row, null);

        TextView txtInstallmentStatusId = (TextView) convertView.findViewById(R.id.txtInstallmentStatusId);
        TextView txtInstallmentStatusMsg = (TextView) convertView.findViewById(R.id.txtInstallmentStatusMsg);
        TextView txtInstallmentStatusDate = (TextView) convertView.findViewById(R.id.txtInstallmentStatusDate);


        final InstallMentStatusModel m = statusListItems.get(position);
        txtInstallmentStatusId.setText(m.getInstallMentStatusId());
        txtInstallmentStatusMsg.setText(m.getInstallMentStatusMessage());
        txtInstallmentStatusDate.setText(m.getInstallMentStatusDate());



        return convertView;
    }
}
