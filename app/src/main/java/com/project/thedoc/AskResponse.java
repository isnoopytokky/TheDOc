package com.project.thedoc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Pariwat on 4/4/2558.
 */
public class AskResponse extends Fragment {
    View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.ask_reponse, container, false);

        Button btn_yes_res = (Button) rootview.findViewById(R.id.btn_yes_res);
        Button btn_no_res = (Button) rootview.findViewById(R.id.btn_no_res);

        btn_yes_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment objFragment = null;
                switch (v.getId()) {
                    case R.id.btn_yes_res:
                        objFragment = new SickType();
                        // objFragment = new SimpleScannerFragment();
                        break;
                }
                // update the main content by replacing fragments
                FragmentManager fragmentManager =getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, objFragment)
                        .commit();
            }
        });

        btn_no_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment objFragment = null;
                switch (v.getId()) {
                    case R.id.btn_no_res:
                        objFragment = new SickType();
                        // objFragment = new SimpleScannerFragment();
                        break;
                }
                // update the main content by replacing fragments
                FragmentManager fragmentManager =getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, objFragment)
                        .commit();
            }
        });


        return rootview;
    }
}
