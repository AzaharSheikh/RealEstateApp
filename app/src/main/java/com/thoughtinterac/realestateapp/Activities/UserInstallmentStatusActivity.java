package com.thoughtinterac.realestateapp.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;

import com.thoughtinterac.realestateapp.CustomAdapter.InstallMentStatusAdapter;
import com.thoughtinterac.realestateapp.Model.InstallMentStatusModel;
import com.thoughtinterac.realestateapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AzaharSheikh on 29-10-2016.
 */
public class UserInstallmentStatusActivity extends AppCompatActivity {
    ArrayList<String> installmentStatusID, installmentStatusMsg, installmentStatusDate;

    InstallMentStatusAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_installment_status);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        installmentStatusID = new ArrayList();
        installmentStatusMsg = new ArrayList();
        installmentStatusDate = new ArrayList();


        installmentStatusID.add("1");
        installmentStatusID.add("2");
        installmentStatusID.add("3");
        installmentStatusID.add("4");
        installmentStatusID.add("5");

        installmentStatusMsg.add("Token amount received");
        installmentStatusMsg.add("First Installment received");
        installmentStatusMsg.add("2nd Installment received");
        installmentStatusMsg.add("3rd Installment due after construction of first floor done");
        installmentStatusMsg.add("Final Installment due after");

        installmentStatusDate.add("01/02/2016");
        installmentStatusDate.add("02/03/2016");
        installmentStatusDate.add("07/05/2016");
        installmentStatusDate.add("");
        installmentStatusDate.add("12/12/2016");


        List<InstallMentStatusModel> projectListMain = new ArrayList<InstallMentStatusModel>();
        for(int i = 0; i< installmentStatusMsg.size(); i++)
        {
            InstallMentStatusModel list = new InstallMentStatusModel();
            list.setInstallMentStatusId(installmentStatusID.get(i).toString());
            list.setInstallMentStatusMessage(installmentStatusMsg.get(i).toString());
            list.setInstallMentStatusDate( installmentStatusDate.get(i).toString());
            projectListMain.add(list);
        }
        ListView listView = (ListView)findViewById(R.id.listview_userinstallment);

        adapter= new InstallMentStatusAdapter(this,projectListMain);

        listView.setAdapter(adapter);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;

    }
}
