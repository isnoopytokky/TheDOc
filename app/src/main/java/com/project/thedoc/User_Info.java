package com.project.thedoc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

/**
 * Created by Pariwat on 10/3/2558.
 */
public class User_Info extends Fragment{
    View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.user_info, container, false);
        Button btn_scanQR = (Button) rootview.findViewById(R.id.button_complete);

        btn_scanQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment objFragment = null;
                switch (v.getId()) {
                    case R.id.button_complete:
                        objFragment = new Scan_Qrcode();
                        break;
                }
                // update the main content by replacing fragments
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, objFragment)
                        .commit();
            }
        });

        WebView webview =  (WebView) rootview.findViewById(R.id.activity_main_webview_user);

        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("http://deafhelper.parseapp.com/add_data");
        webview.setWebViewClient(new WebViewClient());
        return rootview;
    }

}
