package com.project.thedoc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

/**
 * Created by Pariwat on 10/3/2558.
 */
public class testvideo extends Fragment {

    View rootview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.test_video, container, false);
       VideoView videoView = (VideoView) rootview.findViewById(R.id.mediaController);




        return rootview;
    }

}
