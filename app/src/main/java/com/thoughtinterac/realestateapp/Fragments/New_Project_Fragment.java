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
import android.widget.RadioGroup;
import android.widget.TextView;

import com.thoughtinterac.realestateapp.CustomAdapter.PlaceCustomAdapter;
import com.thoughtinterac.realestateapp.R;

import java.util.zip.Inflater;

/**
 * Created by AshwiniBadgujar on 10-10-2016.
 */

public class New_Project_Fragment extends Fragment {
    public New_Project_Fragment() {
    }


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.builder_new_project, container, false);
            return rootView;
        }




}
