package com.thoughtinterac.realestateapp.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.thoughtinterac.realestateapp.CustomAdapter.FlatsAvailableAdapter;
import com.thoughtinterac.realestateapp.CustomAdapter.InstallMentStatusAdapter;
import com.thoughtinterac.realestateapp.Model.FlatsAvailableModel;
import com.thoughtinterac.realestateapp.Model.InstallMentStatusModel;
import com.thoughtinterac.realestateapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AzaharSheikh on 02-11-2016.
 */
public class RealtorFlatsAvailableListActivity extends AppCompatActivity {
    ArrayList<String> msgID, msgDetails, msgDate;

    FlatsAvailableAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.realtor_flats_available);
        msgID = new ArrayList();
        msgDetails = new ArrayList();
        msgDate = new ArrayList();


        msgID.add("1.");
        msgID.add("2.");


        msgDetails.add("1 flat on 2nd floor");
        msgDetails.add("1 flat on 3rd floor");


        msgDate.add("01/02/2016");
        msgDate.add("02/03/2016");



        List<FlatsAvailableModel> flatsListMain = new ArrayList<FlatsAvailableModel>();
        for(int i = 0; i< msgDetails.size(); i++)
        {
            FlatsAvailableModel list = new FlatsAvailableModel();
            list.setMsgId (msgID.get(i).toString());
            list.setMsgDetails(msgDetails.get(i).toString());
            list.setMsgDate( msgDate.get(i).toString());
            flatsListMain.add(list);
        }
        ListView listView = (ListView)findViewById(R.id.realtor_flats_available_listview);

        adapter= new FlatsAvailableAdapter(this,flatsListMain);

        listView.setAdapter(adapter);
    }
}
