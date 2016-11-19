package com.thoughtinterac.realestateapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtinterac.realestateapp.Activities.MainActivity;
import com.thoughtinterac.realestateapp.Activities.RealtorMainPage;
import com.thoughtinterac.realestateapp.Activities.UserListActivity;
import com.thoughtinterac.realestateapp.R;

import java.sql.DatabaseMetaData;

/**
 * Created by AshwiniBadgujar on 14-10-2016.
 */
public class Realator_Profile_Fragment extends Fragment {
    TextView user_name;
    TextView name_text;


    public Realator_Profile_Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.welcome_realator, container, false);
//        user_name = (TextView) rootView.findViewById(R.id.user_name);
//        user_name.setText(RealtorMainPage.str_user_name);
        name_text=(TextView)rootView.findViewById(R.id.realator_name);
        //name_text.setText(MainActivity.str_user_name);
        if(MainActivity.str_user_name.equalsIgnoreCase("")) {
           // name_text.setText(RealtorMainPage.str_user_name);
        }
        ImageView img_userlist = (ImageView)rootView.findViewById(R.id.img_userlist);
        img_userlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), UserListActivity.class);
                startActivity(i);
            }
        });
        return rootView;

    }


}

