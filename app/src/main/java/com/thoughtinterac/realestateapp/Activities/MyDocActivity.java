package com.thoughtinterac.realestateapp.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.thoughtinterac.realestateapp.CustomAdapter.MyDocListAdapter;
import com.thoughtinterac.realestateapp.Model.DocListModel;
import com.thoughtinterac.realestateapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AzaharSheikh on 18-11-2016.
 */
public class MyDocActivity extends AppCompatActivity {
    ArrayList<String> docList,docStatusList, docDetails;

    private MyDocListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_doc_layout);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        List<DocListModel> docListMain = new ArrayList<DocListModel>();
        docList= new ArrayList();
        docStatusList= new ArrayList();
        docDetails = new ArrayList();
        docList.add("Sale Deed/Title deed /Conveyance Deed");
        docList.add("RTC Extracts");
        docList.add("NOC from Electricity Deptt/Pollution Control Board/Water Works/ Air Port Authority");
        docList.add("Supplementary agreement/Ratification Deed");
        docStatusList.add("true");
        docStatusList.add("true");
        docStatusList.add("false");
        docStatusList.add("true");
        docDetails.add("HSJADJSAN2672482482");
        docDetails.add("ADHARC CARD Number");
        docDetails.add("OC no.12212123");
        docDetails.add("Noc staus ");
        for(int i =0 ; i<docList.size();i++)
        {
            DocListModel list = new DocListModel();
            list.setDoc_name(docList.get(i).toString());
            list.setDoc_status(docStatusList.get(i).toString());
            list.setDoc_deatils(docDetails.get(i).toString());
            docListMain.add(list);
        }
        ListView listView = (ListView)findViewById(R.id.doc_list);
        listView.setDivider(null);

        View header = getLayoutInflater().inflate(R.layout.my_doc_list_header, listView, false);
        adapter= new MyDocListAdapter(MyDocActivity.this,docListMain);
        listView.addHeaderView(header, null, false);
        listView.setAdapter(adapter);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;

    }
}
