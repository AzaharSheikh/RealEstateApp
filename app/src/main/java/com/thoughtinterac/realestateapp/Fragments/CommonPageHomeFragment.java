package com.thoughtinterac.realestateapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.thoughtinterac.realestateapp.R;

/**
 * Created by AzaharSheikh on 27-10-2016.
 */
public class CommonPageHomeFragment extends Fragment {
    WebView  webHome;
    public CommonPageHomeFragment() {
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.common_page_home_page, container, false);
        webHome = (WebView)rootView.findViewById(R.id.webHome);

        webHome.getSettings().setJavaScriptEnabled(true);
        webHome.getSettings().setLoadWithOverviewMode(true);
        webHome.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webHome.getSettings().setUseWideViewPort(true);
        webHome.getSettings().setBuiltInZoomControls(true);
        webHome.getSettings().setPluginState(WebSettings.PluginState.ON);
        //webHome.getSettings().setPluginsEnabled(true);
        webHome.setWebViewClient(new HelloWebViewClient());
        webHome.loadUrl("file:///android_asset/www/index.html");
        return rootView;
    }
    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }

}

