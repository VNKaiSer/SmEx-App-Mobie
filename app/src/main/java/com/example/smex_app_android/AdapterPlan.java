package com.example.smex_app_android;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.entity.Plan;

import java.util.List;

public class AdapterPlan  extends BaseAdapter {

    private Context context;
    private  int layout;
    private List<Plan> listPlan;

    public AdapterPlan(Context context, int layout, List<Plan> listPlan) {
        this.context = context;
        this.layout = layout;
        this.listPlan = listPlan;
    }

    @Override
    public int getCount() {
        return listPlan.size();
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

        Plan plan = listPlan.get(i);

        TextView title = view.findViewById(R.id.titlePlan);
        TextView price = view.findViewById(R.id.pricePlan);
        SeekBar seekBar = view.findViewById(R.id.seekbar);


        title.setText(plan.getTitle());
        price.setText(plan.getPrice()+"");
        seekBar.setEnabled(false);

        return view;
    }
}
