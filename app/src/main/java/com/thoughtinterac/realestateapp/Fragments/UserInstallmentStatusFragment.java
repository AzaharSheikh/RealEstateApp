package com.thoughtinterac.realestateapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.thoughtinterac.realestateapp.CustomAdapter.InstallMentStatusAdapter;
import com.thoughtinterac.realestateapp.Model.InstallMentStatusModel;
import com.thoughtinterac.realestateapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AzaharSheikh on 29-10-2016.
 */
public class UserInstallmentStatusFragment extends Fragment {
    ArrayList<String> installmentStatusID, installmentStatusMsg, installmentStatusDate,installmentStatusAmt;

    InstallMentStatusAdapter adapter;
    public UserInstallmentStatusFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.user_installment_status, container, false);
        installmentStatusID = new ArrayList();
        installmentStatusMsg = new ArrayList();
        installmentStatusDate = new ArrayList();
        installmentStatusAmt = new ArrayList();


        installmentStatusID.add("1");
        installmentStatusID.add("2");
        installmentStatusID.add("3");
        installmentStatusID.add("4");
        installmentStatusID.add("5");


        installmentStatusMsg.add("Token amount");
        installmentStatusMsg.add("First Installment");
        installmentStatusMsg.add("2nd Installment");
        installmentStatusMsg.add("3rd Installment");
        installmentStatusMsg.add("Final Installment due after");


        installmentStatusDate.add("01/02/2016");
        installmentStatusDate.add("02/03/2016");
        installmentStatusDate.add("07/05/2016");
        installmentStatusDate.add("Pending.");
        installmentStatusDate.add("Pending.");


        installmentStatusAmt.add("15000");
        installmentStatusAmt.add("25000");
        installmentStatusAmt.add("5000");
        installmentStatusAmt.add("5000");
        installmentStatusAmt.add("5000");


        List<InstallMentStatusModel> projectListMain = new ArrayList<InstallMentStatusModel>();
        for(int i = 0; i< installmentStatusMsg.size(); i++)
        {
            InstallMentStatusModel list = new InstallMentStatusModel();
            list.setInstallMentStatusId(installmentStatusID.get(i).toString());
            list.setInstallMentStatusMessage(installmentStatusMsg.get(i).toString());
            list.setInstallMentStatusDate(installmentStatusDate.get(i).toString());
            list.setInstallMentStatusAmt(installmentStatusAmt.get(i).toString());
            projectListMain.add(list);
        }
        ListView listView = (ListView)rootView.findViewById(R.id.listview_userinstallment);

        adapter= new InstallMentStatusAdapter(getActivity(),projectListMain);

        listView.setAdapter(adapter);
        return rootView;
    }
}
