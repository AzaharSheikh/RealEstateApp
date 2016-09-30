package com.thoughtinterac.realestateapp.CustomAdapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.NetworkImageView;
import com.thoughtinterac.realestateapp.Model.PlaceModel;
import com.thoughtinterac.realestateapp.R;

import java.util.List;

/**
 * Created by AzaharSheikh on 30-09-2016.
 */
public class PlaceCustomAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<PlaceModel> placeItems;
    public PlaceCustomAdapter(Activity activity, List<PlaceModel> placeItems) {
        this.activity = activity;
        this.placeItems = placeItems;
    }

    @Override
    public int getCount() {
        return placeItems.size();
    }

    @Override
    public Object getItem(int position) {
        return placeItems.get(position);
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
            convertView = inflater.inflate(R.layout.single_row_item, null);

        TextView txt_place_name = (TextView) convertView.findViewById(R.id.txt_place_name);
        TextView txt_place_distance = (TextView) convertView.findViewById(R.id.txt_place_distance);
        TextView txt_place_address = (TextView) convertView.findViewById(R.id.txt_place_address);
        TextView txt_place_type = (TextView) convertView.findViewById(R.id.txt_place_type);
        final PlaceModel m = placeItems.get(position);
        /*Button btn_site_visit=(Button)convertView.findViewById(R.id.btn_site_visit);
        // getting movie data for the row
        final Product m = productItems.get(position);
        btn_site_visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                Toast.makeText(activity,m.getTitle(),Toast.LENGTH_LONG).show();

                Intent i = new Intent(activity, Product_Details_Activity.class);
                bundle.putString("title", m.getTitle());
                bundle.putString("details", m.getP_details());
                bundle.putString("address", m.getP_address());
                i.putExtras(bundle);
                activity.startActivity(i);
            }
        });*/
        // thumbnail image


        // title
        txt_place_name.setText(m.getPlace_title());
        txt_place_distance.setText(m.getPlace_distance());
        txt_place_address.setText(m.getPlace_address());
        txt_place_type.setText(m.getPlace_type());

        return convertView;
    }
}
