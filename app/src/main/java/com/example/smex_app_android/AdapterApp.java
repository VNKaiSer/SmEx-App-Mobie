package com.example.smex_app_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.entity.App;
import com.example.entity.Plan;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class AdapterApp extends BaseAdapter {

    private Context context;
    private  int layout;
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
        ShapeableImageView icon = view.findViewById(R.id.iconApp);
        String iconName = app.getIcon();
//        int resId = context.getResources().getIdentifier(iconName, "drawable", context.getPackageName());

        title.setText(app.getText());
//        icon.setImageResource(resId);


        return view;
    }
}
