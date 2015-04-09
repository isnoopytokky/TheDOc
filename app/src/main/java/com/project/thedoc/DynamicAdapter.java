package com.project.thedoc;

/**
 * Created by Pariwat on 15/3/2558.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import org.askerov.dynamicgrid.BaseDynamicGridAdapter;

import java.util.List;


public class DynamicAdapter extends BaseDynamicGridAdapter {
    public DynamicAdapter(Context context, List<?> items, int columnCount) {
        super(context, items, columnCount);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.build(getItem(position).toString());
        return convertView;
    }

    private class ViewHolder {
        private TextView titleText;
        private ImageView image;
        private int Alpha_90 = 90;
        private ViewHolder(View view) {
            titleText = (TextView) view.findViewById(R.id.grid_item_title);
            image = (ImageView) view.findViewById(R.id.grid_item_image);
        }

        void build(String title) {

            if(title == "Case1") {
                titleText.setText(title);
                image.setImageResource(R.drawable.case_one);
            }
            if(title == "Case2") {
                titleText.setText(title);
                image.setImageResource(R.drawable.case_two);
            }
            if(title == "Case3") {
                titleText.setText(title);
                image.setImageResource(R.drawable.case_three);
            }
            if(title == "Case4") {
                titleText.setText(title);
                image.setImageResource(R.drawable.case_four);
            }
            if(title == "Case5") {
                titleText.setText(title);
                image.setImageResource(R.drawable.case_five);
            }
            if(title == "Case6") {
                titleText.setText(title);
                image.setImageResource(R.drawable.case_six);
            }
            if(title == "Case7") {
                titleText.setText(title);
                image.setImageResource(R.drawable.case_seven);
            }
            if(title == "Case8") {
                titleText.setText(title);
                image.setImageResource(R.drawable.case_eigth);
            }
            if(title == "Case9") {
                titleText.setText(title);
                image.setImageResource(R.drawable.case_nine);
            }
            if(title == "Case10") {
                titleText.setText(title);
                image.setImageResource(R.drawable.case_ten);
            }
            if(title == "Case11") {
                titleText.setText(title);
                image.setImageResource(R.drawable.case_eleven);
            }
            if(title == "Case12") {
                titleText.setText(title);
                image.setImageResource(R.drawable.case_twelve);
            }
         }
    }
}