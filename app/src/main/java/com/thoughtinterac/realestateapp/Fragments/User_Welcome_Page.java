package com.thoughtinterac.realestateapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtinterac.realestateapp.Activities.MainActivity;
import com.thoughtinterac.realestateapp.Activities.RealtorMainPage;
import com.thoughtinterac.realestateapp.Activities.ProjectListActivity;
import com.thoughtinterac.realestateapp.Activities.UserListActivity;
import com.thoughtinterac.realestateapp.Activities.UserMyProject;
import com.thoughtinterac.realestateapp.R;

/**
 * Created by AshwiniBadgujar on 14-10-2016.
 */
public class User_Welcome_Page extends Fragment {
    TextView name_text;
    public User_Welcome_Page() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.welcome_user, container, false);
        name_text=(TextView)rootView.findViewById(R.id.name_text);
        name_text.setText(MainActivity.str_user_name);
        if(MainActivity.str_user_name.equalsIgnoreCase("")) {
            name_text.setText(RealtorMainPage.str_user_name);
        }
        ImageView img_userlist = (ImageView)rootView.findViewById(R.id.img_project);
        img_userlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), UserMyProject.class);
                startActivity(i);
            }
        });
        return rootView;
    }
}
