package com.example.adapter;

import com.example.smex_app_android.SettingGeneral;
import com.example.smex_app_android.Spending;
import com.google.android.material.imageview.ShapeableImageView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.entity.App;
import com.example.entity.Plan;
import com.example.smex_app_android.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.io.File;
import java.util.List;

public class AdapterApp extends BaseAdapter {

    private Context context;
    private int layout;
    private List<App> listApp;

    public AdapterApp(Context context, int layout, List<App> listApp) {
        this.context = context;
        this.layout = layout;
        this.listApp = listApp;
    }

    @Override
    public int getCount() {
        return listApp.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(layout, null);

        App app = listApp.get(i);

        TextView title = view.findViewById(R.id.textApp);
        TextView detail = view.findViewById(R.id.detail);
        ImageView icon = view.findViewById(R.id.iconApp);

        String iconName = app.getIcon();
        int resId = context.getResources().getIdentifier(iconName, "drawable", context.getPackageName());
        if (detail != null) {

            if (resId != 0) {
                detail.setVisibility(View.GONE);
                icon.setVisibility(View.GONE);
            } else {
                detail.setText(app.getIcon());
            }
        }

        icon.setImageResource(resId);
        title.setText(app.getText());




        return view;
    }
}
