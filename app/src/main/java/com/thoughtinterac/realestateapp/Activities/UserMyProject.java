package com.thoughtinterac.realestateapp.Activities;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.thoughtinterac.realestateapp.CustomAdapter.PlaceCustomAdapter;
import com.thoughtinterac.realestateapp.Model.PlaceModel;
import com.thoughtinterac.realestateapp.R;
import com.thoughtinterac.realestateapp.Util.Utility;
import com.thoughtinterac.realestateapp.Util.makeServiceCall;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AzaharSheikh on 24-10-2016.
 */
public class UserMyProject extends AppCompatActivity {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static  String link="" ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RadioGroup rg_myproject,rg_flat_type;

    String data;
    ProgressDialog pDialog;
    LinearLayout li_my_project_photos;
    private ListView listView;
    private PlaceCustomAdapter adapter;
    double lat =19.077065;
    double lng=72.998993;
    int flag=0;
    LinearLayout li_overview;
    View rootView;
    TextView txt_value_area_sq_ft,txt_value_flat_available,txt_value_construction_stage,txt_value_extra_feature,txt_value_amenities,txt_value_price;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_project_layout);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        rg_myproject = (RadioGroup)findViewById(R.id.rg_myproject);
        rg_flat_type = (RadioGroup)findViewById(R.id.rg_flat_type);
        listView = (ListView)findViewById(R.id.list_place);
        listView.setVisibility(View.GONE);
        li_overview=(LinearLayout)findViewById(R.id.li_overview);
        li_my_project_photos=(LinearLayout)findViewById(R.id.li_my_project_photos);
        li_my_project_photos.setVisibility(View.GONE);
        initWidgets();
        Bundle extras = getIntent().getExtras();
        String projectType;
        if (extras != null) {
            projectType = extras.getString("projectType");
            if(projectType.equalsIgnoreCase("2BHK"))
            {
                RadioButton rbt_two_bhk_list = (RadioButton)findViewById(R.id.rbt_two_bhk_list);
                rbt_two_bhk_list.setVisibility(View.VISIBLE);
                rbt_two_bhk_list.setChecked(true);
                RadioButton rbt_one_bhk_details = (RadioButton)findViewById(R.id.rbt_one_bhk_details);
                rbt_one_bhk_details.setVisibility(View.GONE);
                txt_value_area_sq_ft.setText("1550");
                txt_value_flat_available.setText("5");
                txt_value_construction_stage.setText("View");
                txt_value_amenities.setText("View");
                txt_value_extra_feature.setText("View");
                txt_value_price.setText("90 Lac");
            }else
            {
                //1BHK

            }
        }
        rg_flat_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.rbt_one_bhk_details:
                        txt_value_area_sq_ft.setText("850");
                        txt_value_flat_available.setText("10");
                        txt_value_construction_stage.setText("View");
                        txt_value_amenities.setText("View");
                        txt_value_extra_feature.setText("View");
                        txt_value_price.setText("50 Lac");
                        break;
                    case R.id.rbt_two_bhk_list:
                        txt_value_area_sq_ft.setText("1200");
                        txt_value_flat_available.setText("5");
                        txt_value_construction_stage.setText("View");
                        txt_value_amenities.setText("View");
                        txt_value_extra_feature.setText("View");
                        txt_value_price.setText("90 Lac");
                        break;
                    case R.id.rbt_three_bhk:

                        txt_value_area_sq_ft.setText("1525");
                        txt_value_flat_available.setText("7");
                        txt_value_construction_stage.setText("View");
                        txt_value_amenities.setText("View");
                        txt_value_extra_feature.setText("View");
                        txt_value_price.setText("2 Cr");
                        break;
                }
            }
        });
        rg_myproject.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.rbt_project_details:
                        //Toast.makeText(getActivity(), "project details checked", Toast.LENGTH_SHORT).show();
                        listView.setVisibility(View.GONE);
                        li_overview.setVisibility(View.VISIBLE);
                        li_my_project_photos.setVisibility(View.GONE);
                        link = "http://www.gemini-properties.com/";
                        break;
                    case R.id.rbt_photos_list:
                        //Toast.makeText(getActivity(), "Photos details checked", Toast.LENGTH_SHORT).show();
                        listView.setVisibility(View.GONE);
                        li_overview.setVisibility(View.GONE);
                        li_my_project_photos.setVisibility(View.VISIBLE);
                        link = "http://www.gemini-properties.com/images";
                        break;
                    case R.id.rbt_map:
                        //Toast.makeText(getActivity(), "Map details checked", Toast.LENGTH_SHORT).show();
                        listView.setVisibility(View.VISIBLE);
                        li_overview.setVisibility(View.GONE);
                        li_my_project_photos.setVisibility(View.GONE);
                        link = "http://www.gemini-properties.com/places";
                        if(flag==0) {
                            getPlaceListAsync(lat, lng);
                            flag=1;
                        }

                        break;
                }
            }
        });
    }


    private void initWidgets() {
        txt_value_area_sq_ft=(TextView)findViewById(R.id.txt_value_area_sq_ft);
        txt_value_flat_available=(TextView)findViewById(R.id.txt_value_flat_available);
        txt_value_construction_stage=(TextView)findViewById(R.id.txt_value_construction_stage);
        txt_value_extra_feature=(TextView)findViewById(R.id.txt_value_extra_feature);
        txt_value_amenities=(TextView)findViewById(R.id.txt_value_amenities);
        txt_value_price=(TextView)findViewById(R.id.txt_value_price);
        txt_value_area_sq_ft.setText("850");
        txt_value_flat_available.setText("10");
        txt_value_amenities.setText("View");
        txt_value_construction_stage.setText("View");
        txt_value_extra_feature.setText("View");
        txt_value_price.setText("50 Lac");
        txt_value_amenities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(UserMyProject.this);
                dialog.setContentView(R.layout.amenities_layout);
                ImageView img_back= (ImageView) dialog.findViewById(R.id.img_back);
                if(img_back!=null) {
                    img_back.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                }
                dialog.show();
            }
        });
        txt_value_construction_stage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(UserMyProject.this);
                dialog.setContentView(R.layout.consteuctions_image_layout);
                ImageView img_back= (ImageView) dialog.findViewById(R.id.img_back);
                img_back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }

    private void getPlaceListAsync(final double lat,final double lng) {
        new fetchPlaceListDataAsync(lat,lng).execute("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+lat+","+lng+"&radius=5000&type=restaurant&name=cruise&key="+getResources().getString(R.string.api_key));
    }

    private class fetchPlaceListDataAsync extends AsyncTask<String, Void, String> {
        public fetchPlaceListDataAsync(double lat, double lng) {
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(UserMyProject.this);
            // Showing progress dialog before making http request
            pDialog.setMessage("Searching Place...");
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            String url = params[0];
            try {
                data = new makeServiceCall().makeServiceCall(url);
            } catch (Exception e) {
                e.printStackTrace();
                data="";
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("data",data);
            pDialog.dismiss();
            if(data != null && !data.equalsIgnoreCase(""))
            {
                try {
                    JSONObject json = new JSONObject(data);
                    String status = json.getString("status");
                    if(status.equalsIgnoreCase("OK"))
                    {
                        Toast.makeText(UserMyProject.this,"Status  OK",Toast.LENGTH_SHORT).show();
                        JSONArray jsonArray = json.getJSONArray("results");
                        // String array = jsonArray.toString();
                        List<PlaceModel> placeList = new ArrayList<PlaceModel>();
                        if(jsonArray!=null) {
                            for (int i = 0; i < jsonArray.length(); i++) {
                                PlaceModel place = new PlaceModel();
                                String place_title = jsonArray.getJSONObject(i).getString("name");
                                String place_id = jsonArray.getJSONObject(i).getString("place_id");
                                String place_address = jsonArray.getJSONObject(i).getString("vicinity");
                                String place_type = jsonArray.getJSONObject(i).getString("place_id");
                                String strLat =jsonArray.getJSONObject(i).getJSONObject("geometry").getJSONObject("location").getString("lat").toString();
                                String strLng =jsonArray.getJSONObject(i).getJSONObject("geometry").getJSONObject("location").getString("lng").toString();
                                place.setPlace_id(place_id);
                                place.setPlace_title(place_title);
                                place.setPlace_address(place_address);
                                place.setPlace_distance(Utility.distFrom(lat,lng,Double.parseDouble(strLat),Double.parseDouble(strLng))+" KM");
                                place.setPlace_type(jsonArray.getJSONObject(i).getJSONArray("types").getString(0));
                                place.setLat(strLat);
                                place.setLng(strLng);
                                placeList.add(place);
                            }
                            adapter = new PlaceCustomAdapter(UserMyProject.this, placeList);
                            listView.setAdapter(adapter);

                        }
                    }
                    else
                    {
                        Toast.makeText(UserMyProject.this,status,Toast.LENGTH_SHORT).show();
                    }
                    /*for(int i =0; i<json.length();i++)
                    {
                        if(json.getJSONObject(i).has("product_id")) {
                            String product_id = json.getJSONObject(i).getString("product_id");
                            String product_title = json.getJSONObject(i).getString("product_title");
                            String product_details = json.getJSONObject(i).getString("product_details");
                            String p_address = json.getJSONObject(i).getString("p_address");
                            String image_url = json.getJSONObject(i).getString("image_url");
                            Log.d("product_id",product_id);
                            Product product = new Product();
                            product.setTitle(product_title);
                            product.setP_details(product_details);
                            product.setP_address(p_address);
                            placeList.add(product);
                        }

                    }
                    adapter = new ProductCustomListAdapter(getActivity(), placeList);
                    listView.setAdapter(adapter);*/
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;

    }
}
