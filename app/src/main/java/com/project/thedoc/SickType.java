package com.project.thedoc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import org.askerov.dynamicgrid.DynamicGridView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pariwat on 14/3/2558.
 */
public class SickType extends Fragment {
    View rootview;
    private ImageView image;

    static final String[] MOBILE_OS = new String[] { "Android", "iOS",
            "Windows", "Blackberry" };

    static final String[] Items_List = new String[] {
            "Case1",
            "Case2",
            "Case3",
            "Case4",
            "Case5",
            "Case6",
            "Case7",
            "Case8",
            "Case9"
    };

    final Map<String, Boolean> Items_Boolean = new HashMap<String, Boolean>();
    Boolean a = false;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Items_Boolean.put("Case1", false);
        Items_Boolean.put("Case2", false);
        Items_Boolean.put("Case3", false);
        Items_Boolean.put("Case4", false);
        Items_Boolean.put("Case5", false);
        Items_Boolean.put("Case6", false);
        Items_Boolean.put("Case7", false);
        Items_Boolean.put("Case8", false);
        Items_Boolean.put("Case9", false);

        rootview = inflater.inflate(R.layout.sick_type, container, false);

        GridView gridview = (GridView) rootview.findViewById(R.id.gridView);
        gridview = (DynamicGridView) rootview.findViewById(R.id.dynamic_grid);
        gridview.setAdapter(new DynamicAdapter(getActivity(),
                new ArrayList<String>(Arrays.asList(Items_List)),
                getResources().getInteger(R.integer.column_count)));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int Alpha_100 = 100;
                int Alpha_90 = 90;
                Toast.makeText(getActivity(), parent.getAdapter().getItem(position).toString(),
                        Toast.LENGTH_SHORT).show();
                image = (ImageView) view.findViewById(R.id.grid_item_image);
                image.setImageResource(R.drawable.ic_drawer);

                //view.setBackgroundColor(Color.RED);
                Items_Boolean.put(
                        parent.getAdapter().getItem(position).toString(),
                        !Items_Boolean.get(parent.getAdapter().getItem(position).toString())
                );
                if(Items_Boolean.get(parent.getAdapter().getItem(position).toString()) == true)
                {
                    image.setImageResource(R.drawable.ic_drawer);
                    //image.setAlpha(Alpha_100);
                }
                else
                {
                    image.setImageResource(R.drawable.icon);
                    //image.setAlpha(Alpha_90);
                }
            }
        });

        return rootview;
    }

}