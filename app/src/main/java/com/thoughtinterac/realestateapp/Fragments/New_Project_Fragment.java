package com.thoughtinterac.realestateapp.Fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.thoughtinterac.realestateapp.CustomAdapter.PlaceCustomAdapter;
import com.thoughtinterac.realestateapp.R;

import java.util.zip.Inflater;

/**
 * Created by AshwiniBadgujar on 10-10-2016.
 */

public class New_Project_Fragment extends Fragment {
    RadioGroup rg_flat_type,rg_myproject;
    LinearLayout li_one_bhk,li_two_bhk,li_three_bhk,li_main_photo_list,li_main_project_status;
    ScrollView sc_new_project_details;

    public New_Project_Fragment() {
    }


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.builder_new_project, container, false);
            rg_myproject=(RadioGroup) rootView.findViewById(R.id.rg_myproject);
//
            rg_flat_type=(RadioGroup) rootView.findViewById(R.id.rg_flat_type);
            li_one_bhk=(LinearLayout)rootView.findViewById(R.id.li_one_bhk);
            li_two_bhk=(LinearLayout)rootView.findViewById(R.id.li_two_bhk);
            li_three_bhk=(LinearLayout)rootView.findViewById(R.id.li_three_bhk);
            li_main_photo_list=(LinearLayout)rootView.findViewById(R.id.li_main_photo_list);
            sc_new_project_details=(ScrollView)rootView.findViewById(R.id.sc_new_project_details);
            li_main_project_status=(LinearLayout)rootView.findViewById(R.id.li_main_project_status);
            RadioButton rbt_project_status = (RadioButton)rootView.findViewById(R.id.rbt_project_status) ;
            rbt_project_status.setVisibility(View.GONE);
            rg_myproject.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch (checkedId)
                    {
                        case R.id.rbt_project_details:
                            sc_new_project_details.setVisibility(View.VISIBLE);
                            li_main_photo_list.setVisibility(View.GONE);
                            li_main_project_status.setVisibility(View.GONE);
                            break;
                        case R.id.rbt_project_status:
                            li_main_project_status.setVisibility(View.VISIBLE);
                            sc_new_project_details.setVisibility(View.GONE);
                            li_main_photo_list.setVisibility(View.GONE);
                            break;
                        case R.id.rbt_photos_list:
                            sc_new_project_details.setVisibility(View.GONE);
                            li_main_photo_list.setVisibility(View.VISIBLE);
                            li_main_project_status.setVisibility(View.GONE);
                            break;


                    }
                }
            });
            rg_flat_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch (checkedId)
                    {
                        case R.id.rbt_one_bhk_details:
                            li_two_bhk.setVisibility(View.GONE);
                            li_three_bhk.setVisibility(View.GONE);
                            li_one_bhk.setVisibility(View.VISIBLE);
                            break;
                        case R.id.rbt_two_bhk_list:
//                            li_three_bhk.setVisibility(View.GONE);
//                            li_one_bhk.setVisibility(View.GONE);
//                            li_two_bhk.setVisibility(View.VISIBLE);
                            break;
                        case R.id.rbt_three_bhk:
//                            li_two_bhk.setVisibility(View.GONE);
//                            li_one_bhk.setVisibility(View.GONE);
//                            li_three_bhk.setVisibility(View.VISIBLE);
                            break;
                    }
                }
            });

            return rootView;

        }
    }

    