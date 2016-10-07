package com.thoughtinterac.realestateapp.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.thoughtinterac.realestateapp.CustomAdapter.MyDocListAdapter;
import com.thoughtinterac.realestateapp.Model.DocListModel;
import com.thoughtinterac.realestateapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AzaharSheikh on 28-09-2016.
 */
public class MyDocFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ArrayList<String> docList,docStatusList, docDetails;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private MyDocListAdapter adapter;

    public MyDocFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CafeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyDocFragment newInstance(String param1, String param2) {
        MyDocFragment fragment = new MyDocFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.my_doc_layout, container, false);
        //Toast.makeText(getActivity(),"My doc Here",Toast.LENGTH_LONG).show();
        List<DocListModel> docListMain = new ArrayList<DocListModel>();
        docList= new ArrayList();
        docStatusList= new ArrayList();
        docDetails = new ArrayList();
        docList.add("PAN");
        docList.add("AADHAR");
        docList.add("RC");
        docList.add("NOC");
        docStatusList.add("true");
        docStatusList.add("true");
        docStatusList.add("false");
        docStatusList.add("true");
        docDetails.add("HSJADJSAN2672482482");
        docDetails.add("ADHARC CARD Number");
        docDetails.add("Rc no.12212123");
        docDetails.add("Noc staus ");
        for(int i =0 ; i<docList.size();i++)
        {
            DocListModel list = new DocListModel();
            list.setDoc_name(docList.get(i).toString());
            list.setDoc_status(docStatusList.get(i).toString());
            list.setDoc_deatils(docDetails.get(i).toString());
            docListMain.add(list);
        }
        ListView listView = (ListView) rootView.findViewById(R.id.doc_list);
        ViewGroup header = (ViewGroup)inflater.inflate(R.layout.my_doc_list_header, listView, false);
        adapter= new MyDocListAdapter(getActivity(),docListMain);
        listView.addHeaderView(header, null, false);
        listView.setAdapter(adapter);
        return rootView;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
