package com.thoughtinterac.realestateapp.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtinterac.realestateapp.Activities.MainActivity;
import com.thoughtinterac.realestateapp.Activities.MyDocActivity;
import com.thoughtinterac.realestateapp.Activities.RealtorMainPage;
import com.thoughtinterac.realestateapp.Activities.UserInstallmentStatusActivity;
import com.thoughtinterac.realestateapp.Activities.UserMyProject;
import com.thoughtinterac.realestateapp.Activities.UserProjectStatusActivity;
import com.thoughtinterac.realestateapp.R;

/**
 * Created by AshwiniBadgujar on 14-10-2016.
 */
public class User_Welcome_Page extends Fragment {
    TextView name_text;
    WebView webView_welcome_user_slider;
    public User_Welcome_Page() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.welcome_user, container, false);
        name_text=(TextView)rootView.findViewById(R.id.name_text);
        name_text.setText(MainActivity.str_user_name);
        if(MainActivity.str_user_name.equalsIgnoreCase("")) {
            name_text.setText(RealtorMainPage.str_user_name);
        }
        ImageView img_project_status = (ImageView)rootView.findViewById(R.id.img_project_status);
        ImageView img_user_installment_paid = (ImageView)rootView.findViewById(R.id.img_user_installment_paid);
        ImageView img_myproject = (ImageView)rootView.findViewById(R.id.img_myproject);
        ImageView img_mydocuments = (ImageView)rootView.findViewById(R.id.img_mydocuments);
        webView_welcome_user_slider=(WebView)rootView.findViewById(R.id.webView_welcome_user_slider);
        webView_welcome_user_slider.getSettings().setJavaScriptEnabled(true);
        webView_welcome_user_slider.getSettings().setLoadWithOverviewMode(true);
        webView_welcome_user_slider.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView_welcome_user_slider.getSettings().setUseWideViewPort(true);
        webView_welcome_user_slider.getSettings().setBuiltInZoomControls(true);
        webView_welcome_user_slider.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView_welcome_user_slider.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView_welcome_user_slider.setBackgroundColor(Color.TRANSPARENT);
       // webView_welcome_user_sliderme.getSettings().setPluginsEnabled(true);
        webView_welcome_user_slider.setWebViewClient(new HelloWebViewClient());
        webView_welcome_user_slider.loadUrl("file:///android_asset/www/welcome_user_slider/index.html");

        img_project_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),UserProjectStatusActivity.class);
                startActivity(i);
            }
        });
        img_user_installment_paid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), UserInstallmentStatusActivity.class);
                startActivity(i);
            }
        });
        img_myproject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), UserMyProject.class);
                startActivity(i);
            }
        });
        img_mydocuments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MyDocActivity.class);
                startActivity(i);
            }
        });
        return rootView;
    }
    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }
}
