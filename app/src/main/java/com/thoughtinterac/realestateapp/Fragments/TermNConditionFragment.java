package com.thoughtinterac.realestateapp.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtinterac.realestateapp.R;

/**
 * Created by AzaharSheikh on 06-10-2016.
 */
public class TermNConditionFragment extends Fragment {
    public TermNConditionFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.term_n_condition, container, false);
        return rootView;
    }
}