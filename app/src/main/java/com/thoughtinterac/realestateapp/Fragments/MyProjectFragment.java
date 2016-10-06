package com.thoughtinterac.realestateapp.Fragments;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.ScrollView;
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
 * Created by AzaharSheikh on 28-09-2016.
 */
public class MyProjectFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static  String link="" ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RadioGroup rg_myproject,rg_flat_type;
    private OnFragmentInteractionListener mListener;
    String data;
   ProgressDialog pDialog;
ScrollView li_my_project_photos;
    private ListView listView;
    private PlaceCustomAdapter adapter;
    double lat =19.077065;
    double lng=72.998993;
    int flag=0;
    LinearLayout li_overview;
    View rootView;
    TextView txt_value_area_sq_ft,txt_value_flat_available,txt_value_construction_stage,txt_value_extra_feature,txt_value_amenities,txt_value_price;


    public MyProjectFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CafeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyProjectFragment newInstance(String param1, String param2) {
        MyProjectFragment fragment = new MyProjectFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.my_project_layout, container, false);
        rg_myproject = (RadioGroup) rootView.findViewById(R.id.rg_myproject);
        rg_flat_type = (RadioGroup) rootView.findViewById(R.id.rg_flat_type);
        listView = (ListView) rootView.findViewById(R.id.list_place);
        listView.setVisibility(View.GONE);
        li_overview=(LinearLayout)rootView.findViewById(R.id.li_overview);
        li_my_project_photos=(ScrollView)rootView.findViewById(R.id.li_my_project_photos);
        li_my_project_photos.setVisibility(View.GONE);
        link = "http://www.gemini-properties.com/";
        initWidgets();
        rg_flat_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.rbt_one_bhk_details:
                        txt_value_area_sq_ft.setText("550");
                        txt_value_flat_available.setText("10");
                        txt_value_construction_stage.setText("Click Here");
                        txt_value_amenities.setText("Click Here");
                        txt_value_extra_feature.setText("Click Here");
                        txt_value_price.setText("50 Lac");
                        break;
                    case R.id.rbt_two_bhk_list:
                        txt_value_area_sq_ft.setText("1550");
                        txt_value_flat_available.setText("5");
                        txt_value_construction_stage.setText("Click Here");
                        txt_value_amenities.setText("Click Here");
                        txt_value_extra_feature.setText("Click Here");
                        txt_value_price.setText("90 Lac");
                        break;
                    case R.id.rbt_three_bhk:

                        txt_value_area_sq_ft.setText("2550");
                        txt_value_flat_available.setText("7");
                        txt_value_construction_stage.setText("Click Here");
                        txt_value_amenities.setText("Click Here");
                        txt_value_extra_feature.setText("Click Here");
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
        return rootView;

    }

    private void initWidgets() {
        txt_value_area_sq_ft=(TextView)rootView.findViewById(R.id.txt_value_area_sq_ft);
        txt_value_flat_available=(TextView)rootView.findViewById(R.id.txt_value_flat_available);
        txt_value_construction_stage=(TextView)rootView.findViewById(R.id.txt_value_construction_stage);
        txt_value_extra_feature=(TextView)rootView.findViewById(R.id.txt_value_extra_feature);
        txt_value_amenities=(TextView)rootView.findViewById(R.id.txt_value_amenities);
        txt_value_price=(TextView)rootView.findViewById(R.id.txt_value_price);
        txt_value_area_sq_ft.setText("550");
        txt_value_flat_available.setText("10");
        txt_value_amenities.setText("Click Here");
        txt_value_construction_stage.setText("Click Here");
        txt_value_extra_feature.setText("Click Here");
        txt_value_price.setText("50 Lac");
        txt_value_amenities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getActivity());
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
                final Dialog dialog = new Dialog(getActivity());
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
        new fetchListDataAsync(lat,lng).execute("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+lat+","+lng+"&radius=5000&type=restaurant&name=cruise&key="+getResources().getString(R.string.api_key));
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private class fetchListDataAsync extends AsyncTask<String, Void, String> {
        public fetchListDataAsync(double lat, double lng) {
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(getActivity());
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
                        Toast.makeText(getActivity(),"Status  OK",Toast.LENGTH_SHORT).show();
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
                            adapter = new PlaceCustomAdapter(getActivity(), placeList);
                            listView.setAdapter(adapter);

                        }
                    }
                    else
                    {
                        Toast.makeText(getActivity(),status,Toast.LENGTH_SHORT).show();
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
}
