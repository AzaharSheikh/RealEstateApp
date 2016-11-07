package com.thoughtinterac.realestateapp.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.thoughtinterac.realestateapp.CustomAdapter.MyDocListAdapter;
import com.thoughtinterac.realestateapp.CustomAdapter.SoldFlatsAdapter;
import com.thoughtinterac.realestateapp.CustomAdapter.SoldFlatsAdapter;
import com.thoughtinterac.realestateapp.CustomAdapter.SoldFlatsAdapter;
import com.thoughtinterac.realestateapp.Model.DocListModel;
import com.thoughtinterac.realestateapp.Model.SoldFlatsModel;
import com.thoughtinterac.realestateapp.Model.SoldFlatsModel;
import com.thoughtinterac.realestateapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AshwiniBadgujar on 07-10-2016.
 */
public class RealtorSoldFlatsListActivity extends AppCompatActivity {
    ArrayList<String> NameoftheAuthor,FlatNo, FlatType,DateofPurchase,OutOfResale,Number;
    private SoldFlatsAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.realator_flats_list);
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
        Number.add("3");
        Number.add("4");
        Number.add("5");

        NameoftheAuthor.add("Azahar S.");
        NameoftheAuthor.add("Ashwini B.");
        NameoftheAuthor.add("Krishna G.");
        NameoftheAuthor.add("Dadoos B.");
        NameoftheAuthor.add("Anuradha R.");

        FlatNo.add("101");
        FlatNo.add("102");
        FlatNo.add("103");
        FlatNo.add("104");
        FlatNo.add("105");

        FlatType.add("1 BHK");
        FlatType.add("2 BHK");
        FlatType.add("3 BHK");
        FlatType.add("1 BHK");
        FlatType.add("2 BHK");

        DateofPurchase.add("10-Mar-2016");
        DateofPurchase.add("20-Apr-2016");
        DateofPurchase.add("10-Feb-2016");
        DateofPurchase.add("20-Feb-2016 ");
        DateofPurchase.add("20-Feb-2016 ");

        OutOfResale.add("10-Mar-2016");
        OutOfResale.add("20-Apr-2016");
        OutOfResale.add("10-Feb-2016");
        OutOfResale.add("20-Feb-2016 ");
        OutOfResale.add("20-Feb-2016 ");

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
        ListView listView = (ListView)findViewById(R.id.realator_flats_list_view);

        adapter= new SoldFlatsAdapter(RealtorSoldFlatsListActivity.this,flatListItems);

        listView.setAdapter(adapter);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;

    }


}


