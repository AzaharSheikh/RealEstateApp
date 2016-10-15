package com.thoughtinterac.realestateapp.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtinterac.realestateapp.R;

import java.sql.DatabaseMetaData;

/**
 * Created by AshwiniBadgujar on 14-10-2016.
 */
public class Realator_Profile_Fragment extends Fragment {

    public Realator_Profile_Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.welcome_realator, container, false);
        return rootView;

    }
}

