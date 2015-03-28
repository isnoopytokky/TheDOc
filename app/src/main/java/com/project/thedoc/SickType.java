package com.project.thedoc;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
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

    static final String[] Items_List = new String[] {
            "Case1",
            "Case2",
            "Case3",
            "Case4",
            "Case5",
            "Case6",
            "Case7",
            "Case8",
            "Case9",
            "Case10",
            "Case11",
            "Case12",
            "Case13",
            "Case14",
            "Case15",
            "Case16",
            "Case17",
            "Case18"
    };

    final Map<String, Boolean> Items_Boolean = new HashMap<String, Boolean>();
    Boolean a = false;
    String GetSickType = "" ;

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
        Items_Boolean.put("Case10", false);
        Items_Boolean.put("Case11", false);
        Items_Boolean.put("Case12", false);
        Items_Boolean.put("Case13", false);
        Items_Boolean.put("Case14", false);
        Items_Boolean.put("Case15", false);
        Items_Boolean.put("Case16", false);
        Items_Boolean.put("Case17", false);
        Items_Boolean.put("Case18", false);

        rootview = inflater.inflate(R.layout.sick_type, container, false);


        GridView gridview = (GridView) rootview.findViewById(R.id.gridView);
        gridview = (DynamicGridView) rootview.findViewById(R.id.dynamic_grid);
        Button Btn_Save = (Button) rootview.findViewById(R.id.button_save);

        Btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetSickType = "" ;
                for(int i=0; i<Items_Boolean.size();i++)
                {
                    if(Items_Boolean.get(Items_List[i]) == true)
                    {
                        if(GetSickType != "")
                        {
                            GetSickType += "\n" + Items_List[i];
                        }else
                        {
                            GetSickType += Items_List[i];
                        }
                    }
                }

                AlertDialog.Builder builder1 = new AlertDialog.Builder(rootview.getContext());
                builder1.setMessage(GetSickType);
                builder1.setTitle("อาการป่วยของคุณ");
                builder1.setCancelable(true);
                builder1.setPositiveButton("แก้ไข",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();

                            }
                        });
                builder1.setNegativeButton("ยืนยัน",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Fragment objFragment = null;
                                objFragment = new Contact_Detail();
                                FragmentManager fragmentManager =getFragmentManager();
                                fragmentManager.beginTransaction()
                                        .replace(R.id.container, objFragment)
                                        .commit();

                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });

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
                image.setImageResource(R.drawable.a_gray);

                //view.setBackgroundColor(Color.RED);
                Items_Boolean.put(
                        parent.getAdapter().getItem(position).toString(),
                        !Items_Boolean.get(parent.getAdapter().getItem(position).toString())
                );
                if(Items_Boolean.get(parent.getAdapter().getItem(position).toString()) == true)
                {
                    image.setImageResource(R.drawable.a_gray);
                    //image.setAlpha(Alpha_100);
                }
                else
                {
                    image.setImageResource(R.drawable.a);
                    //image.setAlpha(Alpha_90);
                }
            }
        });

        return rootview;
    }

}