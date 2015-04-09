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
public class AskName extends Fragment {

    View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.ask_name, container, false);


        Button button_next = (Button) rootview.findViewById(R.id.button_next);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment objFragment = null;
                switch (v.getId()) {
                    case R.id.button_next:
                        objFragment = new AppointmentDate();
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
