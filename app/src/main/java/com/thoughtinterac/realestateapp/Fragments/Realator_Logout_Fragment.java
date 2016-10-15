package com.thoughtinterac.realestateapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtinterac.realestateapp.R;

/**
 * Created by AshwiniBadgujar on 15-10-2016.
 */
public class Realator_Logout_Fragment extends Fragment {
    public Realator_Logout_Fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.logout, container, false);
        return rootView;
    }
}