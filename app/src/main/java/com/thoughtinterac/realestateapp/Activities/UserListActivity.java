package com.thoughtinterac.realestateapp.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.thoughtinterac.realestateapp.CustomAdapter.MyDocListAdapter;
import com.thoughtinterac.realestateapp.CustomAdapter.UserListCustomAdapter;
import com.thoughtinterac.realestateapp.Model.DocListModel;
import com.thoughtinterac.realestateapp.Model.UserModel;
import com.thoughtinterac.realestateapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AshwiniBadgujar on 07-10-2016.
 */
public class UserListActivity extends AppCompatActivity {
    ArrayList<String> userName,projectName, userAddress,projectDate;
    private UserListCustomAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list);
        userName= new ArrayList();
        projectName= new ArrayList();
        userAddress = new ArrayList();
        projectDate = new ArrayList();
        userName.add("Azahar S.");
        userName.add("Ashwini B.");
        userName.add("Krishna G.");
        userName.add("Dadoos B.");
        userName.add("Anuradha R.");
        projectName.add("Gemini Mumbai");
        projectName.add("Ma Doc Vashi");
        projectName.add("Arihant Panvel");
        projectName.add("Gemini Vashi");
        projectName.add("Gemini Thane");
        userAddress.add("Airoli, Navi Mumbai");
        userAddress.add("Sandapa, Navi Mumbai");
        userAddress.add("Gujrat,");
        userAddress.add("Nerul, Navi Mumbai");
        userAddress.add("Kharegoan,Thane");
        projectDate.add("10-Mar-2016");
        projectDate.add("20-Apr-2016");
        projectDate.add("10-Feb-2016");
        projectDate.add("20-Feb-2016 ");
        projectDate.add("20-Feb-2016 ");
        List<UserModel> userListMain = new ArrayList<UserModel>();
        for(int i =0 ; i<userName.size();i++)
        {
            UserModel list = new UserModel();
            list.setUserName(userName.get(i).toString());
            list.setProjectName(projectName.get(i).toString());
            list.setUserAddr(userAddress.get(i).toString());
            list.setDate(projectDate.get(i).toString());
            userListMain.add(list);
        }
        ListView listView = (ListView)findViewById(R.id.user_list_view);

        adapter= new UserListCustomAdapter(UserListActivity.this,userListMain);

        listView.setAdapter(adapter);
    }

    }


