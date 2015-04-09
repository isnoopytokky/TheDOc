package com.project.thedoc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by Pariwat on 14/3/2558.
 */
public class Queue extends Fragment {
    View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.web_view, container, false);

        WebView webview =  (WebView) rootview.findViewById(R.id.activity_main_webview);

        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.loadUrl("http://deafhelper.parseapp.com/queue_information/VMeoDcRp9G");
        return rootview;
    }

}