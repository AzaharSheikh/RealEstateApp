package com.thoughtinterac.realestateapp.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
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
        userName.add("PAN");
        userName.add("AADHAR");
        userName.add("RC");
        userName.add("NOC");
        projectName.add("true");
        projectName.add("true");
        projectName.add("false");
        projectName.add("true");
        userAddress.add("HSJADJSAN2672482482");
        userAddress.add("ADHARC CARD Number");
        userAddress.add("Rc no.12212123");
        userAddress.add("Noc staus ");
        projectDate.add("HSJADJSAN2672482482");
        projectDate.add("ADHARC CARD Number");
        projectDate.add("Rc no.12212123");
        projectDate.add("Noc staus ");
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
        ListView listView = (ListView)findViewById(R.id.doc_list);

        adapter= new UserListCustomAdapter(UserListActivity.this,userListMain);

        listView.setAdapter(adapter);
    }
}
