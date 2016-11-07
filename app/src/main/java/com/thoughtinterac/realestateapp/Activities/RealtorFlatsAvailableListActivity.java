package com.thoughtinterac.realestateapp.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;

import com.thoughtinterac.realestateapp.CustomAdapter.FlatsAvailableAdapter;
import com.thoughtinterac.realestateapp.CustomAdapter.InstallMentStatusAdapter;
import com.thoughtinterac.realestateapp.Model.FlatsAvailableModel;
import com.thoughtinterac.realestateapp.Model.InstallMentStatusModel;
import com.thoughtinterac.realestateapp.Model.SoldFlatsModel;
import com.thoughtinterac.realestateapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AzaharSheikh on 02-11-2016.
 */
public class RealtorFlatsAvailableListActivity extends AppCompatActivity {
    ArrayList<String> msgID, msgDetails, msgDate;
    ArrayList<String> NameoftheAuthor,FlatNo, FlatType,DateofPurchase,OutOfResale,Number;
    FlatsAvailableAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.realtor_flats_available);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        NameoftheAuthor= new ArrayList();
        FlatNo= new ArrayList();
        FlatType = new ArrayList();
        DateofPurchase = new ArrayList();
        OutOfResale = new ArrayList();
        Number = new ArrayList();

        Number.add("1");
        Number.add("2");


        NameoftheAuthor.add("Azahar S.");
        NameoftheAuthor.add("Ashwini B.");


        FlatNo.add("101");
        FlatNo.add("102");


        FlatType.add("1 BHK");
        FlatType.add("2 BHK");


        DateofPurchase.add("-");
        DateofPurchase.add("-");


        OutOfResale.add("-");
        OutOfResale.add("-");


        List<SoldFlatsModel> flatListItems = new ArrayList<SoldFlatsModel>();
        for(int i =0 ; i<NameoftheAuthor.size();i++)
        {
            SoldFlatsModel list = new SoldFlatsModel();
            list.setNameoftheAuthor(NameoftheAuthor.get(i).toString());
            list.setFlatNo(FlatNo.get(i).toString());
            list.setFlatType(FlatType.get(i).toString());
            list.setDateofPurchase(DateofPurchase.get(i).toString());
            list.setOutOfResale(OutOfResale.get(i).toString());
            list.setNumber(Number.get(i).toString());
            flatListItems.add(list);
        }
        ListView listView = (ListView)findViewById(R.id.realtor_flats_available_listview);

        adapter= new FlatsAvailableAdapter(this,flatListItems);

        listView.setAdapter(adapter);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;

    }
}
