package com.example.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smex_app_android.R;

import java.util.List;

public class ImageAdapter extends BaseAdapter {

    private Context context;

    private int layout;
    private List<Integer> imageIds;
    private List<String> imageNames;

    public ImageAdapter(Context context, int layout, List<Integer> imageIds, List<String> imageNames) {
        this.context = context;
        this.layout = layout;
        this.imageIds = imageIds;
        this.imageNames = imageNames;
    }

    @Override
    public int getCount() {
        return imageIds.size();
    }

    @Override
    public Object getItem(int position) {
        return imageIds.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        ImageView imageView = view.findViewById(R.id.img);
        TextView textView = view.findViewById(R.id.txt);
        imageView.setImageResource(imageIds.get(position));
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setText(imageNames.get(position));
        return view;
    }
}
