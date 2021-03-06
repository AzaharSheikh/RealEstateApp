package com.thoughtinterac.realestateapp.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.thoughtinterac.realestateapp.Activities.LoginActivity;
import com.thoughtinterac.realestateapp.Activities.MainActivity;
import com.thoughtinterac.realestateapp.Activities.RealtorMainPage;
import com.thoughtinterac.realestateapp.R;

/**
 * Created by AzaharSheikh on 28-09-2016.
 */
public class MyProfileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    String str_user_name= "Azahar";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    static  TextView txt_name,txt_project_name,txt_email,txt_mobile,txt_address,txt_pan,txt_bank,txt_job_decs;
ScrollView sc_welcome_layout;
    ImageView iv_profile_pic;

    private OnFragmentInteractionListener mListener;

    public MyProfileFragment() {
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
    public static MyProfileFragment newInstance(String param1, String param2) {
        MyProfileFragment fragment = new MyProfileFragment();
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
        View rootView = inflater.inflate(R.layout.user_profile, container, false);
        txt_name = (TextView) rootView.findViewById(R.id.txt_name);
        txt_job_decs=(TextView)rootView.findViewById(R.id.txt_job_decs);
        txt_project_name=(TextView)rootView.findViewById(R.id.txt_project_name);
        txt_email=(TextView)rootView.findViewById(R.id.txt_email);
        txt_mobile=(TextView)rootView.findViewById(R.id.txt_mobile);
        txt_address=(TextView)rootView.findViewById(R.id.txt_address);
        txt_pan=(TextView)rootView.findViewById(R.id.txt_pan);
        txt_bank=(TextView)rootView.findViewById(R.id.txt_bank);

        sc_welcome_layout=(ScrollView)rootView.findViewById(R.id.sc_welcome_layout);
        iv_profile_pic = (ImageView)rootView.findViewById(R.id.iv_profile_pic);
        if(MainActivity.str_male_female== null)
        {
            MainActivity.str_male_female="Male";
        }
        iv_profile_pic.setImageResource(R.drawable.user);
        if(MainActivity.str_male_female.toString().equalsIgnoreCase("Female"))
        {

            //iv_profile_pic.setImageResource(R.drawable.femaledp);
        }else
        {
            iv_profile_pic.setImageResource(R.drawable.user);
        }
        try{
            if(RealtorMainPage.flag==0)
            {
                sc_welcome_layout.setVisibility(View.VISIBLE);
            }else
            {
                sc_welcome_layout.setVisibility(View.GONE);
            }

        }catch(Exception e){}
        if(LoginActivity.imageurl!=null) {
            Picasso.with(getActivity()).load(LoginActivity.imageurl).into(iv_profile_pic);
        }
         //setData();




        //Toast.makeText(getActivity(),"My Profile Here",Toast.LENGTH_LONG).show();
        return rootView;

    }

    public static void setData() {
        txt_name.setText(MainActivity.str_user_name);
        txt_project_name.setText(MainActivity.str_project_name);
        txt_job_decs.setText(MainActivity.str_user_job);
        txt_email.setText(MainActivity.str_user_email);
        txt_mobile.setText(MainActivity.str_user_mobile);
        txt_address.setText(MainActivity.str_user_address);
        txt_pan.setText(MainActivity.str_user_pan);
        txt_bank.setText(MainActivity.str_user_bank);


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
