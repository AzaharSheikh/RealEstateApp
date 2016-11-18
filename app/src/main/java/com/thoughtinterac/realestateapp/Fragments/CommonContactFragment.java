package com.thoughtinterac.realestateapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.thoughtinterac.realestateapp.Activities.CommonQuick_Enqiry;
import com.thoughtinterac.realestateapp.Activities.Quick_Enqiry;
import com.thoughtinterac.realestateapp.R;

/**
 * Created by AzaharSheikh on 18-11-2016.
 */
public class CommonContactFragment extends Fragment {
    public CommonContactFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.contact, container, false);
        Button Quick_Enquiry = (Button) rootView.findViewById(R.id.btn1);
        Quick_Enquiry.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Intent code for open new activity through intent.

                Intent i = new Intent(getActivity(), CommonQuick_Enqiry.class);
                startActivity(i);

            }

        });

        return rootView;
    }

}
