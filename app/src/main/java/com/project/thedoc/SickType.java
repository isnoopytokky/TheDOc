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
            "Case12"
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
        rootview = inflater.inflate(R.layout.sick_type, container, false);

        final ArrayList SickTypeName = new ArrayList();
        SickTypeName.add("มีไข้");
        SickTypeName.add("ไอ");
        SickTypeName.add("คลืนไส้");
        SickTypeName.add("ปวดหัว");
        SickTypeName.add("ตาแดง");
        SickTypeName.add("เจ็บคอ");
        SickTypeName.add("ร้อนใน");
        SickTypeName.add("ผื่นคัน");
        SickTypeName.add("ปวดข้อ");
        SickTypeName.add("ท้องเสีย");
        SickTypeName.add("ปัสสาวะสีเข้ม");
        SickTypeName.add("เลือดออก");



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
                            GetSickType += "\n" + SickTypeName.get(i);
                        }else
                        {
                            GetSickType += SickTypeName.get(i);
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
               // Toast.makeText(getActivity(), parent.getAdapter().getItem(position).toString(),
                        //Toast.LENGTH_SHORT).show();
                image = (ImageView) view.findViewById(R.id.grid_item_image);

                //view.setBackgroundColor(Color.RED);
                Items_Boolean.put(
                        parent.getAdapter().getItem(position).toString(),
                        !Items_Boolean.get(parent.getAdapter().getItem(position).toString())
                );

                if(Items_Boolean.get(parent.getAdapter().getItem(position).toString()) == false)
                {
                    if(position == 0) {
                        image.setImageResource(R.drawable.case_one);
                    }
                    if(position == 1) {
                        image.setImageResource(R.drawable.case_two);
                    }
                    if(position == 2) {
                        image.setImageResource(R.drawable.case_three);
                    }
                    if(position == 3) {
                        image.setImageResource(R.drawable.case_four);
                    }
                    if(position == 4) {
                        image.setImageResource(R.drawable.case_five);
                    }
                    if(position == 5) {
                        image.setImageResource(R.drawable.case_six);
                    }
                    if(position == 6) {
                        image.setImageResource(R.drawable.case_seven);
                    }
                    if(position == 7) {
                        image.setImageResource(R.drawable.case_eigth);
                    }
                    if(position == 8) {
                        image.setImageResource(R.drawable.case_nine);
                    }
                    if(position == 9) {
                        image.setImageResource(R.drawable.case_ten);
                    }
                    if(position == 10) {
                        image.setImageResource(R.drawable.case_eleven);
                    }
                    if(position == 11) {
                        image.setImageResource(R.drawable.case_twelve);
                    }

                }
                else {
                    if(position == 0) {
                        image.setImageResource(R.drawable.case_one_gray);
                    }
                    if (position == 1) {
                        image.setImageResource(R.drawable.case_two_gray);
                    }
                    if (position == 2) {
                        image.setImageResource(R.drawable.case_three_gray);
                    }
                    if (position == 3) {
                        image.setImageResource(R.drawable.case_four_gray);
                    }
                    if (position == 4) {
                        image.setImageResource(R.drawable.case_five_gray);
                    }
                    if (position == 5) {
                        image.setImageResource(R.drawable.case_six_gray);
                    }
                    if (position == 6) {
                        image.setImageResource(R.drawable.case_seven_gray);
                    }
                    if (position == 7) {
                        image.setImageResource(R.drawable.case_eight_gray);
                    }
                    if (position == 8) {
                        image.setImageResource(R.drawable.case_nine_gray);
                    }
                    if (position == 9) {
                        image.setImageResource(R.drawable.case_ten_gray);
                    }
                    if (position == 10) {
                        image.setImageResource(R.drawable.case_eleven_gray);
                    }
                    if (position == 11) {
                        image.setImageResource(R.drawable.case_twelve_gray);
                    }
                }
            }
        });

        return rootview;
    }

}