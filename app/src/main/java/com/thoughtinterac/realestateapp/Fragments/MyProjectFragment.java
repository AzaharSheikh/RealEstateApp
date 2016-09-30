package com.thoughtinterac.realestateapp.Fragments;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.thoughtinterac.realestateapp.R;
import com.thoughtinterac.realestateapp.Util.makeServiceCall;

import org.json.JSONArray;

/**
 * Created by AzaharSheikh on 28-09-2016.
 */
public class MyProjectFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RadioGroup rg_myproject;
    private OnFragmentInteractionListener mListener;
    String data;
   ProgressDialog pDialog;

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
        View rootView = inflater.inflate(R.layout.my_project_layout, container, false);
        rg_myproject = (RadioGroup) rootView.findViewById(R.id.rg_myproject);
       rg_myproject.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {
               switch (checkedId)
               {
                   case R.id.rbt_project_details:
                       Toast.makeText(getActivity(), "project details checked", Toast.LENGTH_SHORT).show();
                       break;
                   case R.id.rbt_photos_list:
                       Toast.makeText(getActivity(), "Photos details checked", Toast.LENGTH_SHORT).show();
                       break;
                   case R.id.rbt_map:
                       Toast.makeText(getActivity(), "Map details checked", Toast.LENGTH_SHORT).show();
                       double lat =19.077065;
                       double lng=72.998993;
                       getPlaceListAsync(lat,lng);

                       break;
               }
           }
       });
        return rootView;

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
                    JSONArray json = new JSONArray(data);

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
                            productList.add(product);
                        }

                    }
                    adapter = new ProductCustomListAdapter(getActivity(), productList);
                    listView.setAdapter(adapter);*/
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
