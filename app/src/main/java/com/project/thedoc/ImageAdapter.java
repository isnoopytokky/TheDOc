package com.project.thedoc;

/**
 * Created by Pariwat on 14/3/2558.
 */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class ImageAdapter extends BaseAdapter {
    private Context context;
    private final String[] mobileValues;

    public ImageAdapter(Context context, String[] mobileValues) {
        this.context = context;
        this.mobileValues = mobileValues;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.item, null);

            // set image based on selected text
            ImageView imageView = (ImageView) gridView
                    .findViewById(R.id.grid_item_image);
            ImageView imageView1 = (ImageView) gridView
                    .findViewById(R.id.grid_item_image1);
            ImageView imageView2 = (ImageView) gridView
                    .findViewById(R.id.grid_item_image2);
            String mobile = mobileValues[position];


        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    @Override
    public int getCount() {
        return mobileValues.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
