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
 * Created by Pariwat on 10/3/2558.
 */
public class History extends Fragment {

    View rootview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.history, container, false);

        Button button_no = (Button) rootview.findViewById(R.id.btn_no);
        button_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment objFragment = null;
                switch (v.getId()) {
                    case R.id.btn_no:
                        objFragment = new Hospital_Info();
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


        Button button_yes = (Button) rootview.findViewById(R.id.btn_yes);
        button_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment objFragment = null;
                switch (v.getId()) {
                    case R.id.btn_yes:
                        objFragment = new AskName();
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
