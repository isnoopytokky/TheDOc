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

            titleText.setText(title);
            image.setImageResource(R.drawable.a);
            //image.setAlpha(Alpha_90);
        }
    }
}